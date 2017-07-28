package br.com.assertsistemas.jsoup;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parse {

	public static final String SOURCE_HTML = "<html><head><title>Jsoup Example</title></head>"
			+ "<body><h1>Welcome to JournalDev!!</h1>" + "<div id=\"id1\">Hello</div>"
			+ "<div class=\"class1\">Pankaj</div>" + "<a href=\"http://journaldev.com\">Home</a>"
			+ "<a href=\"http://wikipedia.org\">Wikipedia</a>" + "</body></html>";

	public void parseFromString() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.journaldev.com").get();
			String source = "<html><head><title>Jsoup Example</title></head>" + "<body><h1>Welcome to JournalDev!!</h1>"
					+ "</body></html>";

			doc = Jsoup.parse(source);
			System.out.println(doc.html());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseBodyFragment() {

		String html = "<div><p>Test Data</p>";
		Document doc1 = Jsoup.parseBodyFragment(html);
		System.out.println(doc1.html());

	}

	public static void main(String[] args) {
		Document doc = Jsoup.parse(SOURCE_HTML);
		System.out.println("Title=" + doc.title());

		// let's add attribute rel="nofollow" to all the links
		doc.select("a[href]").attr("rel", "nofollow");
		// System.out.println(doc.html());

		// change div class="class1" to class2
		doc.select("div.class1").attr("class", "class2");
		// System.out.println(doc.html());

		// change the HTML value of first h1 element
		doc.select("h1").first().html("Welcome to JournalDev.com");
		doc.select("h1").first().append("!!");
		// System.out.println(doc.html());

		// let's make Home link bold
		doc.select("a[href]").first().html("<strong>Home</strong>");
		System.out.println(doc.html());

	}
}
