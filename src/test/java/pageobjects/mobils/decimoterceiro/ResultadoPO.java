package pageobjects.mobils.decimoterceiro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;
import static utils.Utils.validatePage;

public class ResultadoPO {

    WebDriver driver;

    public ResultadoPO() {
        this.driver = getDriver();
    }

    public void validateResultPage() {
        validatePage(By.id("tableResults"), "300","0");
    }

    public void validateLiquidSalary(String liquidSalary) {
        WebElement element = getElement(By.id("total-desc-liquid"));
        String value = element.getText();
        Assert.assertEquals(liquidSalary, value, "Different salary");
        appendToReportElementHighlight(element);
    }

}
