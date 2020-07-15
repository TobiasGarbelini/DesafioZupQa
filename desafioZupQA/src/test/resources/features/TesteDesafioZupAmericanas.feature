# language: pt
Funcionalidade: DesafioZup
  Entro no site da americanas
  verifico se o carrinho esta vazio
  busco por um produto que quero comprar
  valido o retorno da busca
  escolho um produto da lista 
  adiciono esse produto no carrinho
  verifico as informacoes do produto no carrinho
  volto para a pagina inicial
  verifico se o carrinho esta com a quantidade de produtos que eu adicionei

  @fluxoPadrao
  Esquema do Cenario: Deve adicionar um produto no carrinho e validar se o mesmo foi adicionar corretamente
    Dado estou na pagina inicial com o carrinho vazio
    Quando busco por um produto <produto>
    Entao valido o retorno da busca <produto>
    E pego nome do produto
    E pego o valor do produto
    Quando Adiciono o produto no carrinho
    Entao verifico informacoes no carrinho
    E volto para a pagina inicial com item no carrinho

    Exemplos: 
      | produto              |
      | "29302228"           |
      | "conjunto de panela" |
      | " "                  |
