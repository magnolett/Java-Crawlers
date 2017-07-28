package br.com.assertsistemas.game.bot;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import junit.framework.TestCase;

public class executionTest extends TestCase {

	@Test
	public void testTeste() throws Exception {
		
		Document doc = new Execution().teste();
		assertEquals("Tibia - Free Multiplayer Online Role Playing Game - Community", doc.title());
		assertEquals("en", doc.getElementsByAttributeValue("http-equiv", "content-language").attr("content"));
		Elements findName = doc.getElementsByTag("td");
		String[] splitPerLine = findName.toString().replaceAll("</a>", "").replaceAll("<", "").replaceAll(">", "").replaceAll("td", "")
				.replace("/", "").split("\\n");
		boolean check;
		if (splitPerLine.length != 14) {
			 check = false;
		} else {
			check = true;
		}
		assertFalse(check);

		String compare = testVerifyStatusCharacter();
		
		assertEquals("Character Online!", compare);
		
		
	}
	
	@Test
	public String testVerifyStatusCharacter() throws Exception {
		String nameCharacter = "Zokkran";
		String verifyStatus = new Execution().verifyStatusCharacter(nameCharacter);
		return verifyStatus;
		
		
	}

}
