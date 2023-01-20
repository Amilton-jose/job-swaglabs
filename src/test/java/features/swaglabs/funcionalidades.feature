Feature: Compras no E-Commerce Swag labs Demo


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











