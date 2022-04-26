package hw4.pageObject.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static hw4.pageObject.PageObjectUtility.getTextsOfElementsList;
import static hw4.pageObject.PageObjectUtility.isElementsDisplayed;

public class DifferentElementsPage {

    private WebDriver driver;

    @Getter
    @FindBy(css = "label[class='label-checkbox']")
    private List<WebElement> checkboxRowNames;

    @Getter
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @Getter
    @FindBy(css = "label[class='label-radio']")
    private List<WebElement> radioRowNames;

    @Getter
    @FindBy(css = "input[type='radio']")
    private List<WebElement> radiobuttons;

    @Getter
    @FindBy(css = "select[class='uui-form-element']")
    private WebElement colorList;

    @Getter
    @FindBy(css = "ul[class='panel-body-list logs'] li")
    private List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkDifferentElementsUrl() {
        return driver.getCurrentUrl().contains("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    public WebElement getRowItemForClick(final String itemName, List<WebElement> itemsRow) {
        for (int i = 0; i < itemsRow.size(); ++i) {
            if (itemName.equals(itemsRow.get(i).getText())) {
                return itemsRow.get(i);
            }
        }
        return null;
    }

    public WebElement getSelectableElement(final String itemName, List<WebElement> itemsRow, List<WebElement> itemsNames) {
        for (int i = 0; i < itemsRow.size(); ++i) {
            if (itemName.equals(itemsRow.get(i).getText())) {
                return itemsNames.get(i);
            }
        }
        return null;
    }

    public void selectColor(String color) {
        Select select = new Select(colorList);
        select.selectByVisibleText(color);
    }

    public String getSelectedColor() {
        Select select = new Select(colorList);
        return select.getFirstSelectedOption().getText();
    }

    public boolean checkLogsVisibity() {
        return isElementsDisplayed(logRows);
    }

    public List<String> getLogsTexts() {
        return getTextsOfElementsList(logRows);
    }
}
