package gherkin.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class SwagLabsSteps {

    LoginPO loginPO;

    @Given("eu acessei o site da swag labs")
    public void eu_acessei_o_site_da_swag_labs() {
        loginPO = new LoginPO();
        loginPO.validarPaginaDeLogin();
    }
    @When("insiro usuario {string} e senha {string}")
    public void insiro_usuario_e_senha(String usuario, String senha) {
        loginPO.loginValido(usuario,senha);
    }
    @Then("eu vejo uma mensagem {string}")
    public void eu_vejo_uma_mensagem(String mensagem) {
       loginPO.validarLoginValido(mensagem);
    }

}
