package gherkin.stepdefinition.swaglabs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swaglabs.CarrinhoPO;
import pageobjects.swaglabs.CheckoutPO;
import pageobjects.swaglabs.LoginPO;
import pageobjects.swaglabs.ProdutoPO;

import java.util.List;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.espera;

public class Steps {

    LoginPO loginPO;
    ProdutoPO produtoPO;
    CarrinhoPO carrinhoPO;
    CheckoutPO checkoutPO;
    String product;
    List<String> listProducts;

    @Given("que eu acessei o site swag labs")
    public void que_eu_acessei_o_site_swag_labs() {
        loginPO = new LoginPO();
        produtoPO = new ProdutoPO();
        carrinhoPO = new CarrinhoPO();
        checkoutPO = new CheckoutPO();
        loginPO.validarPaginaLogin();
    }
    @Given("fiz o login com crendenciais validas fornecidas")
    public void fiz_o_login_com_crendenciais_validas_fornecidas() {
        loginPO.fazerLogin("standard_user","secret_sauce");
    }
    @When("procurar produto {string}")
    public void procurar_produto(String produto) {
        this.product = produto;
        produtoPO.pegaProduto(product);
    }
    @When("adiciono o produto no carrinho de compras")
    public void adiciono_o_produto_no_carrinho_de_compras() {
        produtoPO.adicionarProdutoCarrinho(this.product);
        produtoPO.acessarCarrinho();
    }
    @When("finalizo a compra")
    public void finalizo_a_compra() {
        carrinhoPO.validarProdutoNoCarrinho(this.product);
        carrinhoPO.btnCheckout();
        checkoutPO.inserirInformacoesEContinuar("PrimeioNome","SegundoNome","5000000");
    }
    @Then("eu vejo a mensagem")
    public void eu_vejo_a_mensagem()  {
        checkoutPO.validarCompraSucesso();
    }

    @When("ordeno os valores do maior para o menor")
    public void ordeno_os_valores_do_maior_para_o_menor() {
        produtoPO = new ProdutoPO();
        produtoPO.ordenarProdutos("lohi");
        appendToReport();
    }
    @When("adiciono os dois produtos mais baratos")
    public void adiciono_os_dois_produtos_mais_baratos(io.cucumber.datatable.DataTable dataTable) {
        listProducts = dataTable.asList();
        produtoPO.adicionaProdutos(listProducts);
    }
    @When("eu valido os produtos no carrinho")
    public void eu_valido_os_produtos_no_carrinho() {
       carrinhoPO = new CarrinhoPO();
       produtoPO.acessarCarrinho();
       carrinhoPO.validateProductsAndCheckout(listProducts);
    }
    @When("preencho dados de checkout")
    public void preencho_dados_de_checkout() {
       checkoutPO.inserirInformacoesEContinuar("Amilton","jose","53550837");
    }

    @Then("eu vejo a mensagem {string}")
    public void eu_vejo_a_mensagem(String mensagem) {
        checkoutPO.validarCompra(mensagem);
    }

}
