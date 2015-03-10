package balci.mhe.apod.core;

import java.io.File;
import java.util.ArrayList;

public class FilePackage {
	
	private String RootFilePath;
	private ArrayList<String> FileNames;
	private ArrayList<String> DirectoryNames;
	
	public FilePackage(String filePath){
		this.RootFilePath = filePath;
		this.FileNames = new ArrayList<String>();
		this.DirectoryNames = new ArrayList<String>();
		
		parseFileNames();
		
	}
	
	private void parseFileNames(){
		File folder = new File(this.RootFilePath);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  //System.out.println("File " + listOfFiles[i].getName());
		    	  FileNames.add( listOfFiles[i].getName() );
		      } else if (listOfFiles[i].isDirectory()) {
		    	  //System.out.println("Directory " + listOfFiles[i].getName());
		    	  DirectoryNames.add(listOfFiles[i].getName());
		      }
		    }
	}
	
	public String[] getFileNames(){
		
		String[] fileList = new String[FileNames.size()];
		
		for(int i=0; i<FileNames.size() ; i++ ){
			fileList[i] = RootFilePath + "\\" + FileNames.get(i);
		}
		
		return fileList;
	}
}
