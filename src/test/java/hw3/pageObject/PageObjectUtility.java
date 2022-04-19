package hw3.pageObject;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageObjectUtility {
    public static List<String> getTextsOfElementsList(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement elem : elements) {
            texts.add(elem.getText());
        }
        return texts;
    }

    public static boolean isElementsDisplayed(List<WebElement> elements) {
        for (WebElement elem : elements) {
            if (!elem.isDisplayed()) return false;
        }
        return true;
    }
}
