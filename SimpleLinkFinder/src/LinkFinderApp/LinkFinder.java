package LinkFinderApp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder {
	private ArrayList<String> links = new ArrayList<String>();

	public void processPage(InputStream in) {
		InputStreamReader isReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(isReader);
		try {
			// for each line in input string,
			String line = "";
			String patternString = "<\\s*[aA]\\s+[^>]*[hH][rR][eE][fF]\\s*=\\s*\"([^\"]+)\"\\s*([^>]*)>";
			Pattern pattern = Pattern.compile(patternString);
			while ((line = bufferedReader.readLine()) != null) {
				// if the pattern exist,
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					// pull link and add to links
					links.add(matcher.group(1));
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Iterator<String> getLinks() {
		return links.iterator();

	}
}
