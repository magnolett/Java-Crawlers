package br.com.assertsistemas.game.bot;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Execution {
	
	private static final String nameCharacter = "Jack of Ashes";
	private static final String findCharacter = "https://secure.tibia.com/community/?subtopic=characters";
	private static final String verifyOnline = "https://secure.tibia.com/community/?subtopic=worlds&world=Serdebra";

	public Document teste() throws Exception {

		Character character = new Character();
		Document doc = Jsoup.connect(findCharacter).data("name", nameCharacter).data("Submit.x", "0")
				.data("Submit.y", "0").userAgent("Chrome").post();
		
		
		Elements findName = doc.getElementsByTag("td");
		String[] splitPerLine = findName.toString().replaceAll("</a>", "").replaceAll("<", "").replaceAll(">", "").replaceAll("td", "")
				.replace("/", "").split("\\n");
		String nameChar = splitPerLine[2];
		character.setNameChar(nameChar);
			if (splitPerLine[4].contains("Former Names:")) {
				String vocChar = splitPerLine[9];
				String levelChar = splitPerLine[11];
				String residenceChar = splitPerLine[20];
				character.setVocChar(vocChar);
				character.setLevelChar(levelChar);
				character.setResidenceChar(residenceChar);
				if (splitPerLine[21].contains("House:")) {
					if (splitPerLine[23].contains("Last Login:")) {
					} else {
						String[] guildCharArray = splitPerLine[24].replaceAll("a href=", "").split("\"");
						String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
						String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
						character.setGuildChar(guildCharUTF);
					}
				} else if (splitPerLine[22].contains("House:")) {
					} else if (splitPerLine[19].contains("Residence")) {
						if (splitPerLine[21].contains("Married To")) {
							String[] guildCharArray = splitPerLine[24].replaceAll("a href=", "").split("\"");
							String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
							String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
							character.setGuildChar(guildCharUTF);
							} else {
						String[] guildCharArray = splitPerLine[22].replaceAll("a href=", "").split("\"");
						String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
						String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
						character.setGuildChar(guildCharUTF);
							}
					} else if (splitPerLine[17].contains("Residence")) {
					String[] guildCharArray = splitPerLine[20].replaceAll("a href=", "").split("\"");
					String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
					String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
					character.setGuildChar(guildCharUTF);
				} else {
					character.setGuildChar("Sem guild!");
//					String[] guildCharArray = splitPerLine[20].replaceAll("a href=", "").split("\"");
//					String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
//					String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
//					System.out.println(guildCharUTF);
				}
			} else {
				String vocChar = splitPerLine[7];
				String levelChar = splitPerLine[9];
				String residenceChar = splitPerLine[18];
				character.setVocChar(vocChar);
				character.setLevelChar(levelChar);
				character.setResidenceChar(residenceChar);
				if (splitPerLine[19].contains("House:")) {
					if (splitPerLine[21].contains("Last Login:")) {
						character.setGuildChar("Sem guild!");
					} else {
						String[] guildCharArray = splitPerLine[22].replaceAll("a href=", "").split("\"");
						String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
						String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
						character.setGuildChar(guildCharUTF);
					}
				} else if (splitPerLine[20].contains("House:")) {
					character.setGuildChar("Sem guild!");
				} else if (splitPerLine[19].contains("Residence")) {
					String[] guildCharArray = splitPerLine[22].replaceAll("a href=", "").split("\"");
					String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
					String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
					character.setGuildChar(guildCharUTF);
				} else if (splitPerLine[17].contains("Residence")) {
					if (splitPerLine[19].contains("Married To")) {
						if(splitPerLine[21].contains("House")) {
							String[] guildCharArray = splitPerLine[24].replaceAll("a href=", "").split("\"");
							String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
							String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
							character.setGuildChar(guildCharUTF);
						} else {
							String[] guildCharArray = splitPerLine[22].replaceAll("a href=", "").split("\"");
							String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
							String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
							character.setGuildChar(guildCharUTF);	
					}
					}
					else if (splitPerLine[19].contains("Last Login")) {
						character.setGuildChar("Sem guild!");
					} else {
						String[] guildCharArray = splitPerLine[20].replaceAll("a href=", "").split("\"");
						String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
						String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
						character.setGuildChar(guildCharUTF);
					}
				} else {
					character.setGuildChar("Sem guild!");
//					String[] guildCharArray = splitPerLine[20].replaceAll("a href=", "").split("\"");
//					String guildChar = guildCharArray[0]+ "" + guildCharArray[2];
//					String guildCharUTF = StringEscapeUtils.unescapeHtml4(guildChar.toString().trim());
//					System.out.println(guildCharUTF);
				}
			}
		String findOnline = doc.getElementsByAttributeValue("class", "green").toString().trim();
			if (!findOnline.isEmpty()) {
				if (doc.toString().contains(findOnline.toString())) {
					character.setIsOnline("Character Online!");
				}
			} else if(findOnline.isEmpty()) {
				String verify =	verifyStatusCharacter(nameCharacter);
				character.setIsOnline(verify);
			}
			
			System.out.println(character.getNameChar());
			System.out.println(character.getVocChar());
			System.out.println(character.getLevelChar());
			System.out.println(character.getResidenceChar());
			System.out.println(character.getGuildChar());
			System.out.println(character.getIsOnline());
			return doc;



		}
	
	public static void main(String[] args) throws Exception {
		new Execution().teste();
	}
	
	public String verifyStatusCharacter(String nameCharacter) throws Exception {
		String verifyOn;
		boolean contem = false;
		
		Document doc = Jsoup.connect(verifyOnline).userAgent("Chrome").get();
		
		for (Element element : doc.getElementsByTag("td")) {
			if(StringEscapeUtils.unescapeHtml4(element.toString()).toLowerCase().contains(nameCharacter.replaceAll(" ", "+").toLowerCase())){
				contem = true;
				break;
			}
		}
		
		if (contem) {
			verifyOn = "Character Online!";
		} else {
			verifyOn = "Character Offline!";
		}
		
		
		return verifyOn;
		
	}
	

}
