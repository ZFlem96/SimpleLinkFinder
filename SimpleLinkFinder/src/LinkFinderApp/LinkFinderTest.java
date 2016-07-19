package LinkFinderApp;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.junit.Test;

public class LinkFinderTest {

	@Test
	public void test() {
		try {
			// processPage
			InputStream site = new FileInputStream("neumont.txt");
			
			LinkFinder linkFinder = new LinkFinder();
			linkFinder.processPage(site);
			// open results file
			InputStream results = new FileInputStream("results.txt");
			
			InputStreamReader isReader = new InputStreamReader(results);
			BufferedReader bufferedReader = new BufferedReader(isReader);
			// for each link
			for (Iterator<String> i = linkFinder.getLinks(); i.hasNext();) {
				String link = i.next();
				// read line from result file
				String resultLine = bufferedReader.readLine();
				
				// assert if line and the link are the same
				assertEquals(resultLine, link);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
