package hw5.pageObject.pages;

import hw5.pageObject.elements.HeaderMenu;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage {

    private WebDriver driver;

    @Getter
    @FindBy(tagName = "select")
    private List<WebElement> dropdowns;

    @Getter
    @FindBy(css = "table[id='user-table'] a")
    private List<WebElement> usernames;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
