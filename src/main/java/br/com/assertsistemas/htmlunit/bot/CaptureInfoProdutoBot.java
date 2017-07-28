package br.com.assertsistemas.htmlunit.bot;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import br.com.assertsistemas.entity.Produto;

public class CaptureInfoProdutoBot extends SettingBot {

	private static final String FONTES_PROMOTORA_PRODUTOS = "http://fontespromotora.com.br/produtos/";
	
	public List<Produto> captureInfoProducao() throws Exception {
		final HtmlPage indexProdutoPage = webClient.getPage(FONTES_PROMOTORA_PRODUTOS);
		final List<Produto> produtos = new ArrayList<>();

		
		
		//Pegando Class, Id, tagName
		indexProdutoPage.getByXPath("//div[@class='column one-third']").forEach(e ->{
			final HtmlDivision htmlClass = (HtmlDivision) e; 

			if(htmlClass.getElementsByTagName("h4") != null && !htmlClass.getElementsByTagName("h4").isEmpty()){
				final String h4 = htmlClass.getElementsByTagName("h4").get(0).asText();
				
				if(h4.contains("Empréstimo")){
					System.out.println("Consegui por class");
					String descricao = indexProdutoPage.getElementById("prod-1").asText();
					Produto produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-2").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-3").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-4").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-5").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);

					descricao = indexProdutoPage.getElementById("prod-6").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-8").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-9").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-10").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-12").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
					descricao = indexProdutoPage.getElementById("prod-13").asText();
					produto = new Produto();
					produto.setDescricao(descricao);
					produtos.add(produto);
					
				}
			}
		});
		
		return produtos;
	}

}

