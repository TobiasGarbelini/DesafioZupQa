package pages;

import core.DSL;

public class ResultadoPesquisaPage extends DSL {

	public void validaPesquisaProduto(String produto) {
		// espero carregar os produtos
		esperaElementoclicavelLinkText(produto);
		// varifico se a descrição da pesquisa é a mesma da que digitei anteriormente
		verificaClasse("page-title", produto);
		// selecionando um dos produtos da pesquisa
		clickCSSSelector(".row > .product-grid-item:nth-child(1)");
	}

}
