package hw3.pageObject.pages;

import hw3.pageObject.elements.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.List;

import static hw3.pageObject.PageObjectUtility.getTextsOfElementsList;
import static hw3.pageObject.PageObjectUtility.isElementsDisplayed;

public class HomePage {

    private WebDriver driver;
    private String homePageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    private String homePageTitle = "Home Page";

    private HeaderMenu headerMenu;

    @FindBy(css = "a[href='#']")
    private WebElement loginForm;

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginSubmitButton;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    @FindBy(id = "user-name")
    private WebElement logginedUser;

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] > li > a")
    private List<WebElement> headerMenuItems;

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> images;

    @FindBy(css = "span[class='benefit-txt']")
    private List<WebElement> textsUnderImages;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(css = "ul[class='sidebar-menu left'] > li > a > span")
    private List<WebElement> leftMenuItems;

    public HomePage(WebDriver driver) throws UnsupportedEncodingException {
        this.driver = driver;
        driver.get(homePageUrl);
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public String getUrl() {
        return homePageUrl;
    }

    public void login(String userLogin, String userPassword) {
        loginForm.click();
        login.sendKeys(userLogin);
        password.sendKeys(userPassword);
        loginSubmitButton.click();
    }

    public boolean hasProperTitle() {
        return driver.getTitle().contains(homePageTitle);
    }

    public boolean isUserLoggined() {
        return logoutButton.isDisplayed();
    }

    public boolean checkLogginedUser(String userFullName) {
        return logginedUser.isDisplayed() && logginedUser.getText().contains(userFullName);
    }

    public boolean checkLeftMenuItems() {
        return isElementsDisplayed(leftMenuItems);
    }

    public boolean checkImages() {
        return isElementsDisplayed(images);
    }

    public boolean checkTextsUnderImages() {
        return isElementsDisplayed(textsUnderImages);
    }

    public List<String> getLeftMenuItemsTexts() {
        return getTextsOfElementsList(leftMenuItems);
    }

    public List<String> getTextsUnderImages() {
        return getTextsOfElementsList(textsUnderImages);
    }

    public boolean isThereIframe() {
        return iframe.isDisplayed();
    }

    public IframePage goToIframe() {
        driver.switchTo().frame("frame");
        return new IframePage(driver);
    }
}
