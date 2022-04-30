package hw5.steps.hooks;

import hw5.context.TestContext;
import hw5.user.UserData;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CucumberHook {

    @BeforeAll
    public static void downloadAndSetupWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        TestContext.getInstance().putTestObject("driver", driver);

        Properties properties = new Properties();
        String propertiesPath = "src/test/resources/config.properties";
        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            properties.load(fis);
            TestContext.getInstance().putTestObject("properties", properties);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    public static void quitDriver() {
        WebDriver driver = TestContext.getInstance().getTestObject("driver");
        if (driver != null)
            driver.quit();
        TestContext.getInstance().clean();
    }
}
