package hw4.ex1;

import hw4.BaseTest;
import hw4.ScreenshotListener;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({ScreenshotListener.class})
@Story("Loggined user can see main Home page items")
public class HomePageTest extends BaseTest {

    @Test(description = "Test login process, place and visibility of Home page items")
    public void homePageItemsTest() {

        //1.    Open test site by URL
        actionStep.openHomePage();

        //2.	Assert Browser title
        assertionStep.checkTitle();

        //3.	Perform login, assert user is logged
        actionStep.login(user.getLogin(), user.getPassword());
        assertionStep.checkUserLogged();

        //4.	Assert username
        assertionStep.checkUserName(user.getFullName());

        //5.	Assert that there are 4 items on the header
        List<String> expectedItemsNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertionStep.checkHeaderMenu(expectedItemsNames);

        //6.	Assert that there are 4 images
        assertionStep.checkImages();

        //7.	Assert that there are 4 texts below of each image
        List<String> expectedTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        assertionStep.checkTextsUnderImages(expectedTexts);

        //8.	Assert that the iframe exists
        assertionStep.checkIframeExists();

        //9.	Assert that the “Frame Button” exists
        actionStep.goToIframePage();
        assertionStep.checkFrameButton();

        //10.   Assert that driver has focus on the original window
        actionStep.goToHomePage();
        assertionStep.checkTitle();

        //11.   Assert that left section menu items are displayed and have proper text
        List<String> expectedLeftItemsNames = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        assertionStep.checkLeftMenu(expectedLeftItemsNames);
    }
}
