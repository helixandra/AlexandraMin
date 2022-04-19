package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title")
    public void checkTitle() {
        assertTrue(homePage.hasProperTitle());
    }

    @Step("Assert user is loggined")
    public void checkUserLogged() {
        assertTrue(homePage.isUserLoggined());
    }

    @Step("Assert username is '{username}'")
    public void checkUserName(String username) {
        assertTrue(homePage.checkLogginedUser(username));
    }

    @Step("Assert that there are 4 items on the header section are displayed and " +
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

    @Step("Assert that checkbox '{itemName}' is selected")
    public void isCheckboxSelected(String checkboxName) {
        assertTrue(differentElementsPage.getSelectableElement(checkboxName, differentElementsPage.getCheckboxRowNames(),
                differentElementsPage.getCheckboxes()).isSelected());
    }

    @Step("Assert that radio button '{itemName}' is selected")
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
    }

    @Step("Assert that logs have proper texts")
    public void checkLogsTexts(List<String> containedTexts) {
        List<String> logsTexts = differentElementsPage.getLogsTexts();
        for (int i = 0; i < 4; ++i) {
            assertTrue(logsTexts.get(i).contains(containedTexts.get(i)));
        }
    }
}
