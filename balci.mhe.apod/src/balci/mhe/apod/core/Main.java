package balci.mhe.apod.core;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FilePackage ApodFiles = new FilePackage("Q:\\Users\\m_balci4\\My Documents\\apod");
		String[] FileList = ApodFiles.getFileNames();
		HtmlParser Parser = new HtmlParser();
		
		for(String s : FileList){
			Parser.getHtmlSource(s);
			try {
				Parser.FindPicture();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	 
}

