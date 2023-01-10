package report;

import com.cucumber.listener.Reporter;
import driver.Drivers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import static driver.Drivers.testScenario;

public class Report {

    public static String takeScreenshot() {
        return ((TakesScreenshot) Drivers.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static void appendToReport(String description) {
        testScenario.get().log("" +
            "<h6 align=\"left\" width=\"40\">" +
                "<ul class='screenshots left'  width=\"40\">" +
                    "<li>" +
                        "<img data-featherlight=\"image\" href=\"data:image/png;base64, " + takeScreenshot() + "\"  " +
                            "src=\"data:image/png;base64, " + takeScreenshot() + "\" alt=\"Red dot\" width=\"7%\" />" +
                        "</img>" +
                        "<span></br>"+description+"</span>"+
                    "</li>" +
                "</ul>" +
            "</h6>");
    }

    public static void appendToReport() {
        testScenario.get().log("" +
            "<h6 align=\"left\">" +
                "<ul class='screenshots left'>" +
                    "<li>" +
                        "<img data-featherlight=\"image\" href=\"data:image/png;base64, " + takeScreenshot() + "\"  " +
                        "src=\"data:image/png;base64, " + takeScreenshot() + "\" alt=\"Red dot\" width=\"7%\" />" +
                        "</img>" +
                    "</li>" +
                "</ul>" +
            "</h6>");
    }

    public static void appendToReportElementHighlight(WebElement element) {
        ((JavascriptExecutor)Drivers.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
        appendToReport();
        ((JavascriptExecutor)Drivers.getDriver()).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
    }

}
