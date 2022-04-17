package hw3;

import hw3.user.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected String driverPath;
    protected WebDriver driver;
    protected String testingUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected UserData user;

    //change encoding 'cause of Russian letters in the path to driver
    private static String changeEncoding(String parameter) throws UnsupportedEncodingException {
        return new String(URLDecoder.decode(parameter, "UTF-8").getBytes("UTF-8"), "UTF-8");
    }

    @BeforeSuite
    public void setup() throws UnsupportedEncodingException {
        driverPath = changeEncoding(getClass().getClassLoader().getResource("chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeMethod
    public void setupDriver() throws UnsupportedEncodingException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        user = new UserData();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
