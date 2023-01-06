Feature: Validar login
  Eu como usuario quero acessar o site swag labs
  e fazer login ver produtos a venda.


  Scenario Outline: validar login no site swag labs
    Given eu acessei o site da swag labs
    When insiro usuario <usuario> e senha <senha>
    Then eu vejo uma mensagem <mensagem>
    Examples:
      | usuario         | senha          | mensagem   |
      | "standard_user" | "secret_sauce" | "PRODUCTS" |


