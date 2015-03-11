package com.nlp.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlParser {
	private String FilePath;
	private String Source;
	
	
	public void getHtmlSource(String path){

		this.FilePath = path;
		this.Source = "";
		
		try (BufferedReader reader =new BufferedReader(new FileReader(this.FilePath))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        //System.out.println(line);
		    	this.Source += line + "\n";
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public void PrintSource(){
		System.out.println(this.Source);
	}
	
	public String getSource(){
		return this.Source;
	}
}
