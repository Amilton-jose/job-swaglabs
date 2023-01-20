package gherkin.stepdefinition.swaglabs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.swaglabs.CarrinhoPO;
import pageobjects.swaglabs.CheckoutPO;
import pageobjects.swaglabs.LoginPO;
import pageobjects.swaglabs.ProdutoPO;

import java.util.List;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;

public class Steps {

    LoginPO loginPO;
    ProdutoPO produtoPO;
    CarrinhoPO carrinhoPO;
    CheckoutPO checkoutPO;
    List<String> produtos;
    List<String> valores;

    @Given("acessei o site swag labs")
    public void acessei_o_site_swag_labs() {
        loginPO = new LoginPO();
        produtoPO = new ProdutoPO();
        loginPO.validarPaginaLogin();
    }

    @Given("preencher credenciais validas de login")
    public void preencher_credenciais_validas_de_login() {
        loginPO.login("standard_user", "secret_sauce");
    }

    @When("acesso a lista de produtos")
    public void acesso_a_lista_de_produtos() {
        produtoPO.validarLogin();
        produtoPO.validarListaDeProdutos();
    }

    @When("ordenar produtos {string}")
    public void ordenar_produyos(String ordem) {
        produtoPO = new ProdutoPO();
        produtoPO.ordenarProdutos(ordem);
    }


    @Then("vejo o produtos")
    public void vejo_o_produtos(io.cucumber.datatable.DataTable dataTable) {
        produtos = dataTable.asList();
        produtoPO.validaProdutos(produtos);
    }

    @Then("adiciono no carrinho")
    public void adiciono_no_carrinho() {
        produtoPO = new ProdutoPO();
        carrinhoPO = new CarrinhoPO();
        valores = produtoPO.pegoValores(produtos);
        produtoPO.adicionarProdutos(produtos);
    }

    @Then("vejo o produtos no carrinho")
    public void vejo_o_produtos_no_carrinho() {
        carrinhoPO = new CarrinhoPO();
        carrinhoPO.validaProdutosNoCarrinho(produtos);
    }

    @Then("acesso o checkout de informacoes")
    public void acesso_o_checkout_de_informacoes() {
        carrinhoPO = new CarrinhoPO();
        checkoutPO = new CheckoutPO();
        carrinhoPO.btnCheckout();
    }

    @When("preencho as informacoes de nome {string}, sobrenome {string} e codigo postal {string} e clico em continue")
    public void preencho_as_informacoes_de_nome_sobrenome_e_codigo_postal_e_clico_em_continue(String nome, String sobrenome, String code) {
        checkoutPO.inseririnformacoes(nome, sobrenome, code);
        checkoutPO.btnContinuar();
    }

    @Then("vejo o valor total")
    public void vejo_o_valor_total() {
        checkoutPO.validarValorTotal(valores);
    }

    @When("finalizo a compra")
    public void finalizo_a_compra() {
        checkoutPO = new CheckoutPO();
        checkoutPO.btnFinalizar();
    }

    @Then("vejo a mensagem {string}")
    public void vejo_a_mensagem(String mensagem) {
        checkoutPO.validarCompraSucesso(mensagem);
    }


}
