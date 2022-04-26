package hw4.ex2;

import hw4.BaseTest;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Story("Loggined user can go to Different Elements page and perform actions on it")
public class DifferentElementsPageTest extends BaseTest {
    @Test(description = "Test login process and actions performed on Different Elements page")
    public void actionsOnDifferentElementsPageTest() {

        //1.    Open test site by URL
        actionStep.openHomePage();

        //2.	Assert Browser title
        assertionStep.checkTitle();

        //3.	Perform login, assert user is logged
        actionStep.login(user.getLogin(), user.getPassword());
        assertionStep.checkUserLogged();

        //4.	Assert username
        assertionStep.checkUserName(user.getFullName());

        //5.    Open Different elements page
        actionStep.goToDifferentElementsPage();
        assertionStep.checkDifferentElementsPageIsOpen();

        //6.	Select checkboxes	Water, Wind
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");
        assertionStep.isCheckboxSelected("Water");
        assertionStep.isCheckboxSelected("Wind");

        //7.	Select radio	Selen
        actionStep.selectRadioButton("Selen");
        assertionStep.isRadioSelected("Selen");

        //8.    Select color
        actionStep.selectColor("Yellow");
        assertionStep.checkColor("Yellow");

        //9.    Check log pannel
        assertionStep.checkLogTextsVisibility();

        List<String> containedTexts = Arrays.asList("Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true");
        assertionStep.checkLogsTexts(containedTexts);
    }
}
