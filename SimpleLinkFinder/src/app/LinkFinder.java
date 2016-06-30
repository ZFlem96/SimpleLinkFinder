package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class LinkFinder {
	Pattern w;
	Matcher d;
	public ArrayList<String> allLinks;
	public ArrayList<String> linesInHTML;
	public ArrayList<String> linksInHTML;
	public ArrayList<String> linksinResults;
	
	public void processPage(InputStream in) throws IOException {
		   System.out.println("In the method");
		   String line;
		   InputStreamReader readThis = new InputStreamReader(in);
		   BufferedReader read = new BufferedReader(readThis);
		   try{
			   while((line = read.readLine())!= null){
				   System.out.println(line);
				   linesInHTML.add(line);
			   }
		   }
		   catch(Exception e){
			   System.out.println("Nothing to print");
		   }
		   System.out.println("--------------------");
		   FileReader file = new FileReader("Results.txt");
	 		BufferedReader read1 = new BufferedReader(file);
	 		String txt = "";
	 		String txt1 = read1.readLine();
	 		int i = 0;
	 		
	 		while(txt1 != null){
	 			txt+="\n"+txt1;
	 			if(i != 0){
	 				linksinResults = new ArrayList<String>();
	 				linksinResults.add(txt);
	 			}
	 			txt1=read1.readLine();
	 			i++;
	 			
	 		}
	 		System.out.println(linksinResults);
	     }

	     public Iterator<String> getLinks() throws FileNotFoundException,  IOException{
	    	
	    	Iterator<String> results = new Iterator<String>() {
				
				@Override
				public String next() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return false;
				}
			};
//	    			(Iterator<>)txt;
	    	 return results;
	     }
	     @Test
	 	public void test() {
	 		
	     }
	     public void patternTest(Pattern p, String patter ){
	    	Matcher m = p.matcher(patter);
	 		boolean matches = m.matches();
	 		if(matches){
	 			
	 		}
	     }
	public static void main(String[] args) throws IOException {
		LinkFinder a =new LinkFinder();
//		 File f = new File("C:\\Users\\ZFleezy\\Documents\\Java1Assignments\\re");
//    	 String[] fil = f.list();
//    	 for(String s: fil){
//    		 System.out.println(fil.toString());
//    	 }
//		FileReader file = new FileReader("C:\\Users\\ZFleezy\\Documents\\Java1Assignments\\re\\results.txt");
// 		BufferedReader read = new BufferedReader(file);
// 		String txt = "";
// 		String txt1 = read.readLine();
// 		while(txt1 != null){
// 			txt+="\n"+txt1;
// 			txt1=read.readLine();
// 		}
//		System.out.println(txt);
		InputStream site = null;
		site = new FileInputStream("neumonts.txt");
		
//		char c;
//		int i;
		System.out.println("working");
		
//		System.out.println(read);
//		 while((i=site.read())!=-1)
//         {
//            // converts integer to character
//            c=(char)i;
//            
//            // prints character
//            System.out.print(c);
//            if(site!=null){
//            	site.close();
//            }
//         }
		a.processPage(site);
	}
}
