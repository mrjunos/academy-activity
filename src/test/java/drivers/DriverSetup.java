package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
    private static WebDriver driver;
    private static String url = "http://www.espn.com/?src=com";

    public WebDriver getDriver(String browser) {
        if (driver == null) {
            init(browser);
        }

        return driver;
    }

    private void init(String browser) {
        if (browser == "chrome") {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        if (browser == "firefox") {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        if (browser == "edge") {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        if (browser == "ie") {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.get(url);
    }
}
