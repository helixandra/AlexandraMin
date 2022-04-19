package hw2.ex2;

import hw2.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SeleniumTestsEx2 extends SeleniumBaseTest {

    @Test
    public void ex2Test() {
        //1.    Open test site by URL
        driver.get(testingUrl);
        softAssert.assertEquals(driver.getCurrentUrl(), testingUrl);

        //2.	Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3.	Perform login, assert user is logged
        driver.findElement(By.cssSelector("a[href='#']")).click();

        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        softAssert.assertTrue(driver.findElement(By.className("logout")).isDisplayed());

        //4.	Assert username
        WebElement loggedInUser = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(loggedInUser.isDisplayed());
        softAssert.assertEquals(loggedInUser.getText(), "ROMAN IOVLEV");

        //5.    Open Different elements page
        driver.findElement(By.cssSelector("li[class = 'dropdown'] a[class='dropdown-toggle']")).click();
        driver.findElement(By.cssSelector("a[href='different-elements.html']")).click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6.	Select checkboxes	Water, Wind
        List<WebElement> elementsCheckboxRow = driver.findElements(By.cssSelector("input[type='checkbox']"));
        elementsCheckboxRow.get(0).click();
        softAssert.assertTrue(elementsCheckboxRow.get(0).isSelected());
        elementsCheckboxRow.get(2).click();
        softAssert.assertTrue(elementsCheckboxRow.get(2).isSelected());

        //7.	Select radio	Selen
        List<WebElement> metalsRadiobuttonRow = driver.findElements(By.cssSelector("input[type='radio']"));
        metalsRadiobuttonRow.get(3).click();
        softAssert.assertTrue(metalsRadiobuttonRow.get(3).isSelected());

        //8.    Select color
        WebElement colorSelect = driver.findElement(By.cssSelector("select[class='uui-form-element']"));
        Select select = new Select(colorSelect);
        select.selectByVisibleText("Yellow");
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Yellow");

        //9.    Check log pannel
        List<WebElement> logRows = driver.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"));
        List<String> containedTexts = Arrays.asList("Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true");
        for (int i = 0; i < 4; ++i) {
            softAssert.assertTrue(logRows.get(i).isDisplayed() &&
                    logRows.get(i).getText().contains(containedTexts.get(i)));
        }

        softAssert.assertAll();
    }
}
