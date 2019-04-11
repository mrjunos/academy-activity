package drivers;

import org.openqa.selenium.WebDriver;

public class Driver extends DriverSetup {

    protected WebDriver driver;
    private String browser = "chrome";

    public Driver() {
        this.driver = super.getDriver(browser);
    }


    public String getURL(){
       return this.driver.getCurrentUrl();
    }

    public void finish() { this.driver.quit(); }
}
