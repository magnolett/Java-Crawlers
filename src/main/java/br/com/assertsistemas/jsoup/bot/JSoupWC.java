package br.com.assertsistemas.jsoup.bot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.com.assertsistemas.formbot.SettingBot;

public class JSoupWC extends SettingBot {

	public void testandoUm() throws IOException {
		Connection.Response conn = Jsoup.connect("http://www.fontes'essoriafinanceira.com.br/index.php?rt=slogin")
				.data("user", "").data("pass", "").userAgent("Chrome")
				.method(Connection.Method.POST).timeout(15000).execute();
		int code = conn.statusCode();
		System.out.println(code);
		System.out.println(conn.toString());
	}

	public void testandoDois() throws Exception {
		Connection.Response conn = Jsoup.connect("https://www.instagram.com/accounts/login/ajax/?hl=pt-br")
				.data("username", "").data("password", "").userAgent("Chrome")
				.method(Connection.Method.POST).execute();
		int code = conn.statusCode();
		System.out.println(code);
	}

	public static void main(String[] args) throws Exception {
		new JSoupWC().testandoTres();
	}

	public void testandoTres() throws Exception {
		// Document conn =
		// Jsoup.connect("http://buscatextual.cnpq.br/buscatextual/busca.do").data("metodo",
		// "buscar")
		// .data("buscaAvancada", "0").data("filtros.buscaNome",
		// "true").data("textoBusca", "")
		// .data("buscarDoutores", "true").data("resumoModalidade", "Bolsas de
		// PQ de categorias0")
		// .data("buscarBrasileiros", "true").data("buscarEstrangeiros", "true")
		// .data("buscarDoutoresAvancada",
		// "true").data("buscarBrasileirosAvancada", "true")
		// .data("buscarEstrangeirosAvancada",
		// "true").data("paisNascimentoAvancada", "0")
		// .data("filtros.atualizacaoCurriculo",
		// "48").data("quantidadeRegistros", "10")
		// .data("filtros.visualizaEnderecoCV",
		// "true").data("filtros.visualizaFormacaoAcadTitCV", "true")
		// .data("filtros.visualizaAtuacaoProfCV",
		// "true").data("filtros.visualizaAreasAtuacaoCV", "true")
		// .data("filtros.visualizaIdiomasCV",
		// "true").data("filtros.visualizaPremioTitulosCV", "true")
		// .data("filtros.visualizaSoftwaresCV",
		// "true").data("filtros.visualizaProdutosCV", "true")
		// .data("filtros.visualizaProcessosCV",
		// "true").data("filtros.visualizaTrabalhosTecnicosCV", "true")
		// .data("filtros.visualizaOutrasProdTecCV",
		// "true").data("filtros.visualizaArtigosCV", "true")
		// .data("filtros.visualizaLivrosCapitulosCV",
		// "true").data("filtros.visualizaTrabEventosCV", "true")
		// .data("filtros.visualizaTxtJornalRevistaCV",
		// "true").data("filtros.visualizaOutrasProdBibCV", "true")
		// .data("filtros.visualizaProdArtCultCV",
		// "true").data("filtros.visualizaOrientacoesConcluidasCV", "true")
		// .data("filtros.visualizaOrientacoesAndamentoCV", "true")
		// .data("filtros.visualizaDemaisTrabalhosCV", "true")
		// .data("filtros.visualizaDadosComplementaresCV", "true")
		// .data("filtros.visualizaOutrasInfRelevantesCV",
		// "true").data("filtros.radioPeriodoProducao", "1")
		// .data("filtros.modalidadeBolsa", "0").data("filtros.nivelFormacao",
		// "0")
		// .data("filtros.paisFormacao", "0").data("filtros.regiaoFormacao",
		// "0").data("filtros.ufFormacao", "0")
		// .data("filtros.buscaAtuacao",
		// "false").data("filtros.codigoGrandeAreaAtuacao", "0")
		// .data("filtros.codigoAreaAtuacao",
		// "0").data("filtros.codigoSubareaAtuacao", "0")
		// .data("filtros.codigoEspecialidadeAtuacao",
		// "0").data("filtros.idioma", "0")
		// .data("filtros.grandeAreaProducao", "0").data("filtros.areaProducao",
		// "0")
		// .data("filtros.setorProducao", "0").data("filtros.naturezaAtividade",
		// "0")
		// .data("filtros.paisAtividade", "0").data("filtros.regiaoAtividade",
		// "0")
		// .data("filtros.ufAtividade", "0").userAgent("Chrome").post();

		Document conn2 = Jsoup
				.connect(
						"http://buscatextual.cnpq.br/buscatextual/busca.do?metodo=forwardPaginaResultados&registros=0;2345&query=%28%2Bidx_nme_pessoa%3A%28marcos%29++%2Bidx_"
								+ "particao%3A1+%2Bidx_nacionalidade%3Ae%29+or+%28%2Bidx_nme_pessoa%3A%28marcos%29++%2Bidx_particao%3A1+%2Bidx_nacionalidade%3Ab%29&analise=cv"
								+ "&numeroPagina=11&tipoOrdenacao=null&paginaOrigem=index.do&mostrarScore=false&mostrarBandeira=true&modoIndAdhoc=null")
				.data("metodo", "buscar").userAgent("Chrome").maxBodySize(0).timeout(60000).get();

		String conv = conn2.select("a[href]").attr("rel", "nofollow").toString();
		String semaspas = conv.replaceAll("\"", "").replaceAll("'", "").replaceAll("_", " ");
		String[] parts = semaspas.split(",");
		List<String> partes = new ArrayList<>();
		int x = 1;
		while (x <= 4690) {
			partes.add(parts[x] + System.getProperty("line.separator"));
			x = x + 2;
		}
		
		FileWriter fw = new FileWriter(new File(""));
		for (String part : partes) {
			fw.write(part.toString());
		}
		
		fw.close();
	}
}
