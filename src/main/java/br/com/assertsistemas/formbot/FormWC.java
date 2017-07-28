package br.com.assertsistemas.formbot;

import java.net.URL;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class FormWC extends SettingBot{

	@SuppressWarnings("rawtypes")
	public void post()  throws Exception {

	    URL url = new URL("http://fontespromotora.com.br/fale-conosco/");
	    WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);
	    
	    requestSettings.setRequestParameters(new ArrayList()); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7", "33")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7_version", "4.7")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7_locale", "pt_BR")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7_unit_tag", "wpcf7-f33-o1")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpnonce", "c0252e424d")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("produto", "marcos"));
	    requestSettings.getRequestParameters().add(new NameValuePair("telefone", "TELEFONE (48) 9964-44695")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("email", "marcos.vinicius@assert.com.br")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("mensagem", "Testando um webClient do HTMLUNIT")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7_captcha_challenge_captcha-122", "1051195328")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("captcha-122", "UWFP")); 
	    requestSettings.getRequestParameters().add(new NameValuePair("_wpcf7_is_ajax_call", "1")); 
	    
	    
	    
	    
	    
	    WebResponse response = webClient.loadWebResponse(requestSettings);
	    
	    //Page redirectPage = webClient.getPage(requestSettings);
	    
	    //WebResponse response = redirectPage.getWebResponse();
	    String content = response.getContentAsString();
	    
	    System.out.println(response.getStatusCode());
	    System.out.println(content);

	    
//	    requestSettings.setAdditionalHeader("Accept", "*/*");
//	    requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//	    requestSettings.setAdditionalHeader("Referer", "REFURLHERE");
//	    requestSettings.setAdditionalHeader("Accept-Language", "en-US,en;q=0.8");
//	    requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate,sdch");
//	    requestSettings.setAdditionalHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
//	    requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
//	    requestSettings.setAdditionalHeader("Cache-Control", "no-cache");
//	    requestSettings.setAdditionalHeader("Pragma", "no-cache");
//	    requestSettings.setAdditionalHeader("Origin", "http://www.fontespromotora.com.br");
//	    requestSettings.setRequestBody("REQUESTBODY");

	}		
		
		public static void main(String[] args) throws Exception {
			new FormWC().post();
		}
		
	}
	
