package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class LoginPO {
    WebDriver driver;

    public LoginPO() {
        this.driver = getDriver();
    }

    public void validarPaginaDeLogin() {
        WebElement element = getElement(By.className("login_logo"));
        boolean validacao = element.isDisplayed();
        Assert.assertTrue(validacao, "Titulo não encontrado.");
        appendToReportElementHighlight(getElement(By.className("login_logo")));
    }

    public void inserirUsuario(String usuario) {
        elementSendKeys(By.id("user-name"), usuario);
    }

    public void inserirSenha(String senha) {
        elementSendKeys(By.id("password"), senha);
    }

    public void btnLogin() {
        elementClick(By.id("login-button"));
    }
    public void loginValido(String usuario,String senha){
        inserirUsuario(usuario);
        inserirSenha(senha);
        appendToReportElementHighlight(getElement(By.tagName("form")));
        btnLogin();
    }

    public void validarLoginValido(String esperado) {
        WebElement element = getElement(By.className("title"));
        String validacao = element.getText();
        Assert.assertEquals(validacao, esperado,"O texto não foi encontrado");
        appendToReportElementHighlight(getElement(By.className("title")));
    }

    public void validarLoginSemCredenciais(){
        WebElement element = getElement(By.tagName("h3"));
        String mensagemDeErro = element.getText();
        Assert.assertTrue(mensagemDeErro.contains("Epic sadface: Username is required"));
    }
    public void validarLoginCredenciaisInvalidas(){
        WebElement element = getElement(By.tagName("h3"));
        String mensagemDeErro = element.getText();
        Assert.assertTrue(mensagemDeErro.contains("Epic sadface: Username and password do not match any user in this service"));
    }

    public void validarLoginSemInserirSenha(){
        WebElement element = getElement(By.tagName("h3"));
        String mensagemDeErro = element.getText();
        Assert.assertTrue(mensagemDeErro.contains("Epic sadface: Password is required"));
    }
    public void validarLoginSemInserirUsuario(){
        WebElement element = getElement(By.tagName("h3"));
        String mensagemDeErro = element.getText();
        Assert.assertTrue(mensagemDeErro.contains("Epic sadface: Username is required"));
    }


    public void usuarioBloqueado() {
        WebElement element = getElement(By.tagName("h3"));
        String mensagemDeErro = element.getText();
        Assert.assertTrue(mensagemDeErro.contains("Epic sadface: Sorry, this user has been locked out."));
    }

    public void usuarioComProblema() {
        WebElement element = getElement(By.className("inventory_item_img"));
        boolean duplicado = element.isDisplayed();
        Assert.assertTrue(duplicado,"A imagem não foi encontrada.");
    }
}
