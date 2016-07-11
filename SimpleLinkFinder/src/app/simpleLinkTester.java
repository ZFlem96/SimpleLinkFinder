package app;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.junit.Test;

public class simpleLinkTester {
	private LinkFinder test = new LinkFinder();
	@Test
	public void test() throws IOException {
//		assertTrue(test.);
		this.linkMatchTest();
	}
	public void linkMatchTest() throws IOException{
		LinkFinder a = new LinkFinder();
		InputStream site = null;
		site = new FileInputStream("neumont.txt");
		a.processPage(site);
		for (int i = 0; i < a.linesInHTML.size(); i++) {
			a.htmlLinksPattern(a.linesInHTML.get(i));
		}
		FileReader file = new FileReader("results.txt");
		BufferedReader read1 = new BufferedReader(file);
		String txt1 = read1.readLine();
		while (txt1 != null) {
			a.linksinResults.add(txt1);
			txt1 = read1.readLine();
		}
		Iterator<String> html = a.getLinks(a.linksInHTML);
		Iterator<String> rlt = a.getLinks(a.linksinResults);
//		if(html==rlt){
//			return true;
			assertEquals(html, rlt);
//		}
		
	}

}
