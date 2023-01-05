Feature: Calculadora de Ferias
  Eu como usuario quero poder calcular
  o salario de minhas ferias para saber
  o valor liquido

  Background:
    Given eu acessei o site da calculadora de ferias

  Scenario Outline: Calculo de ferias
    When insiro o salario <salario>,hora extra <horaExtra>,dependentes <dependentes>, dias de ferias <ferias>, abono <abono> e primeira parcela <primeiraParcela>
    Then o sistema exibe o valor <valorLiquido> liquido das ferias

    Examples:
      | salario    | horaExtra | dependentes | ferias | abono | primeiraParcela | valorLiquido |
      | "10000,00" | "0,00"    | "0"         | "30"   | "Sim" | "Não"           | "R$ 14.379,89"   |
