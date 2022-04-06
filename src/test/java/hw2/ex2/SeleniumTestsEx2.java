package hw2.ex2;

import hw2.SeleniumBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class SeleniumTestsEx2 extends SeleniumBaseClass {

    @Test
    public void ex2Test() {
        //1.    Open test site by URL
        driver.get(testingUrl);
        softAssert.assertEquals(driver.getCurrentUrl(), testingUrl);

        //2.	Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3.	Perform login, assert user is logged
        WebElement dropdownToggle = driver.findElement(By.cssSelector("li[class = 'dropdown uui-profile-menu'] a[class='dropdown-toggle']"));
        dropdownToggle.click();

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        nameInput.sendKeys("Roman");
        passwordInput.sendKeys("Jdi1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> checkLogoutButton = driver.findElements(By.className("logout"));
        softAssert.assertNotEquals(checkLogoutButton.size(), 0);

        //4.	Assert username
        WebElement loggedInUser = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(loggedInUser.isDisplayed());
        softAssert.assertEquals(loggedInUser.getText(), "ROMAN IOVLEV");

        //5.    Open Different elements page
        WebElement serviceItem = driver.findElement(By.cssSelector("li[class = 'dropdown'] a[class='dropdown-toggle']"));
        serviceItem.click();
        WebElement differentElemItem = driver.findElement(By.cssSelector("a[href='different-elements.html']"));
        differentElemItem.click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6.	Select checkboxes	Water, Wind
        List<WebElement> elementsCheckboxRow = driver.findElements(By.cssSelector("input[type='checkbox']"));
        elementsCheckboxRow.get(0).click();
        assertTrue(elementsCheckboxRow.get(0).isSelected());
        elementsCheckboxRow.get(2).click();
        assertTrue(elementsCheckboxRow.get(2).isSelected());

        //7.	Select radio	Selen
        List<WebElement> metalsRadiobuttonRow = driver.findElements(By.cssSelector("input[type='radio']"));
        metalsRadiobuttonRow.get(3).click();
        assertTrue(metalsRadiobuttonRow.get(3).isSelected());

        //8.    Select color
        WebElement colorSelect = driver.findElement(By.cssSelector("select[class='uui-form-element']"));
        Select select = new Select(colorSelect);
        select.selectByVisibleText("Yellow");
        assertEquals(select.getFirstSelectedOption().getText(), "Yellow");

        //9.    Check log pannel
        List<WebElement> logsPannel = driver.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"));
        assertTrue(logsPannel.get(0).isDisplayed() && logsPannel.get(0).getText().contains("Colors: value changed to Yellow"));
        assertTrue(logsPannel.get(1).isDisplayed() && logsPannel.get(1).getText().contains("metal: value changed to Selen"));
        assertTrue(logsPannel.get(2).isDisplayed() && logsPannel.get(2).getText().contains("Wind: condition changed to true"));
        assertTrue(logsPannel.get(3).isDisplayed() && logsPannel.get(3).getText().contains("Water: condition changed to true"));

        driver.close();
    }
}
