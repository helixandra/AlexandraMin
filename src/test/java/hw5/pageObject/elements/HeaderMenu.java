package hw5.pageObject.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static hw4.pageObject.PageObjectUtility.getTextsOfElementsList;
import static hw4.pageObject.PageObjectUtility.isElementsDisplayed;

public class HeaderMenu {
    private WebDriver driver;

    @FindBy(css = "ul[class^='uui-navigation nav '] > li > a")
    private List<WebElement> headerMenuItems;

    @FindBy(css = "li[class='dropdown open'] > ul > li")
    private List<WebElement> serviceDropdown;

    /*@FindBy(css = "a[href='different-elements.html']")
    private WebElement differentElements;*/

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

    public WebElement getHeaderMenuItem(final String headerMenuItemName) {
        for (WebElement item : headerMenuItems) {
            if (headerMenuItemName.equalsIgnoreCase(item.getText())) {
                return item;
            }
        }
        return null;
    }

    public WebElement getServiceDropdownItem(final String serviceDropdownItemName) {
        for (WebElement item : serviceDropdown) {
            String text = item.getText();
            if (serviceDropdownItemName.equalsIgnoreCase(item.getText())) {
                return item;
            }
        }
        return null;
    }

    /*public void goToDifferentElementsPage() {
        clickHeaderMenuItem("SERVICE");
        differentElements.click();
    }*/
}
