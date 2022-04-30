package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hw5.pageObject.PageObjectUtility.getTextsOfElementsList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractStep {

    @Then("Browser title equals {string}")
    public void checkTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Then("Name is displayed and equals {string}")
    public void checkUserLogged(String expectedName) {
        assertTrue(homePage.checkLogginedUser(expectedName));
    }

    @Then("I see logs in right section on Different Elements page")
    public void checkLogsInRightSection(List<String> expectedTexts) {
        assertTrue(differentElementsPage.checkLogsVisibity());
        List<String> logsTexts = differentElementsPage.getLogsTexts();
        for (int i = 0; i < 4; ++i) {
            assertTrue(logsTexts.get(i).contains(expectedTexts.get(i)));
        }
    }

    @Then("{string} page should be opened")
    public void checkUserTablePageTitle(String expectedTitle) {
        assertEquals(userTablePage.getTitle(), expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberOfDropdowns(Integer numberOfDropdowns) {
        assertEquals(userTablePage.getDropdowns().size(), numberOfDropdowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkNumberOfUsernames(Integer numberOfUsernames) {
        assertEquals(userTablePage.getUsernames().size(), numberOfUsernames);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkNumberOfUserDescriptions(Integer numberOfDescriptions) {
        assertEquals(userTablePage.getUserDescriptions().size(), numberOfDescriptions);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkNumberOfCheckboxes(Integer numberOfCheckboxes) {
        assertEquals(userTablePage.getCheckboxes().size(), numberOfCheckboxes);
    }

    @Then("User table should contain following values:")
    public void checkUserTableValues(DataTable values) {
        List<String> numbers = getTextsOfElementsList(userTablePage.getNumbers());
        List<String> usernames = getTextsOfElementsList(userTablePage.getUsernames());
        List<String> userDescriptions = getTextsOfElementsList(userTablePage.getUserDescriptions());

        List<List<String>> valuesLists = values.asLists(String.class);
        for (int i = 0; i < numbers.size(); ++i) {
            assertEquals(numbers.get(i), valuesLists.get(i + 1).get(0));
            assertEquals(usernames.get(i), valuesLists.get(i + 1).get(1));
            assertEquals(userDescriptions.get(i), valuesLists.get(i + 1).get(2));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDroplist(List<String> expextedOptions) {
        Select romanDroplist = new Select(userTablePage.getDropdowns().get(0));
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : romanDroplist.getOptions()) {
            actualOptions.add(option.getText());
        }
        assertEquals(actualOptions, expextedOptions.subList(1, expextedOptions.size()));
    }

    @Then("{int} log row has {string} text in log section")
    public void checkUserTableLogs(Integer numberOfLogRows, String expectedText) {
        assertEquals(userTablePage.getLogRows().size(), numberOfLogRows);
        assertTrue(userTablePage.getLogRows().get(0).getText().contains(expectedText));
    }
}
