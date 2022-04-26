package hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/DifferentElementsPage.feature"},
        glue = {"hw5.steps"},
        tags = "@smoke"
)

public class DifferentElementsPageTest extends AbstractTestNGCucumberTests {
}
