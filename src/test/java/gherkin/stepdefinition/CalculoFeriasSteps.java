package gherkin.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePO;
import pageobjects.ferias.CalculoFeriasPO;
import pageobjects.ferias.ResultadoFeriasPO;

public class CalculoFeriasSteps {

    HomePO homeFeriasPO;
    CalculoFeriasPO calculoFeriasPO;
    ResultadoFeriasPO resultadoFeriasPO;

    @Given("eu acessei o site da calculadora de ferias")
    public void eu_acessei_o_site_da_calculadora_de_ferias() throws InterruptedException {
        homeFeriasPO = new HomePO();
        calculoFeriasPO = new CalculoFeriasPO();
        resultadoFeriasPO = new ResultadoFeriasPO();
        homeFeriasPO.getLaborCalculation("Ferramentas","Calculadoras trabalhistas","Férias");

    }
    @When("insiro o salario {string},hora extra {string},dependentes {string}, dias de ferias {string}, abono {string} e primeira parcela {string}")
    public void insiro_o_salario_hora_extra_dependentes_dias_de_ferias_abono_e_primeira_parcela(String salarioBruto,
                                                                                                String horaExtra,
                                                                                                String dependentes,
                                                                                                String diasFerias,
                                                                                                String abono,
                                                                                                String primeiraParcela) {
      calculoFeriasPO.enviarFormulario(salarioBruto,horaExtra,dependentes,diasFerias,abono,primeiraParcela);
    }
    @Then("o sistema exibe o valor {string} liquido das ferias")
    public void o_sistema_exibe_o_valor_liquido_das_ferias(String valorLiquido) {
        resultadoFeriasPO.validarPaginaDeResultado();
        resultadoFeriasPO.validarValorDeFeriasLiquido(valorLiquido);
    }
}
