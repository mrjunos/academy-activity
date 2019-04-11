package pages;

import drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StandingPage extends Driver {

    private Objects standingPageObjects;
    private String expectedURL;

    private class Objects {
        @FindBy(className = "dropdown__select")
        public List<WebElement> resources;
    }


    public StandingPage() {
        super();
        standingPageObjects = new Objects();
        PageFactory.initElements(super.driver, standingPageObjects);
    }

    public String clickPlayOff() {
        Select dropdown = findSelect("Playoff Machine");

        if (dropdown != null) {
            dropdown.selectByVisibleText("Playoff Machine");
            return expectedURL;
        }

        return null;
    }

    public Select findSelect(String elementText) {
        for (WebElement item : standingPageObjects.resources) {
            Select element = new Select(item);

            for(WebElement option : element.getOptions()) {
                if (option.getText().equals(elementText)) {
                    this.expectedURL = option.getAttribute("data-url");
                    return element;
                }
            }
        }

        return null;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void Finish() { super.finish();}
}
