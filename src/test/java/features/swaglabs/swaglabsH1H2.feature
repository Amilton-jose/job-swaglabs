Feature: Eu, como Herói, desejo realizar a compra de camisa vermelha e uma bolsa.


  Background: realizar acesso na plataforma
    Given que eu acessei o site swag labs
    And fiz o login com crendenciais validas fornecidas

  Scenario Outline: Realizar compra de produtos
    When procurar produto <produto>
    And adiciono o produto no carrinho de compras
    And finalizo a compra
    Then eu vejo a mensagem
    Examples:
      | produto                             |
      | "Test.allTheThings() T-Shirt (Red)" |
      | "Sauce Labs Backpack"               |
