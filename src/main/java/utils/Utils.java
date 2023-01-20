package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;

public class Utils {

    public static void scrollPage(String down, String up) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.scrollBy(" + up + "," + down + ")");
    }

    public static WebElement getElement(By by) {
        WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public static void elementClick(By by) {
        WebElement element = getElement(by);
        element.click();
    }

    public static void elementClear(By by) {
        WebElement element = getElement(by);
        element.clear();
    }

    public static void elementSendKeys(By by, String text) {
        WebElement element = getElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void elementSendKeys(By by, String text, Keys key) {
        WebElement element = getElement(by);
        element.click();
        element.clear();
        element.sendKeys(text, key);
    }

    public static void validatePage(By by, String down, String up) {
        WebElement element = getElement(by);
        scrollPage(down, up);
        Assert.assertTrue(element.isDisplayed(), "Elemento ausente");
        appendToReportElementHighlight(element);
    }

    public static boolean isElementPresent(By by) {
        boolean isPresent = false;
        try {
            getDriver().findElement(by);
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }

    public static void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Float castToFloat(String value) {
        return Float.parseFloat(value);
    }

}
