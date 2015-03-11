package com.nlp.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	private Pattern pattern ;
	private Matcher matcher ;
	private ArrayList<String> pairs ;
	private HashMap<String,String> info ;
	public Regex(){
		
		String regex = "(<td width=\"100\">)(.*?)(</td>\\n\\s+<td>)(.*?)(</td>)";
		
		pattern = Pattern.compile(regex, Pattern.MULTILINE);
		pairs = new ArrayList<String>();
		info = new HashMap<String,String>();
	}
	
	public void printInfo(){
		String print;
		for(String key : info.keySet()){
			print =key + (key.length() >= 9 ? "\t\t: " : "\t\t\t: ") + info.get(key) ;
			System.out.println(print);
		}
	}
	
	public String getInfo(){
		String print = "";
		for(String key : info.keySet()){
			print +=key + (key.length() >= 9 ? "\t\t: " : "\t\t\t: ") + info.get(key) +"\n";
		}
		return print;
	}
	@SuppressWarnings("rawtypes")
	public HashMap getPairs(){
		return this.info;
	}
	
	
	public void SetHTML(String html){
		matcher = pattern.matcher(html);
		
		while(matcher.find()){
			if(!matcher.group().contains("Harita")){
				pairs.add(matcher.group());
			}
		}
		
		String keyRegex = "\">(.*?)<";
		pattern = Pattern.compile(keyRegex, Pattern.MULTILINE);
		
		String valueRegex = "\\s+<(.*?)<";
		Pattern valuePattern = Pattern.compile(valueRegex, Pattern.MULTILINE);
		
		for(String s : pairs){

			String key = "", value = "";
			
			matcher = pattern.matcher(s);
			if(matcher.find()){
				key = matcher.group();
				try{
					key = key.substring(key.indexOf(">")+1, key.indexOf(":"));
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			matcher = valuePattern.matcher(s);
			if(matcher.find()){
				value = matcher.group();
				if(value.length()>2){
					value = value.substring(value.indexOf(">")+1, value.length()-1);
				}
			}
			
			info.put(key, value);
		}
	}
	
	
	
	
	
	
}
