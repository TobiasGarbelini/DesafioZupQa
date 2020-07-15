package testesAutomaticos;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.JavascriptExecutor;

import core.BaseTest;
import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;
import pages.ResultadoPesquisaPage;

@RunWith(Parameterized.class)
public class TesteDesafioZupAmericanas extends BaseTest {
	JavascriptExecutor js;
	private HomePage homePage = new HomePage();
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	private ProdutoPage produtoPage = new ProdutoPage();
	private ResultadoPesquisaPage resultadoPesquisaPage = new ResultadoPesquisaPage();


	@Parameter
	public String produto;

	

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
				// [0] pesquisando pelo código de um produto
				{ "29302228" },
				// [1] pesquisando pela descrição de um produto
				{ "conjunto de panela" },
				/* [2] quando fiz o teste, adicionando um espaço e mandando pesquisar estava ocorrendo
				 erro e página ficava indisponível e assim o teste falha*/
				{ " " }
		});
	}

	


	@Test
	public void pesquisa() throws AWTException {
		String  nomeProduto, valorProduto;
		homePage.verificaQtdeCarrinhoZerado();
		homePage.pesquisaProduto(produto);
		resultadoPesquisaPage.validaPesquisaProduto(produto);
		nomeProduto = produtoPage.pegaNomeProduto();
		valorProduto = produtoPage.pegaPrecoProduto();
		produtoPage.adicionaNoCarrinho();
		carrinhoPage.verificaInformacoesCarrinho(nomeProduto, valorProduto);
		homePage.verificaQtdeCarrinhoIgualUm();

	}

}
