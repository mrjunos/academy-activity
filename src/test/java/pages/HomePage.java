package pages;

import drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Driver {

    private Objects homePageObjects;

    private class Objects {
        @FindBy(xpath = "//*[@id=\"global-nav\"]/ul/li[1]/a")
        public WebElement nfl;

        @FindBy(xpath = "//*[@id=\"global-nav\"]/ul/li[1]/div/ul[1]/li[6]/a")
        public WebElement standings;
    }


    public HomePage() {
        super();
        homePageObjects = new Objects();
        PageFactory.initElements(super.driver, homePageObjects);
    }

    public void hoverNFLMenu() {
         Actions action = new Actions(this.driver);
         action.moveToElement(homePageObjects.nfl).build().perform();
    }

    public void clickStandings() {
        Actions action = new Actions(this.driver);
        action.moveToElement(homePageObjects.standings).click().build().perform();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }


}

