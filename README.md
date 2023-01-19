# SESSÃO 1


# DICAS DE USO

## **Configurando projeto**
### 1° Clone o projeto para seu computador
### 2° Depois de clonado abra o a pasta do projeto clonado na sua IDE (Exemplos: Intellij) .
### 3° Depois de aberto o projeto. Vá até o arquivo pom.xml. Dentro desse arquivo  irá aparecer um botão com a logo do Maven clique e espera baixar as depedências.

### Pronto seu projeto foi configurado.


## **Executando os testes do projeto**

### 1° Procure a pasta dentro do src na pasta test haverá uma pasta com nome java, dentro dela havéra a pasta runner.
### 2° Dentro da pasta runner tem uma classe chamada Runner. Clique nela duas vezes e execute a mesma.

### Pronto os testes serão executados



## **Analisando evidências dos testes no dashboard**

### 1° Depois de executar os testes, vá até a pasta target. Dentro dela havéra outra pasta chamada output
### 2° Dentro da pasta output haverá um arquivo chamdo report.html clique nele duas vezes.
### 3° Após o passo dois. No canto superior esquerdo do documento aberto haverá opções de navegador para abrir. Clique em alguma delas e veja a analise dos testes com evidências





























# SESSÃO 2



# Plano de testes




### Features: Eu, como Herói, desejo realizar a compra de camisa vermelha.
### Features: Eu, como Herói, desejo realizar a compra de uma bolsa.
### Features: Eu, como Herói, quero ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.






##  **Casos de testes**.



### CT01: Realizar compra de uma camisa vermelha.
### CT02: Realizar compra de uma uma bolsa.
### CT03: Ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.



## **Cenários implementados**

### Background: realizar acesso na plataforma
    Given que eu acessei o site swag labs
    And fiz o login com credenciais validas fornecidas

### Scenario Outline: Realizar compra de produtos
    When procurar produto <produto>
    And adiciono o produto no carrinho de compras
    And finalizo a compra
    Then eu vejo a mensagem de sucesso
    Examples:
      | produto                             |
      | "Test.allTheThings() T-Shirt (Red)" |
      | "Sauce Labs Backpack"               |



### Background: realizar acesso na plataforma
### Given que eu acessei o site swag labs
    And fiz o login com credenciais validas fornecidas

## Scenario: Ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.
    When ordeno os valores do menor para o mair
    And adiciono os dois produtos mais baratos
      | Sauce Labs Onesie     |
      | Sauce Labs Bike Light |
    And eu valido os produtos no carrinho
    And preencho dados de checkout
    Then eu vejo a mensagem "THANK YOU FOR YOUR ORDER"
    
    
    
    
    
    
