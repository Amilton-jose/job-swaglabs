Feature:Eu, como Herói, quero ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.

  Background: realizar acesso na plataforma
    Given que eu acessei o site swag labs
    And fiz o login com credenciais validas fornecidas

  Scenario: Ordenar os valores do menor para o maior e que seja comprado os dois produtos menores.
    When ordeno os valores do menor para o mair
    And adiciono os dois produtos mais baratos
      | Sauce Labs Onesie     |
      | Sauce Labs Bike Light |
    And eu valido os produtos no carrinho
    And preencho dados de checkout
    Then eu vejo a mensagem "THANK YOU FOR YOUR ORDER"

