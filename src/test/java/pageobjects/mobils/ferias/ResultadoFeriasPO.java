package pageobjects.mobils.ferias;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scrollPage("300","0");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementClick(By.className("table"));
        new Actions(getDriver()).keyDown(Keys.ARROW_DOWN).perform();
        Assert.assertEquals(getElement(By.id("total-vacation-liquid")).getText(),salarioFerias,"Os valores não estão de acordo.");
        appendToReportElementHighlight(getElement(By.id("total-vacation-liquid")));
    }



}
