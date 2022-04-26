package hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractStep {

    @Then("Browser title equals {string}")
    public void checkTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(),expectedTitle);
    }

    @Then("Name is displayed and equals {string}")
    public void checkUserLogged(String expectedName) {
        assertTrue(homePage.checkLogginedUser(expectedName));
    }

    /*@Step("Assert that there are 4 items on the header section are displayed and " +
            "they have proper names: {expectedItemsNames}")
    public void checkHeaderMenu(List<String> expectedItemsNames) {
        assertTrue(homePage.getHeaderMenu().checkHeaderMenuItems());
        assertEquals(homePage.getHeaderMenu().getHeaderMenuItemsTexts(), expectedItemsNames);
    }

    @Step("Assert that 4 images are displayed")
    public void checkImages() {
        assertTrue(homePage.checkImages());
    }

    @Step("Assert that there are 4 texts below of each image")
    public void checkTextsUnderImages(List<String> expectedTexts) {
        assertTrue(homePage.checkTextsUnderImages());
        assertEquals(homePage.getTextsUnderImages(), expectedTexts);
    }

    @Step("Assert that the iframe exists")
    public void checkIframeExists() {
        assertTrue(homePage.isThereIframe());
    }

    @Step("Assert that the “Frame Button” exists")
    public void checkFrameButton() {
        assertTrue(iframePage.getFrameButton().isDisplayed());
    }

    @Step("Assert that left section menu items are displayed and have proper texts")
    public void checkLeftMenu(List<String> expectedLeftItemsNames) {
        assertTrue(homePage.checkLeftMenuItems());
        assertEquals(homePage.getLeftMenuItemsTexts(), expectedLeftItemsNames);
    }

    @Step("Assert that Different Elements page is open")
    public void checkDifferentElementsPageIsOpen() {
        assertTrue(differentElementsPage.checkDifferentElementsUrl());
    }

    @Step("Assert that checkbox '{checkboxName}' is selected")
    public void isCheckboxSelected(String checkboxName) {
        assertTrue(differentElementsPage.getSelectableElement(checkboxName, differentElementsPage.getCheckboxRowNames(),
                differentElementsPage.getCheckboxes()).isSelected());
    }

    @Step("Assert that radio button '{radioName}' is selected")
    public void isRadioSelected(String radioName) {
        assertTrue(differentElementsPage.getSelectableElement(radioName, differentElementsPage.getRadioRowNames(),
                differentElementsPage.getRadiobuttons()).isSelected());
    }

    @Step("Assert that selected color is '{color}'")
    public void checkColor(String color) {
        assertTrue(differentElementsPage.getSelectedColor().contains(color));
    }

    @Step("Assert that log texts are visible")
    public void checkLogTextsVisibility() {
        assertTrue(differentElementsPage.checkLogsVisibity());
    }*/

    @Then("I see logs in right section on Different Elements page")
    public void checkLogsInRightSection(List<String> expectedTexts) {
        assertTrue(differentElementsPage.checkLogsVisibity());
        List<String> logsTexts = differentElementsPage.getLogsTexts();
        for (int i = 0; i < 4; ++i) {
            assertTrue(logsTexts.get(i).contains(expectedTexts.get(i)));
        }
    }

    @Then("{string} page should be opened")
    public void checkUserTablePageTitle(String expectedTitle) {
        assertEquals(userTablePage.getTitle(),expectedTitle);
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberOfDropdowns()
    {
        assertEquals(userTablePage.getDropdowns().size(),6);
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkNumberOfUsernames()
    {
        assertEquals(userTablePage.getUsernames().size(),6);
    }
}
