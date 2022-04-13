package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static hw3.TestPage.getTextsOfElementsList;
import static hw3.TestPage.isElementsDisplayed;

public class HeaderMenu {
    private WebDriver driver;

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] > li > a")
    private List<WebElement> headerMenuItems;

    @FindBy(css = "a[href='different-elements.html']")
    private WebElement differentElements;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkHeaderMenuItems() {
        return isElementsDisplayed(headerMenuItems);
    }

    public List<String> getHeaderMenuItemsTexts() {
        return getTextsOfElementsList(headerMenuItems);
    }

    public void clickHeaderMenuItem(final String menuItem) {
        for (WebElement item : headerMenuItems) {
            if (menuItem.equals(item.getText())) {
                item.click();
                break;
            }
        }
    }

    public DifferentElementsPage goToDifferentElementsPage() {
        clickHeaderMenuItem("SERVICE");
        differentElements.click();
        return new DifferentElementsPage(driver);
    }
}
