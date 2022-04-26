package hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/UserTableInteract.feature"},
        glue = {"hw5.steps"},
        tags = "@smoke"
)

public class ActionsOnUserTablePageTest extends AbstractTestNGCucumberTests {
}
