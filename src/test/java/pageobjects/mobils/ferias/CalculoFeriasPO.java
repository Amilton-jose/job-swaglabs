package pageobjects.mobils.ferias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class CalculoFeriasPO {
    WebDriver driver;

    public CalculoFeriasPO() {
        this.driver = getDriver();
    }

    public void validarPaginaCalculoFerias() {
        validatePage(By.cssSelector("body > div.off-canvas-wrapper > div > div > main > section.h-inner.fix." +
                "bg-blue-light.padding-40.mb-10 > div > div > div > h1"), "0", "300");
        appendToReportElementHighlight(getElement(By.cssSelector("body > div.off-canvas-wrapper > div > div > main > section.h-inner.fix.\" +\n" +
                "                \"bg-blue-light.padding-40.mb-10 > div > div > div > h1")));
    }

    public void inserirSalarioBruto(String salarioBruto) {
        elementSendKeys(By.id("salario-bruto"), salarioBruto);
    }

    public void inserirMediaHoraExtra(String horaExtra) {
        elementSendKeys(By.id("media-hora-extra"), horaExtra);
    }

    public void inserirNumeroDependentes(String dependentes) {
        elementSendKeys(By.id("numero-dependentes"), dependentes);
    }

    public void inserirDiasDeFerias(String diasDeFerias) {
        elementSendKeys(By.id("dias-ferias"), diasDeFerias);
    }

    public void inserirAbono(String opcaoAbono) {
        Select select = new Select(getElement(By.id("abono-pecuniario")));
        select.selectByVisibleText(opcaoAbono);
    }

    public void primeiraParcela(String opcaoPrimeiraParcela) {
        Select select = new Select(getElement(By.id("adiantamento-parcela-decimo")));
        select.selectByVisibleText(opcaoPrimeiraParcela);
    }

    public void botaoCalcular() {
        elementClick(By.id("btnSend"));
    }

    public void preencherFormulario(String salarioBruto,
                                    String horaExtra,
                                    String dependentes,
                                    String diasDeFerias,
                                    String opcaoAbono,
                                    String opcaoPrimeiraParcela) {
        inserirSalarioBruto(salarioBruto);
        inserirMediaHoraExtra(horaExtra);
        inserirNumeroDependentes(dependentes);
        inserirDiasDeFerias(diasDeFerias);
        inserirAbono(opcaoAbono);
        primeiraParcela(opcaoPrimeiraParcela);
    }

    public void enviarFormulario(String salarioBruto,
                                 String horaExtra,
                                 String dependentes,
                                 String diasDeFerias,
                                 String opcaoAbono,
                                 String opcaoPrimeiraParcela) {
        preencherFormulario(salarioBruto,horaExtra,dependentes,diasDeFerias,opcaoAbono,opcaoPrimeiraParcela);
        botaoCalcular();
    }
}
