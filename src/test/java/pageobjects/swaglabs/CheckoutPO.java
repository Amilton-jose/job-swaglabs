package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static utils.Utils.*;

public class CheckoutPO {
    private String campoPrimeiroNome = "first-name";
    private String campoSegundoNome = "last-name";
    private String campoCodigoPostal = "postal-code";
    private String btnContinuar = "continue";
    private String btnCancelar = "cancel";
    private String infoCompra = "summary_info";
    private String btnFinalizar = "finish";
    private String compraSucesso = "complete-header";

    private ProdutoPO produtoPO;

    /**
     *
     * **/

    // MÉTODOS DA PÁGINA DE PÁGINA (CONFIRA: SUAS INFORMAÇÕES)

    public void inserirInformacoesEContinuar(String primeiroNome, String segundoNome, String codigoPostal) {
        elementSendKeys(By.id(campoPrimeiroNome),primeiroNome);
        elementSendKeys(By.id(campoSegundoNome),segundoNome);
        elementSendKeys(By.id(campoCodigoPostal),codigoPostal);
        appendToReport();
        elementClick(By.id(btnContinuar));
        setBtnFinalizar();
    }

    public void inserirInformacoesECancelar(String primeiroNome, String segundoNome, String codigoPostal) {
        elementSendKeys(By.id(campoPrimeiroNome),primeiroNome);
        elementSendKeys(By.id(campoSegundoNome),segundoNome);
        elementSendKeys(By.id(campoCodigoPostal),codigoPostal);
        elementClick(By.id(btnCancelar));
    }

    public void inserirInformacoes(String primeiroNome, String segundoNome, String codigoPostal) {
        elementSendKeys(By.id(campoPrimeiroNome),primeiroNome);
        elementSendKeys(By.id(campoSegundoNome),segundoNome);
        elementSendKeys(By.id(campoCodigoPostal),codigoPostal);
    }

    // MÉTODOS DA PÁGINA DE (VERIFICAÇÃO: VISÃO GERAL)


    public void validarInfoGeral(String info){
        Assert.assertTrue(informacoesGerais(info).isDisplayed(),"Informação não encontrada!");
    }

    public WebElement informacoesGerais(String info){
        List<WebElement> elements = getDriver().findElements(By.className(infoCompra));
        WebElement item = null;
        for (WebElement p:elements) {
            if(p.getText().contains(info)){
                item = p;
            }
        }
        return item;
    }

    // MÉTODOS DA PÁGINA DE (VERIFICAÇÃO: SUCESSO)

    public void validarCompraSucesso(){
        WebElement element = getElement(By.className(compraSucesso));
        boolean flag = element.isDisplayed();
        System.out.println(flag);
        Assert.assertTrue(flag,"Compra não efetuada!");
    }

    public void setBtnFinalizar(){
        elementClick(By.id(btnFinalizar));
    }

    public void validarCompra(String mensagem){
        Assert.assertTrue(getElement(By.className(compraSucesso)).getText().contains(mensagem));
    }

}
