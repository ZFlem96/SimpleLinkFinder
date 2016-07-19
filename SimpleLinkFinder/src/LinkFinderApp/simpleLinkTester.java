package LinkFinderApp;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class simpleLinkTester {
	private LinkFinderOld test = new LinkFinderOld();
	private Iterator<String> html;
	private Iterator<String> rlt;
	@Test
	public void test() throws IOException {
//		assertTrue(test.);
		this.linkMatchTest();
		
	}
	public void linkMatchTest() throws IOException{
		LinkFinderOld a = new LinkFinderOld();
		InputStream site = null;
		site = new FileInputStream("neumont.txt");
		ArrayList<String> pageLines = a.linesInHTML;
		ArrayList<String> htmlLinks = a.linksInHTML;
		ArrayList<String> resultLinks = a.linksinResults;
		FileReader file = new FileReader("results.txt");
		BufferedReader read1 = new BufferedReader(file);
		String txt1 = read1.readLine();
		while (txt1 != null) {
			resultLinks.add(txt1);
			txt1 = read1.readLine();
		}
		a.processPage(site, pageLines);
		for (int i = 0; i < pageLines.size(); i++) {
			a.htmlLinksPattern(pageLines.get(i), resultLinks, htmlLinks);
		}
		
		System.out.println(htmlLinks);
		System.out.println(resultLinks);
//		System.out.println(a.linksinResults);
		html = a.getLinks(htmlLinks);
		rlt = a.getLinks(resultLinks);
		if(htmlLinks.equals(resultLinks)){
			assertEquals(rlt, html);
		} else {
			System.out.println(rlt+ " != "+ html);
		}
		
		
	}

}
