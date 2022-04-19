package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home Page")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Perform login: {login}, {password}")
    public void login(String login, String password) {
        homePage.login(login, password);
    }

    @Step("Go to Iframe page")
    public void goToIframePage() {
        homePage.goToIframe();
    }

    @Step("Go to Home page")
    public void goToHomePage() {
        iframePage.goToHomePage();
    }

    @Step("Go to Different elements page")
    public void goToDifferentElementsPage() {
        homePage.getHeaderMenu().goToDifferentElementsPage();
    }

    @Step("Select checkbox '{checkboxName}'")
    public void selectCheckbox(String checkboxName) {
        differentElementsPage.getRowItemForClick(checkboxName,
                differentElementsPage.getCheckboxRowNames()).click();
    }

    @Step("Select radio button '{radioName}'")
    public void selectRadioButton(String radioName) {
        differentElementsPage.getRowItemForClick(radioName,
                differentElementsPage.getRadioRowNames()).click();
    }

    @Step("Select color '{color}'")
    public void selectColor(String color) {
        differentElementsPage.selectColor(color);
    }
}

