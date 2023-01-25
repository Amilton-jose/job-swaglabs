


### DICAS DE USO

### **Configurando projeto**
#### 1° Clone o projeto para seu computador
#### 2° Depois de clonado abra o a pasta do projeto clonado na sua IDE (Exemplo: Intellij) .
#### 3° Depois de aberto o projeto. Vá até o arquivo pom.xml. Dentro desse arquivo  irá aparecer um botão com a logo do Maven clique e espere baixar as depedências.


#### Pronto seu projeto foi configurado.


### **Executando os testes do projeto**

#### 1° Procure a pasta dentro do src na pasta test haverá uma pasta com nome java, dentro dela haverá a pasta runner.
#### 2° Dentro da pasta runner tem uma classe chamada Runner. Clique nela duas vezes e execute a mesma.

#### Pronto os testes serão executados



### **Analisando evidências dos testes no dashboard**

#### 1° Depois de executar os testes, vá até a pasta target. Dentro dela havará outra pasta chamada output
#### 2° Dentro da pasta output haverá um arquivo chamado report.html clique nele duas vezes.
#### 3° Após o passo 2°. No canto superior direito do documento aberto haverá opções de navegadores para abrir. Clique em alguma delas e veja a analise dos testes com evidências








### Plano de testes




#### Features: Eu, como Herói, desejo realizar a compra de camisa vermelha.     
#### Features: Eu, como Herói, desejo realizar a compra de uma bolsa.
#### Features: Eu, como Herói, quero ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.






### **Cenários implementados**





    Background: realiza acesso no site
    Given acessei o site swag labs
    And preencher credenciais validas de login


    Scenario: Validar se os produtos camisa vermelha e bolsa existem na lista de produtos
    When acesso a lista de produtos
    Then vejo o produtos
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |


    Scenario: Validar a adição dos produtos camisa vermelha e bolsa ao carrinho
    When acesso a lista de produtos
    Then vejo o produtos
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
    And adiciono no carrinho
    Then vejo o produtos no carrinho


    Scenario: Validar o valor total dos produtos camisa vermelha e bolsa
    When acesso a lista de produtos
    Then vejo o produtos
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
    And adiciono no carrinho
    Then vejo o produtos no carrinho
    And acesso o checkout de informacoes
    When preencho as informacoes de nome "nome", sobrenome "sobrenome" e codigo postal "code" e clico em continue
    Then vejo o valor total


    Scenario: Validar a compra dos produtos camisa vermelha e bolsa
    When acesso a lista de produtos
    Then vejo o produtos
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
    And adiciono no carrinho
    Then vejo o produtos no carrinho
    And acesso o checkout de informacoes
    When preencho as informacoes de nome "nome", sobrenome "sobrenome" e codigo postal "code" e clico em continue
    Then vejo o valor total
    When finalizo a compra
    Then vejo a mensagem "THANK YOU FOR YOUR ORDER"



    Scenario Outline: Ordenar preços dos produtos do menor para o maior e comprar os dois mais baratos
    When acesso a lista de produtos
    And ordenar produtos <ordem>
    Then vejo o produtos
      | Sauce Labs Onesie     |
      | Sauce Labs Bike Light |
    And adiciono no carrinho
    Then vejo o produtos no carrinho
    And acesso o checkout de informacoes
    When preencho as informacoes de nome "nome", sobrenome "sobrenome" e codigo postal "code" e clico em continue
    Then vejo o valor total
    When finalizo a compra
    Then vejo a mensagem "THANK YOU FOR YOUR ORDER"
    Examples:
      | ordem                 |
      | "Price (low to high)" |


















    
    
    
    
    
    
    
    
    
