package hw3.ex1;

import hw3.pageObject.pages.HomePage;
import hw3.pageObject.pages.IframePage;
import hw3.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static hw3.pageObject.PageObjectUtility.isElementDisplayed;

public class SeleniumPageObjEx1 extends BaseTest {

    @Test
    public void ex1Test() throws UnsupportedEncodingException {
        SoftAssert softAssert = new SoftAssert();
        HomePage testPage = new HomePage(driver);

        //1.    Open test site by URL
        softAssert.assertEquals(testPage.getUrl(), testingUrl);

        //2.	Assert Browser title
        softAssert.assertTrue(testPage.hasProperTitle());

        //3.	Perform login, assert user is logged
        testPage.login(user.getLogin(), user.getPassword());
        softAssert.assertTrue(testPage.isUserLoggined());

        //4.	Assert username
        softAssert.assertTrue(testPage.checkLogginedUser(user.getFullName()));

        //5.	Assert that there are 4 items on the header
        List<String> expectedItemsNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertTrue(testPage.getHeaderMenu().checkHeaderMenuItems());
        softAssert.assertEquals(testPage.getHeaderMenu().getHeaderMenuItemsTexts(), expectedItemsNames);

        //6.	Assert that there are 4 images
        softAssert.assertTrue(testPage.checkImages());

        //7.	Assert that there are 4 texts below of each image
        List<String> expectedTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        softAssert.assertTrue(testPage.checkTextsUnderImages());
        softAssert.assertEquals(testPage.getTextsUnderImages(), expectedTexts);

        //8.	Assert that the iframe exists
        softAssert.assertTrue(testPage.isThereIframe());

        //9.	Assert that the “Frame Button” exists
        IframePage frame = testPage.goToIframe();
        softAssert.assertTrue(frame.getFrameButton().isDisplayed());

        //10.   Assert that driver has focus on the original window
        frame.goToHomePage();
        softAssert.assertTrue(testPage.hasProperTitle());

        //11.   Assert that left section menu items are displayed and have proper text
        List<String> expectedLeftItemsNames = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(testPage.checkLeftMenuItems());
        softAssert.assertEquals(testPage.getLeftMenuItemsTexts(), expectedLeftItemsNames);

        softAssert.assertAll();
    }
}
