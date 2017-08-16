package br.com.assertsistemas.formbot;

import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class Form extends SettingBot {

	private static final String Facebook = "http://fontespromotora.com.br/fale-conosco/";

	public String simulaFormulario() throws Exception {

		final HtmlPage page = webClient.getPage(Facebook);
		final HtmlForm form = page.getForms().get(1);
		System.out.println(form.asText());
		final HtmlTextInput nameInput = page.getElementByName("nome");
			nameInput.setValueAttribute("");
		final HtmlTextInput companyInput = page.getElementByName("empresa");
			companyInput.setValueAttribute("");
		final HtmlTextInput emailInput = page.getElementByName("email");
			emailInput.setValueAttribute(".com");
		final HtmlTextInput phoneInput = page.getElementByName("telefone");
			phoneInput.setValueAttribute("");
		final HtmlSelect stateSelect = page.getElementByName("estado");
		final HtmlOption option = stateSelect.getOptionByValue("");
			stateSelect.setSelectedAttribute(option, true);
		final HtmlTextInput cityInput = page.getElementByName("cidade");
			cityInput.setValueAttribute("");
		final HtmlTextInput codfontesInput = page.getElementByName("rep");
			codfontesInput.setValueAttribute("");
		final HtmlTextInput gerenteInput = page.getElementByName("gerente");
			gerenteInput.setValueAttribute("");
		final HtmlTextArea mensagemInput = page.getElementByName("mensagem");
			mensagemInput.setText("Aqui temos um texto para envio de formulário como exemplo!");
		final HtmlSubmitInput button = page.getFirstByXPath("//input[@class='wpcf7-form-control wpcf7-submit']");
			System.out.println(button.asText());
			System.out.println("SUCESSO!");
			button.click();
			return null;
	}

	public static void main(String[] args) throws Exception {
		new Form().simulaFormulario();
	}

}
