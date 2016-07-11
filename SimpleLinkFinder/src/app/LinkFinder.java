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
	private String pattern = "<\\s*[aA]\\s+[^>]*[hH][rR][eE][fF]\\s*=\\s*\"([^\"]+)\"\\s*([^>]*)>";
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
		try {

			while ((line = read.readLine()) != null) {
				// System.out.println(line);
				linesInHTML.add(line);
			}
		} catch (Exception e) {
			System.out.println("Nothing to print");
		}
		int x = 0;

	}

	// public boolean htmlLinksPattern(String lin) {
	// Pattern p = Pattern.compile(pattern);
	// Matcher m = p.matcher(lin);
	// boolean matches = m.find();
	// if (matches) {
	// linksInHTML.add(m.group(1));
	// return true;
	// } else {
	// return false;
	// }
	// }
	public void htmlLinksPattern(String lin) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(lin);
		boolean matches = m.find();
		if (matches) {
			int matched = 0;
			for (int y = 0; y < linksinResults.size(); y++) {
				String inline = m.group(1);
				if (inline.equals(linksinResults.get(y))) {
					matched++;
				}
			}
			if (matched > 0) {
				linksInHTML.add(m.group(1));
			} else if (matched == 0) {
				linksInHTML.add("No match: " + m.group(1));
			}
		}
	}

	public Iterator<String> getLinks(ArrayList<String> list) {
		return list.iterator();
	}

	public static void main(String[] args) throws IOException {
		LinkFinder a = new LinkFinder();
		InputStream site = null;
		site = new FileInputStream("neumont.txt");
		System.out.println("working");
		a.processPage(site);
		FileReader file = new FileReader("results.txt");
		BufferedReader read1 = new BufferedReader(file);
		String txt = "";
		String txt1 = read1.readLine();
		int i = 0;
		while (txt1 != null) {
			txt = txt1;
			// linksinResults.add((i + 1) + ". " + txt);
			linksinResults.add(txt);

			txt1 = read1.readLine();
			// i++;

		}
		for (int x = 0; x < linesInHTML.size(); x++) {
			a.htmlLinksPattern(linesInHTML.get(x));

		}

		Iterator<String> html = a.getLinks(linksInHTML);
		Iterator<String> rlt = a.getLinks(linksinResults);
		if (html == rlt) {
			System.out.println("Good");
		} else {
			System.out.println("Nah");
			int wng = 0;
			for (int x = 0; x < linksinResults.size(); x++) {
				int nomatch = 0;
				int matched = 0;
				for (int y = 0; y < linksInHTML.size(); y++) {
					if (linksinResults.get(x) == linksInHTML.get(y)) {
						matched++;
					}

				}
				if (matched == 0) {
					wng++;
					System.out.println((x + 1) + ". " + linksinResults.get(x));
				}
			}

		}
	}
}
