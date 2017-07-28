package br.com.assertsistemas.imagebot;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Image extends SettingBot {

	private static final String URL = "http://i.stack.imgur.com/9DdHc.jpg";
	private static final String URI = "https://stackoverflow.com/questions/18039621/htmlunit-use-webclient-to-download-an-image-as-base64-encoded-data-uri";

	public String peloLinkDireto() throws Exception {
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		final InputStream page = webClient.getPage(URL).getWebResponse().getContentAsStream(); // Instancia
		RenderedImage img = ImageIO.read(page);
		ImageIO.write(img, "jpg", new File("C:/Users/Marquinhos/Desktop/teste.jpg"));
		System.out.println("Sucesso!");
		// HtmlForm htmlForm = htmlPage.getForms().get(0);

		// // String result = htmlPage.asXml();
		// // System.out.println(result);
		//
		// // if (result.contains("http://i.stack.imgur.com/9DdHc.jpg")) {
		// URL uri = new URL("http://i.stack.imgur.com/9DdHc.jpg");
		//
		// // gravando imagem
		// RenderedImage img = ImageIO.read(uri);
		//
		// ImageIO.write((RenderedImage) img, "png", new File("a.png"));
		// }
		return null;
	}

	public String peloLink() throws Exception {
		final HtmlPage page = webClient.getPage(URI);
		System.out.println(page.asText());
		page.getElementsByTagName("img").forEach(e -> {
			if (e.getAttribute("alt").equals("yao face")) {
				try {
					System.out.println(e.getAttribute("src"));
					InputStream contentAsStream = webClient.getPage(e.getAttribute("src").replace("https", "http")).getWebResponse().getContentAsStream();
					RenderedImage img = ImageIO.read(contentAsStream);
					ImageIO.write(img, "jpg", new File("C:/Users/Marquinhos/Desktop/testando.jpg"));
				} catch (FailingHttpStatusCodeException | IOException e1) {
					e1.printStackTrace();
				}
			}

		});

		return URI;

	}

	private static RenderedImage getImage(HtmlImage image) throws IOException {
		ImageReader reader = image.getImageReader();
		int minIndex = reader.getMinIndex();
		return reader.read(minIndex);
	}

	public static void main(String[] args) throws Exception {
		new Image().peloLink();
	}
}