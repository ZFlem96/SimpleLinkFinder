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
	private String pattern = "<[aA]\\s+[hH][rR][eE][fF].*=.*\"([^\\s]+)\".*>";
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
				System.out.println(line);
				linesInHTML.add(line);
			}
		} catch (Exception e) {
			System.out.println("Nothing to print");
		}
		System.out.println("--------------------");
		FileReader file = new FileReader("Results.txt");
		BufferedReader read1 = new BufferedReader(file);
		String txt = "";
		String txt1 = read1.readLine();
		int i = 0;

		while (txt1 != null) {
			txt += "\n" + txt1;
			if (i != 0) {
				linksinResults = new ArrayList<String>();
				linksinResults.add((i + 1) + ". " + txt);
			}
			txt1 = read1.readLine();
			i++;

		}
		System.out.println(linksinResults);
	}

	public boolean htmlLinksPattern(String lin) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(lin);
		boolean matches = m.find();
		if (matches) {
			linksInHTML.add(m.group(1));
			return true;
		} else {
			return false;
		}
	}

	public Iterator<String> getLinks() throws FileNotFoundException, IOException {
		String i = "";
		Iterator<String> linkIterator = linksInHTML.iterator();
		while (((Iterator<String>) linksInHTML).hasNext()) {
			i+=(linkIterator.next());
		}
		return (Iterator<String>)i;
	}

	public static void main(String[] args) throws IOException {
		LinkFinder a = new LinkFinder();
				InputStream site = null;
		site = new FileInputStream("neumonts.txt");
		System.out.println("working");
		a.processPage(site);
		System.out.println("----------------------");
		int x = 0;
		for (int i = 0; i < linesInHTML.size(); i++) {
			boolean tf = a.htmlLinksPattern(linesInHTML.get(i));
			if (tf) {
				System.out.println((x + 1) + ". " + linksInHTML.get(x));
				x++;
			}
		}
	}
}
