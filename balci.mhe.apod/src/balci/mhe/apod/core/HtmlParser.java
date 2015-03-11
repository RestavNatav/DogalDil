package balci.mhe.apod.core;

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
	
	
	public void FindPicture() throws Exception{
		int endPoint = this.Source.indexOf(".jpg");
		int startPoint = 0;
		
		if( endPoint > 0 ){
			
			while( '\"' != this.Source.charAt(endPoint) ){
				endPoint++;
			}
			
			startPoint = endPoint-1;
			
			while( '\"' != this.Source.charAt(startPoint)){
				startPoint--;
			}

			String imgSrc = this.Source.substring(startPoint+1, endPoint);
			System.out.println("http://apod.nasa.gov/"+ imgSrc);
			
		}else{
			throw new Exception(".Jpg cant find!");
		}
	}
}
