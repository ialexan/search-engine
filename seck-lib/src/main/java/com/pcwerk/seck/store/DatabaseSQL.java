package com.pcwerk.seck.store;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTransaction;
import org.tmatesoft.sqljet.core.table.SqlJetDb;


public class DatabaseSQL {
    
    private static SqlJetDb db;
  
    public DatabaseSQL(String dbName, Boolean write) throws SqlJetException{
        File dbFile = new File(dbName);
        dbFile.delete();

        db = SqlJetDb.open( dbFile, true);

        db.runWriteTransaction(new ISqlJetTransaction() {
            public Object run(SqlJetDb db) throws SqlJetException {
                db.createTable("create table urls (url text, title text, content text)");
                db.createTable( "create table links (url text, link text, anchor text)" );
                db.createIndex( "create index url_index on urls (url)" );
                db.createIndex( "create index url_link_index on links (url)" );

                return null;
            }
        });
    }
    
    public DatabaseSQL(String dbName) throws SqlJetException{
        File dbFile = new File(dbName);
        db = SqlJetDb.open( dbFile, true);
    }

    public void closeDb() throws SqlJetException {
        db.close();
        db = null;
    }
    
    public void writeDb(final ConcurrentLinkedQueue<WebDocument> frontier) throws SqlJetException{
        db.runWriteTransaction(new ISqlJetTransaction() {
            public Object run(SqlJetDb db) throws SqlJetException {

                int i= 0;
                for (WebDocument page : frontier){
                    if (page.isCrawlable()){
                        System.out.println( ++i + ". Inserting to database => "+ page.getUrl());
                        db.getTable("urls").insert(page.getUrl(),page.getTitle(), page.getContent());

                        for (Map.Entry<String, String> entry : page.getLinks().entrySet()) {
//                          System.out.println("Link = " + entry.getKey() + ", Anchor = " + entry.getValue());
                            db.getTable("links").insert(page.getUrl(),entry.getKey(), entry.getValue());
                        }
                    }
                }
                return null;
            }
        });
    }

    public void readDb(List<WebDocument> pages) throws SqlJetException{
        db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
        ISqlJetCursor cursor = db.getTable("urls").open();                
        try{    
            if (!cursor.eof()) {
                do {
                    pages.add( new WebDocument(cursor.getString("url"),cursor.getString("title"),cursor.getString("content" )) );
                } while(cursor.next());
            }
        } finally {
            cursor.close();
            db.commit();
        }

    }
    

    public void printDb() throws SqlJetException{
        System.out.println();
        db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
        ISqlJetCursor cursor = db.getTable("urls").open();                
        try{    
            if (!cursor.eof()) {
                int i = 0;
                do {
                    System.out.println(++i + ". URL =>  " + cursor.getString("url") + "    ||   TITLE =>  " +  cursor.getString("title") );
                    System.out.println( "\n Content => " + cursor.getString("content" ) + "\n");
                    printLinks( db.getTable( "links" ).lookup( "url_link_index", cursor.getString("url")) );
                    System.out.println( "--------------------------------------------------------------------------------------------------------------------" );
                    System.out.println( "--------------------------------------------------------------------------------------------------------------------\n\n" );
                } while(cursor.next());
            }
        } finally {
            cursor.close();
            db.commit();
        }

    }
    
    
    private void printLinks(ISqlJetCursor cursor) throws SqlJetException{
        try {
            if (!cursor.eof()) {
              do {
                System.out.println( "           Links to =>  " +  cursor.getString("link") + "   ||   Anchor =>  " + cursor.getString("anchor") );
               } while(cursor.next());
            }
          } finally {
            cursor.close();
          }
        System.out.println( "\n\n`" );
    }
    
    public List<String> getMediaLinks() throws SqlJetException{
    	System.out.println();
        db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
        ISqlJetCursor cursor = db.getTable("media").open(); 
        ArrayList<String> returnList = new ArrayList<String>();
        try{    
            if (!cursor.eof()) {
                do {
                    String url = cursor.getString("url");
                    returnList.add(url);
                } while(cursor.next());
            }
        } finally {
            cursor.close();
            db.commit();
        }
        return returnList;
    }

    public void saveMedia(final String url, final Map<String,String> metadata) throws SqlJetException{

        
                

         db.beginTransaction(SqlJetTransactionMode.WRITE);
         
         try{
        	 for (Map.Entry<String, String> entry : metadata.entrySet()){

                 db.getTable("media").insert(url, entry.getKey(), entry.getValue());

             }
         }finally{
        	 db.commit();
         }

    }
    
    public static void main(String args[]){
    	try {
			DatabaseSQL db = new DatabaseSQL("/Users/ajo/workspace/cs454/seck/seck-app/target/crawl.sqlite");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("test", "test");
			db.saveMedia("http://www.google.com/intl/en_ALL/images/srpr/logo1w.png", map);
		} catch (SqlJetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    
}
