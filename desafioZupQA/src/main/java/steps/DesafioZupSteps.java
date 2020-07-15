package steps;

import static core.DriverFactory.KillDriver;
import static core.DriverFactory.getDriver;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;
import pages.ResultadoPesquisaPage;


public class DesafioZupSteps {

	private HomePage homePage = new HomePage();
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	private ProdutoPage produtoPage = new ProdutoPage();
	private ResultadoPesquisaPage resultadoPesquisaPage = new ResultadoPesquisaPage();
	private String nomeProduto, valorProduto;


	@Before
	public void setUp() {
		getDriver();
	}

	

	@Dado("estou na pagina inicial com o carrinho vazio")
	public void estou_na_pagina_inicial_com_o_carrinho_vazio() {
		homePage.verificaQtdeCarrinhoZerado();
	}

	@Quando("busco por um produto {string}")
	public void busco_por_um_produto(String produto) {
		homePage.pesquisaProduto(produto);
	}

	@Entao("valido o retorno da busca {string}")
	public void valido_o_retorno_da_busca(String produto) {
		resultadoPesquisaPage.validaPesquisaProduto(produto);
	}

	@Entao("pego nome do produto")
	public void pego_o_nome_do_produto() {
		nomeProduto = produtoPage.pegaNomeProduto();
	}

	@Entao("pego o valor do produto")
	public void pego_o_valor_do_produto() {
		valorProduto = produtoPage.pegaPrecoProduto();
	}

	@Quando("Adiciono o produto no carrinho")
	public void adiciono_o_produto_no_carrinho() {
		produtoPage.adicionaNoCarrinho();
	}

	@Entao("verifico informacoes no carrinho")
	public void verifico_informacoes_no_carrinho() {
		carrinhoPage.verificaInformacoesCarrinho(nomeProduto, valorProduto);
	}

	@Entao("volto para a pagina inicial com item no carrinho")
	public void volto_para_a_pagina_inicial_com_item_no_carrinho() throws AWTException {
		homePage.verificaQtdeCarrinhoIgualUm();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String idScenario = scenario.getId().substring(scenario.getId().lastIndexOf(".feature:")+9);
		String nomeArquivo = "target" + File.separator + "screenshot" + File.separator + scenario.getName() + "_" +  scenario.getStatus() + "_" + idScenario + ".jpg";
		FileUtils.copyFile(arquivo, new File(nomeArquivo));

		KillDriver();
	}

}
