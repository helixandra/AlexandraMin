package hw2.ex1;

import hw2.SeleniumBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTestsEx1 extends SeleniumBaseClass {

    @Test
    public void ex1Test() throws UnsupportedEncodingException {
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

        //5.	Assert that there are 4 items on the header
        WebElement homeItem = driver.findElement(By.cssSelector("li a[href='index.html']"));
        softAssert.assertTrue(homeItem.isDisplayed());
        softAssert.assertEquals(homeItem.getText(), "HOME");

        WebElement contactFormItem = driver.findElement(By.cssSelector("li a[href='contacts.html']"));
        softAssert.assertTrue(contactFormItem.isDisplayed());
        softAssert.assertEquals(contactFormItem.getText(), "CONTACT FORM");

        WebElement serviceItem = driver.findElement(By.cssSelector("li[class = 'dropdown'] a[class='dropdown-toggle']"));
        softAssert.assertTrue(serviceItem.isDisplayed());
        softAssert.assertEquals(serviceItem.getText(), "SERVICE");

        WebElement metalsColorsItem = driver.findElement(By.cssSelector("li a[href='metals-colors.html']"));
        softAssert.assertTrue(metalsColorsItem.isDisplayed());
        softAssert.assertEquals(metalsColorsItem.getText(), "METALS & COLORS");

        //6.	Assert that there are 4 images
        WebElement practiseImage = driver.findElement(By.cssSelector("span[class='icons-benefit icon-practise']"));
        softAssert.assertTrue(practiseImage.isDisplayed());

        WebElement customImage = driver.findElement(By.cssSelector("span[class='icons-benefit icon-custom']"));
        softAssert.assertTrue(customImage.isDisplayed());

        WebElement multiImage = driver.findElement(By.cssSelector("span[class='icons-benefit icon-multi']"));
        softAssert.assertTrue(multiImage.isDisplayed());

        WebElement baseImage = driver.findElement(By.cssSelector("span[class='icons-benefit icon-base']"));
        softAssert.assertTrue(baseImage.isDisplayed());

        //7.	Assert that there are 4 texts below of each image
        List<String> texts = new ArrayList<>();
        List<WebElement> textElements = driver.findElements(By.cssSelector("span[class='benefit-txt']"));
        for (WebElement element : textElements) {
            softAssert.assertTrue(element.isDisplayed());
            texts.add(element.getText());
        }
        softAssert.assertEquals(texts.get(0), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(texts.get(1), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(texts.get(2), "To be multiplatform");
        softAssert.assertEquals(texts.get(3), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //8.	Assert that the iframe exists
        List<WebElement> frame = driver.findElements(By.id("frame"));
        softAssert.assertNotEquals(frame.size(), 0);

        //9.	Assert that the “Frame Button” exists
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        List<WebElement> frameButton = driver.findElements(By.id("frame-button"));
        softAssert.assertNotEquals(frameButton.size(), 0);

        //10.   Assert that driver has focus on the original window
        driver.switchTo().window(originalWindow);
        softAssert.assertEquals(driver.getWindowHandle(), originalWindow);

        //11.   Assert that left section menu items are displayed and have proper text
        WebElement homeLeftItem = driver.findElement(By.cssSelector("a[href='index.html'] span"));
        softAssert.assertTrue(homeLeftItem.isDisplayed());
        softAssert.assertEquals(homeLeftItem.getText(), "Home");

        WebElement contactFormLeftItem = driver.findElement(By.cssSelector("a[href='contacts.html'] span"));
        softAssert.assertTrue(contactFormLeftItem.isDisplayed());
        softAssert.assertEquals(contactFormLeftItem.getText(), "Contact form");

        WebElement serviceLeftItem = driver.findElement(By.cssSelector("li[index='3'] a span"));
        softAssert.assertTrue(serviceLeftItem.isDisplayed());
        softAssert.assertEquals(serviceLeftItem.getText(), "Service");

        WebElement metalsColorsLeftItem = driver.findElement(By.cssSelector("a[href='metals-colors.html'] span"));
        softAssert.assertTrue(metalsColorsLeftItem.isDisplayed());
        softAssert.assertEquals(metalsColorsLeftItem.getText(), "Metals & Colors");

        WebElement elementsPacks = driver.findElement(By.cssSelector("li[index='5'] a[ui='label'] span"));
        softAssert.assertTrue(elementsPacks.isDisplayed());
        softAssert.assertEquals(elementsPacks.getText(), "Elements packs");

        softAssert.assertAll();
        driver.close();
    }
}
