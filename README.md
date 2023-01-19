# Plano de testes

### Features: Eu, como Herói, desejo realizar a compra de camisa vermelha.
### Features: Eu, como Herói, desejo realizar a compra de uma bolsa.
### Features: Eu, como Herói, quero ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.


###  **Casos de testes**.

### CT01: Realizar compra de uma camisa vermelha.
### CT02: Realizar compra de uma uma bolsa.

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



### CT03: Ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.


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
    
    
    
    
    
    
