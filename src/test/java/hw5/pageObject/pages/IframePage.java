package hw5.pageObject.pages;

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

    public WebElement getFrameButton() {
        return frameButton;
    }

    public void goToHomePage() {
        driver.switchTo().defaultContent();
    }
}
