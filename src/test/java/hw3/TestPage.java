package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestPage {

    private WebDriver driver;
    private String testPageUrl;
    private String testPageTitle;
    private String userLogin;
    private String userPassword;
    private String userFullName;

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

    //change encoding 'cause of Russian letters in the path to driver
    private static String changeEncoding(String parameter) throws UnsupportedEncodingException {
        return new String(URLDecoder.decode(parameter, "UTF-8").getBytes("UTF-8"), "UTF-8");
    }

    public void loadTestInfo() throws UnsupportedEncodingException {
        Properties properties = new Properties();
        String propertiesPath = changeEncoding(getClass().getClassLoader().getResource("config.properties").getPath());

        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            properties.load(fis);
            userLogin = properties.getProperty("userInfo.login");
            userPassword = properties.getProperty("userInfo.password");
            userFullName = properties.getProperty("userInfo.fullName");
            testPageUrl = properties.getProperty("testPage.url");
            testPageTitle = properties.getProperty("testPage.title");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public TestPage(WebDriver driver) throws UnsupportedEncodingException {
        loadTestInfo();
        this.driver = driver;
        driver.get(testPageUrl);
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public String getUrl() {
        return testPageUrl;
    }

    public void login() {
        loginForm.click();
        login.sendKeys(userLogin);
        password.sendKeys(userPassword);
        loginSubmitButton.click();
    }

    public boolean hasProperTitle() {
        return driver.getTitle().contains(testPageTitle);
    }

    public boolean isUserLoggined() {
        return logoutButton.isDisplayed();
    }

    public boolean checkLogginedUser() {
        return logginedUser.isDisplayed() && logginedUser.getText().contains(userFullName);
    }

    public static boolean isElementsDisplayed(List<WebElement> elements) {
        for (WebElement elem : elements) {
            if (!elem.isDisplayed()) return false;
        }
        return true;
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

    public static List<String> getTextsOfElementsList(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement elem : elements) {
            texts.add(elem.getText());
        }
        return texts;
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
