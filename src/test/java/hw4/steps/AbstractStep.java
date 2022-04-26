package hw4.steps;

import hw4.pageObject.pages.DifferentElementsPage;
import hw4.pageObject.pages.HomePage;
import hw4.pageObject.pages.IframePage;
import org.openqa.selenium.WebDriver;

public class AbstractStep {
    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected IframePage iframePage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        iframePage = new IframePage(driver);
    }
}
