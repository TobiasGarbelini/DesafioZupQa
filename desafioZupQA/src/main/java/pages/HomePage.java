package pages;
 

import java.awt.AWTException;

import core.DSL;

public class HomePage extends DSL {

	public void verificaQtdeCarrinhoZerado() {
		// verificando o valor que tenho na classe que fica a quantidade de produtos do
		// carrinho
		verificaClasse("crt-quantity", "0");
	}

	/*
	 * fiz dessa forma pois apenas estou colocando um produto, mas se fosse oc aso
	 * de validar mais de um, teria que criar um contador para isso
	 */
	public void verificaQtdeCarrinhoIgualUm() throws AWTException {
		// esperei o elemento de pesquisa da pagina inicial abrir
		esperaElementoclicavelId("h_search-input");
		/*
		 * coloquei essa função de mover o mouse até a classe, pois temos um problema, o
		 * contador do carrinho não está atualizando até que passemos o mouse em cima da
		 * cesta por isso coloquei, mas de qualquer forma, as vezes ele atualiza e as
		 * vezes não, isso deveria ser corrigo, pois nas outras telas o mesmo é
		 * atualizado sempre que entramos em qualquer outra tela.
		 */
		moverMouseParaClasse("crt-quantity");
		verificaClasse("crt-quantity", "1");
	}

	public void pesquisaProduto(String produto) {
		// espero carregar o input de pesquisa
		esperaElementoclicavelId("h_search-input");
		// adiciono no input de pesquisa o que desejo
		preencheInputPorId("h_search-input", produto);
		// clico no botão de pesquisa
		clickid("h_search-btn");

	}

}
