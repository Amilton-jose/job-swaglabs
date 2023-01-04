package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;

public class Utils {

    public static void scrollPage(String pixels) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.scrollBy(0," + pixels + ")");
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

    public static void validatePage(By by, String pixels) {
        WebElement element = getElement(by);
        scrollPage(pixels);
        Assert.assertTrue(element.isDisplayed(), "Elemento ausente");
        appendToReportElementHighlight(element);
    }

    public static boolean isElementPresent(By by) {
        boolean isPresent = false;
        try {
            getDriver().findElement(by);
            isPresent = true;
        }catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }

}
