package hw4;

import hw4.user.UserData;
import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    protected WebDriver driver;
    protected UserData user;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void downloadWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDriver() throws UnsupportedEncodingException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        user = new UserData();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
