package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;
import static utils.Utils.castToFloat;

public class CheckoutPO {

    public void validarPaginaCheckout() {
        Assert.assertTrue(getElement(By.cssSelector("#header_container > div.header_secondary_container > span")).
                isDisplayed(), "Não está na página de checkout-info");
    }

    public void validarMensagemErro(String mensagem) {
        Assert.assertEquals(getElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")).getText(), mensagem, "Erro não encontrado!");
    }

    public void validarCheckoutGeral(String mensagem) {
        Assert.assertTrue(getElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText().contains(mensagem), "Não acessou checkout geral!");
    }

    public void inserirNome(String nome) {
        elementSendKeys(By.id("first-name"), nome);
    }

    public void inserirSobrenome(String sobrenome) {
        elementSendKeys(By.id("last-name"), sobrenome);
    }

    public void inserirCode(String code) {
        elementSendKeys(By.id("postal-code"), code);
    }

    public void inseririnformacoes(String nome, String sobrenome, String code) {
        inserirNome(nome);
        inserirSobrenome(sobrenome);
        inserirCode(code);
    }

    public void btnContinuar() {
        appendToReportElementHighlight(getElement(By.id("checkout_info")));
        elementClick(By.id("continue"));
    }

    public void btnFinalizar(){
        elementClick(By.id("finish"));
    }

    public String pegaValorTotal() {
        WebElement precoTotal = getElement(By.className("summary_subtotal_label"));
        new Actions(getDriver()).moveToElement(precoTotal).build().perform();
        String totalPrice = precoTotal.getText();
        return totalPrice;
    }

    public void validarValorTotal(List<String> valores) {
        Float somaValores = 0.00f;
        for (String valor:valores
        ) {
            /*
             * Removo o $ da String price
             * */
            valor = valor.replace("$", "");
            somaValores = somaValores + castToFloat(valor);
        }
        Assert.assertTrue(pegaValorTotal().contains(somaValores.toString()),
                "Total price is different");
        appendToReportElementHighlight(getElement(By.className("summary_subtotal_label")));
    }

    public void validarCompraSucesso(String mensagem){
        appendToReportElementHighlight(getElement(By.className("complete-header")));
        Assert.assertTrue(getElement(By.className("complete-header")).getText().contains(mensagem),"Compra não efetuada!");
    }


}






