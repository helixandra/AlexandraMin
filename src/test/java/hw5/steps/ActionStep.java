package hw5.steps;

import io.cucumber.java.en.When;

import java.util.List;

public class ActionStep extends AbstractStep {

    @When("I click on {string} button in Header menu")
    public void clickOnHeaderMenuItem(String headerMenuItemName) {
        homePage.getHeaderMenu().getHeaderMenuItem(headerMenuItemName).click();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnServiceDropdownItem(String serviceDropdownItemName) {
        homePage.getHeaderMenu().getServiceDropdownItem(serviceDropdownItemName).click();
    }

    @When("I select checkboxes in main form on Different Elements page")
    public void selectCheckboxes(List<String> checkboxNames) {
        for (String name : checkboxNames) {
            differentElementsPage.getRowItemForClick(name,
                    differentElementsPage.getCheckboxRowNames()).click();
        }
    }

    @When("I select radio button in main form on Different Elements page")
    public void selectRadioButtons(String radioName) {
        differentElementsPage.getRowItemForClick(radioName,
                differentElementsPage.getRadioRowNames()).click();

    }

    @When("I select color from dropdown menu in main form on Different Elements page")
    public void selectColor(String color) {
        differentElementsPage.selectColor(color);
    }
}

