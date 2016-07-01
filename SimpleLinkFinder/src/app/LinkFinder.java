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
	private Pattern w;
	private Matcher d;
	private String line = "";
	public static ArrayList<String> allLinks = new ArrayList<String>();
	public static ArrayList<String> linesInHTML = new ArrayList<String>();
	public static ArrayList<String> linksInHTML = new ArrayList<String>();
	public static ArrayList<String> linksinResults = new ArrayList<String>();
	
	public void processPage(InputStream in) throws IOException {
		
		System.out.println("In the method");
		int s = 1;
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
	 				linksinResults.add((i+1)+". "+txt);
	 			}
	 			txt1=read1.readLine();
	 			i++;
	 			
	 		}
	 		System.out.println(linksinResults);
	     }
	
	@Test
 	public void test() {
 		
     }
     public void finalLinkTest(String linkx ){
    	 String patternx = "xx.*xx";
 		Pattern p = Pattern.compile(patternx);
 		Matcher m = p.matcher(linkx);
 		boolean matches = m.matches();
 		if(matches){
 			allLinks.add(linkx);
 		}
     }
     public void htmlLinksPattern(String lin){
    	 String pattern = ".*[href].*([abcdesfghijklmnopqrstuvwxyz-/].*html).*";
    	 Pattern p = Pattern.compile(pattern.toLowerCase());
  		Matcher m = p.matcher(lin);
  		boolean matches = m.matches();
  		if(matches){
  			linesInHTML.add(m.group(0));
  		}
     }
	
	     public Iterator<String> getLinks() throws FileNotFoundException,  IOException{
	    	
//	    	Iterator<String> results = new Iterator<String>() {
//				
//				@Override
//				public String next() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//				
//				@Override
//				public boolean hasNext() {
//					// TODO Auto-generated method stub
//					return false;
//				}
//			};
//	    			(Iterator<>)txt;
	    	 return null;
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
		for(int i = 0; i<linesInHTML.size();i++){
			a.htmlLinksPattern(linesInHTML.get(i));
			System.out.println((i+1)+". "+linksInHTML.get(i));
		}
	}
}
