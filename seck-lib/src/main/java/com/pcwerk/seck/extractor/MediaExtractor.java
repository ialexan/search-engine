package com.pcwerk.seck.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import com.pcwerk.seck.extractor.imagecolorfrequencyextractor.MostFrequentColorExtractor;


public class MediaExtractor{ 

    private Metadata metadata = new Metadata();
    private InputStream inputStream;
    private String fileName;

    public MediaExtractor(String fileName){
        this.fileName = fileName;

        File file;
        try {
            if ((new File(fileName)).exists()){
                file = new File(fileName);
                inputStream = new FileInputStream(file);
            }    
            else {
                java.net.URL u = new java.net.URL(fileName);
                java.net.URLConnection uc = u.openConnection();

                inputStream = uc.getInputStream();
            }
        } catch (Exception e) { throw new RuntimeException(e); }

    }


    public void extract(){   
        try {
            // This is to add the most frequent color in an image
            MostFrequentColorExtractor mfce = new MostFrequentColorExtractor(fileName,this); 
            mfce.extractMostFrequentColor();

        }catch (Exception e) {

            System.out.println( "Not an image" );
        }

        
        try{

            Parser parser = new AutoDetectParser();            
            ParseContext parseContext = new ParseContext();

            ContentHandler handler = new BodyContentHandler();
            parser.parse(inputStream, handler, metadata, parseContext);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Map<String, String> getMap(){
        
        Map<String,String> map = new HashMap<String,String>();
        
        for (String name : metadata.names()) {
        	System.out.println("Name: " + name + " value: " + metadata.get(name));
            map.put( name, metadata.get(name)  );
        }
        
        return map;
    }
    
    public void addMetadata(String propertyName, String propertyValue){
        metadata.add( propertyName, propertyValue ); 
    }

    public void print(){
        for (String name : metadata.names()) 
            System.out.println("metadata: " + name + " - " + metadata.get(name));
    }


    public static void main(String[] args) {
        MediaExtractor me = new MediaExtractor("http://slowmuse.files.wordpress.com/2008/12/green.jpg");   
        me.extract();
        me.print();
    }

}
