package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class LinkFinder {
	   public void processPage(InputStream in) {
		   
	     }

	     public Iterator<String> getLinks() throws FileNotFoundException,  IOException{
	    	 FileReader file = new FileReader("C:\\Users\\ZFleezy\\Documents\\Java1Assignments\\re\\results.txt");
	 		BufferedReader read = new BufferedReader(file);
	 		String txt = "";
	 		String txt1 = read.readLine();
	 		while(txt1 != null){
	 			txt+=txt1;
	 			txt1=read.readLine();
	 		}
	    	Iterator<String> results= null;
//	    			(Iterator<>)txt;
	    	 return results;
	     }
	
	public static void main(String[] args) {
//		 File f = new File("C:\\Users\\ZFleezy\\Documents\\Java1Assignments\\re");
//    	 String[] fil = f.list();
//    	 for(String s: fil){
//    		 System.out.println(fil.toString());
//    	 }
		
//		System.out.println(txt);
	}
}
