package hw5.steps;

import hw5.context.TestContext;
import hw5.pageObject.pages.DifferentElementsPage;
import hw5.pageObject.pages.HomePage;
import hw5.pageObject.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public class AbstractStep {
    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected AbstractStep() {
        this.driver = TestContext.getInstance().getTestObject("driver");
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
