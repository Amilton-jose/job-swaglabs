package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.testng.Assert;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class LoginPO {

    public void validarPaginaLogin(){
        appendToReport();
        Assert.assertTrue(getElement(By.className("login_logo")).isDisplayed(),"Não está na página de login");
    }

    public void inserirUsuario(String nome){
        elementSendKeys(By.id("user-name"),nome);
    }

    public void inserirSenha(String senha){
        elementSendKeys(By.id("password"),senha);
    }

    public void btnLogin(){
        elementClick(By.id("login-button"));
    }

    public void login(String usuario,String senha){
        inserirUsuario(usuario);
        inserirSenha(senha);
        appendToReportElementHighlight(getElement(By.tagName("form")));
        btnLogin();
    }

}
