package hw5.pageObject.pages;

import hw3.pageObject.PageObjectUtility;
import hw3.pageObject.pages.IframePage;
import hw5.pageObject.elements.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private String homePageUrl = "https://jdi-testing.github.io/jdi-light/index.html";

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

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> images;

    @FindBy(css = "span[class='benefit-txt']")
    private List<WebElement> textsUnderImages;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(css = "ul[class='sidebar-menu left'] > li > a > span")
    private List<WebElement> leftMenuItems;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public void open() {
        driver.get(homePageUrl);
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

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isUserLoggined() {
        return logoutButton.isDisplayed();
    }

    public boolean checkLogginedUser(String userFullName) {
        return logginedUser.isDisplayed() && logginedUser.getText().contains(userFullName);
    }

    public boolean checkLeftMenuItems() {
        return PageObjectUtility.isElementsDisplayed(leftMenuItems);
    }

    public boolean checkImages() {
        return PageObjectUtility.isElementsDisplayed(images);
    }

    public boolean checkTextsUnderImages() {
        return PageObjectUtility.isElementsDisplayed(textsUnderImages);
    }

    public List<String> getLeftMenuItemsTexts() {
        return PageObjectUtility.getTextsOfElementsList(leftMenuItems);
    }

    public List<String> getTextsUnderImages() {
        return PageObjectUtility.getTextsOfElementsList(textsUnderImages);
    }

    public boolean isThereIframe() {
        return iframe.isDisplayed();
    }

    public IframePage goToIframe() {
        driver.switchTo().frame("frame");
        return new IframePage(driver);
    }
}
