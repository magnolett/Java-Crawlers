package br.com.assertsistemas.imagebot;

import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

public abstract class SettingBot {
	
	protected WebClient webClient;
	
	public SettingBot() {
		IncorrectnessListener il = new IncorrectnessListener() {
			public void notify(String arg0, Object arg1) {
			}
		};

		webClient = new WebClient();
		
//		final CookieManager cookieMan = webClient.getCookieManager();
//		cookieMan.setCookiesEnabled(true);

		webClient.setIncorrectnessListener(il);

		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setTimeout(30000);
		webClient.getOptions().setRedirectEnabled(true);
		webClient.getOptions().setPopupBlockerEnabled(false);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		
		webClient.waitForBackgroundJavaScriptStartingBefore(3000);
	}

}