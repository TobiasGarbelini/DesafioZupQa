package pages;

import core.DSL;

public class CarrinhoPage extends DSL {

	public void verificaInformacoesCarrinho(String nomeProduto, String valorProduto) {
		// espero carregar na tela do carrinho o input de cep
		esperaElementoclicavelId("cep");
		// verifico as informações do produto que peguei anteriormente
		verificaClasse("link-default", nomeProduto);
		verificaClasse("basket-productPrice", valorProduto);
		verificaClasse("summary-total", valorProduto);
		// volto na pagina inicial clicando na logo
		clickid("brd-link");
	}

}
