package hw4;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot(ITestResult tr) {
        byte[] array = {1};
        Object currentClass = tr.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot(tr);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot(tr);
    }
}
