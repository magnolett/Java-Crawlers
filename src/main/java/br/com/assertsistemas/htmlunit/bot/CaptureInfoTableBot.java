package br.com.assertsistemas.htmlunit.bot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import br.com.assertsistemas.entity.SimplesNacional;

public class CaptureInfoTableBot extends SettingBot {

	private static final String PORTAL_TRANSPARENCIA_TABLE = "http://www.normaslegais.com.br/legislacao/simples-nacional-anexoII.html";

	public List<SimplesNacional> tableManipulator() throws Exception {
		final WebClient webClient = new WebClient(); // Instancia o webClient
		final HtmlPage page = webClient.getPage(PORTAL_TRANSPARENCIA_TABLE); // Instancia uma page e, pegando o webClient, lê a URL "PORTAL_TRANSPARENCIA_TABLE"
		final List<SimplesNacional> simplesNacionals = new ArrayList<>(); // Cria um ArrayList do objeto

		page.getElementsByTagName("table").forEach(e -> { // Procura na página o elemento "table" para fazer a função "um para cada"
			if ("MsoTableGrid".equals(e.getAttribute("class"))) { // Se "MsoTableGrid" for igual ao atributo "class" então..
				
				final String demilitador = "Receita Bruta em 12 meses (em R$)";
				final HtmlTable table = (HtmlTable) e; // Cria uma leitura de table
				
				for (final HtmlTableRow row : table.getRows()) { // Cria e relaciona a leitura de linhas
					//System.out.println("\n Linha encontrada! \n"); // Printa linhas

					if(!row.getCell(0).asText().contains(demilitador)){
						final SimplesNacional simplesNacional = new SimplesNacional(); // Instancia o objeto
						
						int index = 0; // Contador para pegar a celular
						String receitaBruta = row.getCell(index++).asText(); // Coluna 0
						String aliquota = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 1
						String irpj = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 2
						String csll = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 3
						String cofins = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 4
						String pisPas = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 5
						String cpp = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 6
						String icms = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 7
						String ipi = row.getCell(index++).asText().replaceAll("%", "").replaceAll("\\,", "."); // Coluna 8
						
						simplesNacional.setAliquota(new BigDecimal(aliquota));  // Setando no objeto
						simplesNacional.setIrpj(new BigDecimal(irpj)); // Setando no objeto
						simplesNacional.setCsll(new BigDecimal(csll)); // Setando no objeto
						simplesNacional.setCofins(new BigDecimal(cofins)); // Setando no objeto
						simplesNacional.setPasep(new BigDecimal(pisPas)); // Setando no objeto
						simplesNacional.setCpp(new BigDecimal(cpp)); // Setando no objeto
						simplesNacional.setIcms(new BigDecimal(icms)); // Setando no objeto
						simplesNacional.setIpi(new BigDecimal(ipi)); // Setando no objeto
						
						final String[] receitasBrutas = receitaBruta.replaceAll("De", "").replaceAll("Até ", "").replaceAll("\\.", "").
								replaceAll("\\,", ".").split(" a "); // Cria um array de string com replace all e o split do 'a' para separar os valores
						
						if(receitasBrutas.length >= 2){ // Se esse array for maior ou igual a 2 então..
							final Double valor01 = Double.valueOf(receitasBrutas[0]); // O numérico (Double) valor01 é igual ao array de string na posição [0]
							final Double valor02 = Double.valueOf(receitasBrutas[1]); // O numérico (Double) valor02 é igual ao array da string na posição [1]
							
							simplesNacional.setReceitaMinima(valor01);
							simplesNacional.setReceitaMaxima(valor02);
							
							//System.out.println(valor01); // Print do array convertido para double
							//System.out.println(valor02); // Print do array convertido para double
						} else { // Se array menor que 2 então..
							final Double valor01 = Double.valueOf(receitasBrutas[0]); // Converte novamente
							simplesNacional.setReceitaMaxima(valor01);
							simplesNacional.setReceitaMinima(0.0);
						}
						
						simplesNacionals.add(simplesNacional);
					}
				}
				
				simplesNacionals.forEach(s ->{System.out.println(s.toString());});
				
//				final String cleanContentLine = row.getCell(0).asText().replaceAll(",", ".").replaceAll("%", "")
//				.replaceAll("De", "").replaceAll("Até", "").replaceAll(" a ", "-");
//		
//		int i = 0;
//		if (row.getCell(i).equals("180.000.00")) {
//			i++;
//			row.getCell(i);
//			System.out.println(row.getCell(i));
//		}
//		
//		System.out.println(row.asText());
//		
//		if(cleanContentLine.split("-").length > 2){
//			String[] parts = cleanContentLine.split("-");
//			String part1 = parts[0];
//			String part2 = parts[1];
//			System.out.println(part1);
//			System.out.println(part2);
//			System.out.println(cleanContentLine);
//			System.out.println(row.getCell(0).asText().replaceAll(",", ".").replaceAll("%", "")
//					.replaceAll("De", "").replaceAll("Até", "0-").replaceAll(" a ", "-"));
//		}else {
//			System.out.println(cleanContentLine);
//		}
				
				
//				final HtmlDivision htmlClass = (HtmlDivision) e;
//				table.getRows().forEach(row -> {
//					Integer cell = 1;
//
//				});
//				
//				if (htmlClass.getElementsByTagName("p") != null && !htmlClass.getElementsByTagName("p").isEmpty()) {
//					final String p = htmlClass.getElementsByTagName("p").get(0).asText();
//
//					if (p.contains("span")) {
//						System.out.println("Por class!");
//						if (e.getAttribute("font-family").equals("Times New Roman")) {
//
//						}
//					}
//
//				}

			}

		});

		return simplesNacionals;

	}

	public static void main(String[] args) throws Exception {

		new CaptureInfoTableBot().tableManipulator();
	}
}
