package hw5.steps;

import hw5.context.TestContext;
import hw5.user.UserData;
import io.cucumber.java.en.Given;

import java.util.Properties;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.open();
    }

    @Given("I login as user {string}")
    public void login(String userName) {
        //UserData user = TestContext.getInstance().getTestObject("user");
        Properties properties = TestContext.getInstance().getTestObject("properties");
        homePage.login(properties.getProperty(userName.replaceAll("\\s", "") + ".login"),
                properties.getProperty(userName.replaceAll("\\s", "") + ".password"));
    }
}
