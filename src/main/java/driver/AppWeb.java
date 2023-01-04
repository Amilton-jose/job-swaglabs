package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static driver.Drivers.setConfigurationDownload;
import static driver.Drivers.setDriver;

public class AppWeb {

    WebDriver driver;
    public void setUpDriver() {
        setConfigurationDownload();
        initChrome();
    }

    public void initChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        setDriver(driver);
    }

}
