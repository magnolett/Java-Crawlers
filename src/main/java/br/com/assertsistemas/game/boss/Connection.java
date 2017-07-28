package br.com.assertsistemas.game.boss;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Connection {

	private static final String bosses = "https://www.tibiabosses.com/serdebra/";

	
	public void profitableBoss() throws IOException {
		Integer x = 5;
		Document doc = Jsoup.connect(bosses).get();
		
		Elements findBosses = doc.getElementsByClass("execphpwidget");
		String[] split = findBosses.toString().split("execphpwidget");
		while (x <= 11) {
			if (x == 5) {
				System.out.println("Profitable Bosses!");
			} else if (x == 6) {
				System.out.println("Weak Bosses!");
			} else if (x == 7) {
				System.out.println("POI Bosses!");
			} else if (x == 8) {
				System.out.println("Roshamuul Bosses!");
			} else if (x == 9) {
				System.out.println("Archdemons Bosses!");
			} else if (x == 10) {
				System.out.println("Without Prediction");
			} else if (x == 11) {
				System.out.println("World Change Bosses!");
			}
			String lineSeparator = lineSeparator(split, x);
			x = x+1;
			System.out.println(lineSeparator);
		}
	}
	
	public String lineSeparator(String[] split, Integer x) {
		String result = "";
		String[] splitLinha = split[x].split("\n");
		
		for (String linha : splitLinha) {
			String linhaReplace = linha.replaceAll("</", "").replaceAll("a>", "").replaceAll("<br>", "")
					.replaceAll("<i style=['|\"]color:red;['|\"]>" , "").replaceAll("><", "//").replaceAll("\n", "")
					.replaceAll("i>", "").replaceAll("<i style=['|\"]color:blue;['|\"]>", "").replaceAll("<i style=['|\"]color:green;['|\"]>", "")
					.replaceAll("\"", "").replaceAll("div>", "").replaceAll("<div class['|\"]=", "").replaceAll("<div", "").replaceAll("class=", "");
			if (linhaReplace.contains("//")) {
				String splitReplace = linhaReplace.split("//")[3];
				String[] splitTime = splitReplace.split(">");
				if (splitTime.length > 1) {
					System.out.println(splitTime[0] + " -----" + splitTime[1]);
				} else if (splitTime.length == 1){
					System.out.println(splitTime[0]);
				}
			} else {
				System.out.println(linhaReplace);
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new Connection().profitableBoss();
	}
	
}
