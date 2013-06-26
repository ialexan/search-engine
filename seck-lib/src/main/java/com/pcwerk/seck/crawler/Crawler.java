package com.pcwerk.seck.crawler;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Element;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;



public class Crawler implements Runnable {
	//Seconds to wait before killing a thread;
	final static int MAX_FAILURES=3;

	String dbFileName;
	String baseUrl;
	int depth;
	int threads;

	//Shared Data
	SqlJetDb db;
	Set<String> visitedBackingSet;
	Set<String> visited;
	Queue<CrawlEntry> frontier;

	public static void crawlInfo(String dbFileName) {
		File dbFile = new File(dbFileName);

		try{
			SqlJetDb infoDb = SqlJetDb.open(dbFile, false);

			ISqlJetTable pages = infoDb.getTable("urls");

			infoDb.beginTransaction(SqlJetTransactionMode.READ_ONLY);
			ISqlJetCursor cursor = pages.open();
			try{
				if (!cursor.eof()){
					do{
						String url = cursor.getString("url");
						String anchor = cursor.getString("anchor");
						String content = cursor.getString("content");
						try {
							Webpage newPage = new Webpage(url, anchor, content);
							System.out.println("====================================================");
							System.out.println(newPage.toString());
							System.out.println("====================================================");
						} catch (MalformedURLException e) {
						}
					}while(cursor.next());
				}}finally{
					cursor.close();
					infoDb.commit();
					infoDb.close();
				}
		}
		catch (SqlJetException e){
			e.printStackTrace();
			System.out.println( "Exception in SqlJet" );
		}
	}

	public Crawler(String dbFileName, String baseUrl, int depth, int threads) {
		super();
		this.dbFileName = dbFileName;
		this.baseUrl = baseUrl;
		this.depth = depth;
		this.threads = threads;
	}

	public void crawl() throws InterruptedException, ExecutionException{
		File dbFile = new File(dbFileName);
		dbFile.delete();

		try{
			System.out.println("Going to create DB");
			db = SqlJetDb.open(dbFile, true);

			//Create our DB structure
			db.beginTransaction(SqlJetTransactionMode.WRITE);
			try{
				db.createTable("CREATE TABLE urls (url TEXT NOT NULL PRIMARY KEY, anchor TEXT NOT NULL, content TEXT NOT NULL, title)");
				db.createTable("CREATE TABLE media (url, metadatakey, metadatavalue)");
			}finally{
				db.commit();
			}
			
			System.out.println("Created DB");

			ExecutorService threadPool = Executors.newFixedThreadPool(threads);

			visitedBackingSet = new HashSet<String>();
			visited = Collections.synchronizedSet(visitedBackingSet);

			frontier = new ConcurrentLinkedQueue<CrawlEntry>();

			frontier.add(new CrawlEntry(baseUrl,"", 0));
			visited.add(baseUrl);

			List<Future<?>> threadList = new LinkedList<Future<?>>();

			for(int i = 0; i < threads; i++){
				System.out.println("Adding thread " + i);
				threadList.add(threadPool.submit(this));
			}

			for(Future<?> future : threadList){
				future.get();
			}

			threadPool.shutdownNow();

			db.close();
		}
		catch (SqlJetException e){
			e.printStackTrace();
		}
	}

	public void run(){
		System.out.println("Thread starting");
		int failures = 0;
		while(true){
			while (frontier.size() == 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				failures++;
				if(failures > MAX_FAILURES){
					return;
				}
			}
			failures = 0;
			CrawlEntry currentEntry = frontier.poll();
			System.out.println("<" + Thread.currentThread().getId() + "> | Grabbing url: " + currentEntry.url);
			System.out.println("<" + Thread.currentThread().getId() + "> | At depth: " + currentEntry.depth);
			Webpage page = null;
			try {
				page = new Webpage(currentEntry.url, currentEntry.anchor);
			} catch(IOException e) {
				//If can't get our page, it could be because we're requesting too much.
				// Let's add it to the back of the frontier.
				currentEntry.failures++;
				System.out.println(e + " " + currentEntry.url);
				if(currentEntry.failures > 2){
					System.out.println("Not trying again for url: " + currentEntry.url);
					frontier.add(currentEntry);
				}
			}

			if(page == null){
				continue;
			}

			//Start by adding currently crawled page to DB.
			try {
				db.beginTransaction(SqlJetTransactionMode.WRITE);
				try{
					String pageText = page.content.outerHtml();
					ISqlJetTable pages = db.getTable("urls");
					pages.insert(page.url, page.anchorText, pageText, page.content.title());
				}finally{
					db.commit();
				}
			} catch (SqlJetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Check to see if we should go deeper
			if(currentEntry.depth >= depth){
				continue;
			}

			//Now we add new links to the frontier
			for(Element a : page.getLinks()){
				String href = a.attr("abs:href");
				if(visited.add(href) && !href.equals("")){
					String anchorText = a.text();
					frontier.add(new CrawlEntry( href, anchorText, currentEntry.depth + 1 ));
				}
			}
			
			//Now we add images to our DB
			for(Element img : page.getImages()){
				String href = img.attr("abs:src");
				if(visited.add(href) && !href.equals("")){
					System.out.println("Adding media url: " + href);
					//Start by adding currently crawled page to DB.
					try {
						db.beginTransaction(SqlJetTransactionMode.WRITE);
						try{
							ISqlJetTable media = db.getTable("media");
							media.insert(href, null, null);
						}finally{
							db.commit();
						}
					} catch (SqlJetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class CrawlEntry{
	String url;
	String anchor;
	int depth;
	int failures;
	
	
	
	public CrawlEntry(String url, String anchor, int depth, int failures) {
		super();
		this.url = url;
		this.anchor = anchor;
		this.depth = depth;
		this.failures = failures;
	}



	public CrawlEntry(String url,String anchor, int depth) {
		this(url, anchor, depth, 0);
	}
}
