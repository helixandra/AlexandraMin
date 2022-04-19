package hw2.ex1;

import hw2.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumTestsEx1 extends SeleniumBaseTest {

    @Test
    public void ex1Test() {
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

        //5.	Assert that there are 4 items on the header
        List<String> expectedItemsNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> headerItems = driver.findElements(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8'] > li > a"));
        List<String> itemsNames = new ArrayList<>();
        for (WebElement item : headerItems) {
            softAssert.assertTrue(item.isDisplayed());
            itemsNames.add(item.getText());
        }
        softAssert.assertEquals(itemsNames, expectedItemsNames);

        //6.	Assert that there are 4 images
        List<WebElement> icons = driver.findElements(By.cssSelector("div.benefit-icon"));
        for (WebElement icon : icons) {
            softAssert.assertTrue(icon.isDisplayed());
        }

        //7.	Assert that there are 4 texts below of each image
        List<String> expectedTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<String> texts = new ArrayList<>();
        List<WebElement> textElements = driver.findElements(By.cssSelector("span[class='benefit-txt']"));
        for (WebElement element : textElements) {
            softAssert.assertTrue(element.isDisplayed());
            texts.add(element.getText());
        }
        softAssert.assertEquals(texts, expectedTexts);

        //8.	Assert that the iframe exists
        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());

        //9.	Assert that the “Frame Button” exists
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        softAssert.assertTrue(driver.findElement(By.id("frame-button")).isDisplayed());

        //10.   Assert that driver has focus on the original window
        driver.switchTo().window(originalWindow);
        softAssert.assertEquals(driver.getWindowHandle(), originalWindow);

        //11.   Assert that left section menu items are displayed and have proper text
        List<String> expectedLeftItemsNames = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<WebElement> leftMenuItems = driver.findElements(By.cssSelector("ul[class='sidebar-menu left'] > li > a > span"));
        List<String> leftMenuItemsNames = new ArrayList<>();
        for (WebElement item : leftMenuItems) {
            softAssert.assertTrue(item.isDisplayed());
            leftMenuItemsNames.add(item.getText());
        }
        softAssert.assertEquals(leftMenuItemsNames, expectedLeftItemsNames);

        softAssert.assertAll();
    }
}
