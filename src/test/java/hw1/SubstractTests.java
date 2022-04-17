package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubstractTests extends BaseTest {

    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][]{{2.5, 1.0, 1.5}, {9.225, 8.7, 0.525}, {1000.0, 105.0, 895.0}};
    }

    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][]{{1000000, 1, 999999}, {9, 3, 6}, {155555, 5555, 150000}};
    }

    @Test(dataProvider = "correctDoubleData")
    public void substractDoubleTest(double num1, double num2, double expectedResult) {
        double actual = calculator.sub(num1, num2);
        assertEquals(actual, expectedResult, EPS);
    }

    @Test(dataProvider = "correctLongData")
    public void substractLongTest(long num1, long num2, long expectedResult) {
        long actual = calculator.sub(num1, num2);
        assertEquals(actual, expectedResult);
    }
}
