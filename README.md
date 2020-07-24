# DesafioZupQA
Desafio Zup QA
Projeto de testes criado para verificar o processo de compra em um site de vendas.


O Projeto foi feito usando Selenium, Cucumber, JUnit 5 e JDK 14

inicialmente eu adiciono a library do JUnit 5 ao meu projeto:
1) No Package Explorer, clique com o botão direito no nome do projeto, que aparece logo acima de "src/main/java" e no menu suspenso clique em "Properties". Na caixa de diálogo, digite no campo "type filter text" o valor "build". Então clique na opção "Java Build Path" que aparecerá logo abaixo da caixa de texto de pesquisa. vá até a aba "Libraries", e clique na opção "Add Library...", na caixa de dialogo que abrir vá na opção "JUnit" e clique no botão "Next", no combo "JUnit library version:" Selecione a opção "JUnit 5" e depois clique em "Finish". Depois na caixa de dialogo das propriedades clique em "Apply and Close". Pronto, assim as importações do JUnit funcionaram.

Como usei o Eclipse 2020-03, para usar o mesmo foi necessário intalar um plugin, e acertar para que eu possa usar o JDK 14 da seguinte forma:
1) No Package Explorer (esquerda da tela) clique com o botão direito em "JRE System Libray" e selecione no menu a opção "Properties".  Na caixa de diálogo com o título "Properties for JRE System Library" certifique-se que está selecionada a opção "Workspace default JRE" e clique no botão "Apply and Close". Note que entre parênteses aparece a versão do Java configurada como padrão no Eclipse. No meu caso está aparecendo "Workspace default JRE (jdk_14.0.1)". Se estão com a versão Oracle Java configurado por padrão pode aparecer algo parecido como  "jdk_1.8". Importante anotarem a versão que está aparecendo como padrão, pois isso será importante no próximo passo.
2) No Package Explorer, clique com o botão direito no nome do projeto, que aparece logo acima de "src/main/java" e no menu suspenso clique em "Properties". Na caixa de diálogo, digite no campo "type filter text" o valor "compiler". Então clique na opção "Java Compiler" que aparecerá logo abaixo da caixa de texto de pesquisa. Para concluir, no dropdown "Compiler compliance level" selecione a versão correspondente à versão do Java configurada na sua máquina (que apareceu no primeiro passo) e clique no botão "Appy and Close". O Eclipse pode solicitar para fazer uma recompilação (rebuild) do programa. Confirme que sim.
3) Agora será possivel rodar o teste com a opção "Run As" > "JUnit Test".
