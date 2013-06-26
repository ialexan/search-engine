package com.pcwerk.seck.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Webpage {
	Document content;
	String anchorText;
	String url;
	
	
	public Webpage(String urlString, String anchor) throws IOException{
		url = (new URL(urlString)).toString();
		anchorText = anchor;
		content = Jsoup.connect(url.toString()).get();
		
	}
	
	public Webpage(String urlString, String anchor, String html) throws MalformedURLException{
		url = (new URL(urlString)).toString();
		anchorText = anchor;
		content = Jsoup.parse(html);
	}
	
	public Elements getLinks(){
		return content.select("a[href]");
	}
	
	public Elements getImages(){
		return content.select("img[src]");
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Url: ");
		sb.append(url);
		sb.append("\nAnchor Text: ");
		sb.append(anchorText);
		sb.append("\nLinks");
		for(Element e: this.getLinks()){
			sb.append("\n");
			sb.append(e.attr("abs:href"));
		}
		return sb.toString();
	}
}