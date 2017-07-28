package br.com.assertsistemas.app;

import java.util.List;

import br.com.assertsistemas.entity.Produto;
import br.com.assertsistemas.htmlunit.bot.CaptureInfoProdutoBot;

public class App {

	public static void main(String[] args) throws Exception {
		final List<Produto> produtos = new CaptureInfoProdutoBot().captureInfoProducao();

		produtos.forEach(p -> {
			System.out.println("Identificação -> " + "- Descrição: " + p.getDescricao());
		});	
	}
	
}