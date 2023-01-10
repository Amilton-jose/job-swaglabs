package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.testng.Assert;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class LoginPO {

    private String campoUsuario = "user-name";
    private String campoSenha = "password";
    private String btnLogin = "login-button";
    private String logo = "login_logo";
    private String loginSucesso = "title";
    private String loginInvalido = "#login_button_container > div > form > div.error-message-container.error > h3";

    public void validarPaginaLogin() {
        appendToReport();
        Assert.assertTrue(getElement(By.className(logo)).isDisplayed(), "Elemento não encontrado na página de login!");
    }

    public void inserirUsuario(String usuario) {
        elementSendKeys(By.id(campoUsuario), usuario);
    }

    public void inserirSenha(String senha) {
        elementSendKeys(By.id(campoSenha), senha);
    }

    public void setBtnLogin() {
        elementClick(By.id(btnLogin));
    }

    public void fazerLogin(String usuario, String senha) {
        inserirUsuario(usuario);
        inserirSenha(senha);
        appendToReportElementHighlight(getElement(By.className("login-box")));
        setBtnLogin();
    }

    public void validarLoginComSucesso(String mensagem) {
        Assert.assertTrue(getElement(By.className(loginSucesso)).getText().toLowerCase().contains(mensagem.toLowerCase()), "O login não foi efeutado com sucesso");
    }



}
