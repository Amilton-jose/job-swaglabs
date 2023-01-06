package pageobjects.mobils.decimoterceiro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;

public class HomePO {

    WebDriver driver;

    public HomePO() {
        this.driver = getDriver();
    }

    public void closePopup() {
        driver.findElement(By.cssSelector("body > div.bGGcZJZR7IsEsQjTbspD-box.bGGcZJZR7IsEsQjTbspD-width-400.bGGcZJZR7IsEsQjTbspD-margin-14.tsG0HQh7bcmTha7pyanx-pos.tsG0HQh7bcmTha7pyanx-h-center.tsG0HQh7bcmTha7pyanx-v-top.tsG0HQh7bcmTha7pyanx-animation-fade-in2 > div.bGGcZJZR7IsEsQjTbspD-content-wrapper > div.bGGcZJZR7IsEsQjTbspD-html-content > div.tsG0HQh7bcmTha7pyanx-button-wrapper > button.tsG0HQh7bcmTha7pyanx-box-btn.tsG0HQh7bcmTha7pyanx-btn-close")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("Layer_1")).click();
    }

    public void selectMenu(String menu) {
        WebElement option = driver.findElement(By.className("ul-primary"));
        List<WebElement> options = option.findElements(By.tagName("li"));
        for (WebElement e:options
             ) {
            if (e.getText().contains(menu)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(e).build().perform();
                break;
            }
        }
    }

    public void selectMenuTool(String tool) {
        WebElement option = driver.findElement(By.id("3-navigation-tabs"));
        List<WebElement> options = option.findElements(By.tagName("li"));
        for (WebElement e:options
        ) {
            if (e.getText().contains(tool)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(e).build().perform();
                break;
            }
        }
    }

    public void selectLaborCalculationTools(String tool) {
        WebElement option = driver.findElement(By.cssSelector("#\\33 -panel-3 > nav > ul"));
        List<WebElement> options = option.findElements(By.tagName("li"));
        for (WebElement e:options
        ) {
            if (e.getText().contains(tool)) {
                Actions actions = new Actions(driver);
                appendToReportElementHighlight(e);
                actions.click(e).build().perform();
                break;
            }
        }
    }

    public void getLaborCalculation(String menu, String subMenu, String tool) throws InterruptedException {
        closePopup();
        selectMenu(menu);
        Thread.sleep(5000);
        selectMenuTool(subMenu);
        Thread.sleep(5000);
        selectLaborCalculationTools(tool);
    }


}
