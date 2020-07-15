package pages;
 

import core.DSL;

public class ProdutoPage extends DSL {

	public String pegaPrecoProduto() {
		// pego o preço do produto
		String valorProduto = pegaValorStringClasse("price__SalesPrice-ej7lo8-2");
		return valorProduto;
	}

	public String pegaNomeProduto() {
		// pego o nome do produto
		String nomeProduto = pegaStringId("product-name-default");
		return nomeProduto;
	}

	public void adicionaNoCarrinho() {
		// clico em comprar
		//clickid("btn-buy");
		clickXpath("//div[2]/div/div[2]/div/div/div/div/a/div");
	}

}
