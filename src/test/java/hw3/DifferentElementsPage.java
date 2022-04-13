package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static hw3.TestPage.getTextsOfElementsList;
import static hw3.TestPage.isElementsDisplayed;

public class DifferentElementsPage {

    private WebDriver driver;

    @FindBy(css="label[class='label-checkbox']")
    private List<WebElement> checkboxRowNames;

    @FindBy(css="input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css="label[class='label-radio']")
    private List<WebElement> radioRowNames;

    @FindBy(css="input[type='radio']")
    private List<WebElement> radiobuttons;

    @FindBy(css="select[class='uui-form-element']")
    private WebElement colorSelect;

    @FindBy(css ="ul[class='panel-body-list logs'] li")
    private List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkDifferentElementsUrl(){
        return driver.getCurrentUrl().contains("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    public boolean clickRowItem(final String itemName, List<WebElement> row, List<WebElement> itemsToSelect){
        for (int i = 0; i<row.size();++i){
            if (itemName.equals(row.get(i).getText())) {
                row.get(i).click();
                return itemsToSelect.get(i).isSelected();
            }
        }
        return false;
    }

    public boolean clickCheckboxRowItem(final String itemName){
        return clickRowItem(itemName, checkboxRowNames, checkboxes);
    }

    public boolean clickRadiobuttonRowItem(final String itemName){
        return clickRowItem(itemName, radioRowNames, radiobuttons);
    }

    public boolean selectColor(final String color){
        Select select = new Select(colorSelect);
        select.selectByVisibleText(color);
        return select.getFirstSelectedOption().getText().contains(color);
    }

    public boolean checkLogsVisibity() {
        return isElementsDisplayed(logRows);
    }

    public List<String> getLogsTexts() {
        return getTextsOfElementsList(logRows);
    }
}
