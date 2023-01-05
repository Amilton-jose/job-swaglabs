package gherkin.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.decimoterceiro.CalculoPO;
import pageobjects.HomePO;
import pageobjects.decimoterceiro.ResultadoPO;

public class Steps {

    HomePO homePO;
    CalculoPO calculoPO;
    ResultadoPO resultadoPO;

    @Given("eu acessei o site da Calculadora de decimo terceiro")
    public void eu_acessei_o_site_da_calculadora_de_decimo_terceiro() throws InterruptedException {
        homePO = new HomePO();
        calculoPO = new CalculoPO();
        resultadoPO = new ResultadoPO();
        homePO.getLaborCalculation("Ferramentas",
                "Calculadoras trabalhistas", "Décimo Terceiro");
        calculoPO.validateCalculationPage();
    }

    @When("os dados salariais, {string}, {string}, {string}, {string}")
    public void os_dados_salariais(String salary, String dependents,
                                   String months, String installment) {
        calculoPO.sendForm(salary, dependents, months, installment);
    }
    @Then("eu tenho o valor {string} do decimo terceiro")
    public void eu_tenho_o_valor_do_decimo_terceiro(String liquidSalary) {
        resultadoPO.validateResultPage();
        resultadoPO.validateLiquidSalary(liquidSalary);
    }

}
