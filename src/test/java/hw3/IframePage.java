package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    private WebDriver driver;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IframePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean frameButtonExists() {
        return frameButton.isDisplayed();
    }

    public void goToHomePage() {
        driver.switchTo().defaultContent();
    }
}
