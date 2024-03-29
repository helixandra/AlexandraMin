package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class SeleniumBaseTest {
    protected String driverPath;
    protected WebDriver driver;
    protected String testingUrl;
    protected SoftAssert softAssert;

    //change encoding 'cause of Russian letters in the path to driver
    private static String changeEncoding(String parameter) throws UnsupportedEncodingException {
        return new String(URLDecoder.decode(parameter, "UTF-8").getBytes("UTF-8"), "UTF-8");
    }

    @BeforeClass
    public void setup() throws UnsupportedEncodingException {
        driverPath = changeEncoding(getClass().getClassLoader().getResource("chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", driverPath);
        testingUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void setupDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
