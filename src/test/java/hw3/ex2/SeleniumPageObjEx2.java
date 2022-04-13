package hw3.ex2;

import hw3.DifferentElementsPage;
import hw3.SeleniumPOBaseClass;
import hw3.TestPage;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class SeleniumPageObjEx2 extends SeleniumPOBaseClass {

    @Test
    public void ex2Test() throws UnsupportedEncodingException {
        TestPage testPage = new TestPage(driver);

        //1.    Open test site by URL
        softAssert.assertEquals(testPage.getUrl(), testingUrl);

        //2.	Assert Browser title
        softAssert.assertTrue(testPage.hasProperTitle());

        //3.	Perform login, assert user is logged
        testPage.login();
        softAssert.assertTrue(testPage.isUserLoggined());

        //4.	Assert username
        softAssert.assertTrue(testPage.checkLogginedUser());

        //5.    Open Different elements page

        DifferentElementsPage diffElemPage = testPage.getHeaderMenu().goToDifferentElementsPage();
        softAssert.assertTrue(diffElemPage.checkDifferentElementsUrl());

        //6.	Select checkboxes	Water, Wind
        softAssert.assertTrue(diffElemPage.clickCheckboxRowItem("Water"));
        softAssert.assertTrue(diffElemPage.clickCheckboxRowItem("Wind"));

        //7.	Select radio	Selen
        softAssert.assertTrue(diffElemPage.clickRadiobuttonRowItem("Selen"));

        //8.    Select color
        softAssert.assertTrue(diffElemPage.selectColor("Yellow"));

        //9.    Check log pannel
        softAssert.assertTrue(diffElemPage.checkLogsVisibity());

        List<String> containedTexts = Arrays.asList("Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true");
        List<String> logsTexts = diffElemPage.getLogsTexts();

        for (int i = 0; i < 4; ++i) {
            softAssert.assertTrue(logsTexts.get(i).contains(containedTexts.get(i)));
        }

        softAssert.assertAll();
    }
}
