package com.pcwerk.seck.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.Link;

public class WebDocument implements Comparable<WebDocument>{
    private String url;
    private String hash;
    private String title;
    private String location;
    private String content;
    private Map<String, String> links; // Link and Anchor
    private List<Link> linksArr;
    private Metadata metadata;
    private int pageDepth;
    private Boolean crawled;
    private Boolean crawlable;
    private double score;
    
    public WebDocument()
    {
        url = "";
        hash = "";
        location = "";
        title = "";
        links = new HashMap<String, String>();
        linksArr = new ArrayList<Link>();
        metadata = null;
    }
    
    public WebDocument(String url, int pageDepth){
        links = new HashMap<String, String>();
        linksArr = new ArrayList<Link>();
        this.url = url;
        this.pageDepth = pageDepth;
        setCrawled( false );
        setCrawlable( true );
    }

    public WebDocument(String url, String title, String content){
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    public Map<String, String> getLinks()
    {
        return links;
    }

    public void setLinks( String link, String anchor )
    {
        this.links.put( link,anchor );
    }

    public List<Link> getLinksArr() {
        return linksArr;
    }

    public void setLinksArr(List<Link> links) {
        this.linksArr = links;
    }
    
    public int getPageDepth()
    {
        return pageDepth;
    }

    public void setPageDepth( int pageDepth )
    {
        this.pageDepth = pageDepth;
    }

    public Boolean isCrawled()
    {
        return crawled;
    }

    public void setCrawled( Boolean crawled )
    {
        this.crawled = crawled;
    }

    public Boolean isCrawlable()
    {
        return crawlable;
    }

    public void setCrawlable( Boolean crawlable )
    {
        this.crawlable = crawlable;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHTML(){
        String contentType = this.getMetadata()!=null? 
            this.getMetadata().get("Content-Type"):"";

            if (contentType!= null &&
                !contentType.isEmpty() &&  
                contentType.startsWith("text/html"))
                return true;
            return false;
    }

    
    public double getScore()
    {
        return score;
    }

    
    public void setScore( double score )
    {
        this.score = score;
    }

    public int compareTo( WebDocument webDoc )
    {
        return Double.compare(webDoc.getScore(), score);
    }
    
    

}
