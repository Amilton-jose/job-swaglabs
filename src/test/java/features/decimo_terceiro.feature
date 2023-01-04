
  Feature: Calculadora de decimo terceiro
    Eu como funcionario da modalidade CLT
    Quero calcular o valor do decimo terceiro
    Para saber o valor do decimo terceiro

    Background:
      Given eu acessei o site da Calculadora de decimo terceiro

    Scenario Outline: Net salary calculation
      When os dados salariais, <salario>, <dependentes>, <meses_trabalhados>, <parcela>
      Then eu tenho o valor <valor> do decimo terceiro
      Examples:
      |salario    |dependentes   |meses_trabalhados|parcela    | valor        |
      |"1000,00"  |"0"           |"12"             |"Única"    |"R$ 925,00"   |
#      |"1000,00"  |"0"           |"12"             |"Primeira" |"R$ 500,00"   |
#      |"1000,00"  |"0"           |"12"             |"Segunda"  |"R$ 425,00"   |
