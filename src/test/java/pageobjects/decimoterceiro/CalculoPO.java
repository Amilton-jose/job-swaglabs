package pageobjects.decimoterceiro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static utils.Utils.*;

public class CalculoPO {

    WebDriver driver;

    public CalculoPO() {
        this.driver = getDriver();
    }

    public void validateCalculationPage() {
        validatePage(By.id("form-calculo-decimo-terceiro"), "300","0");
    }

    public void sendSalary(String salary) {
        elementSendKeys(By.id("salario-bruto-decimo"), salary);
    }
    public void sendDependents(String dependents) {
        elementSendKeys(By.id("dependent-qtd"), dependents);
    }
    public void sendMonths(String months) {
        elementSendKeys(By.id("meses-trabalhados"), months);
    }
    public void sendInstallment(String installment) {
        WebElement element = getElement(By.id("parce-decimo"));
        Select select = new Select(element);
        select.selectByVisibleText(installment);
    }
    public void btnSubmit() {
        elementClick(By.id("btnSend"));
        new Actions(driver).click().perform();
    }
    public void btnClear() {
        elementClick(By.id("btn-clean-decimo-terceiro"));
    }
    public void fillForm(String salary, String dependents,
                         String months, String installment) {
        sendSalary(salary);
        sendDependents(dependents);
        sendMonths(months);
        sendInstallment(installment);
        appendToReport("Filled form");
    }
    public void sendForm(String salary, String dependents,
                         String months, String installment) {
        fillForm(salary, dependents, months, installment);
        btnSubmit();
    }
    public void clearForm(String salary, String dependents,
                         String months, String installment) {
        fillForm(salary, dependents, months, installment);
        btnClear();
    }

}
