package pageobjects.ferias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;
import static utils.Utils.validatePage;

public class ResultadoFeriasPO {
    WebDriver driver;

    public ResultadoFeriasPO() {
        this.driver = getDriver();
    }

    public void validarPaginaDeResultado(){
        validatePage(By.cssSelector("#card-calculadora-resultado-ferias > div > div > div > div:nth-child(2) > div > b"),"0","300");
        appendToReportElementHighlight(getElement(By.cssSelector("#card-calculadora-resultado-ferias > div > div > div > div:nth-child(2) > div > b")));
    }

    public void validarValorDeFeriasLiquido(String salarioFerias){
        Assert.assertEquals(getElement(By.id("total-vacation-liquid")).getText(),salarioFerias,"Os valores não estão de acordo.");
    }


}
