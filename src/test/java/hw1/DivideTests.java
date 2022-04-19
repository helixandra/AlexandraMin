package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTests extends BaseTest {

    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][]{{660.62, 97.15, 6.8}, {1840.16, 164.3, 11.2}, {35.7, 4.2, 8.5}};
    }

    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][]{{67184, 988, 68}, {121726, 22, 5533}, {2418, 31, 78}};
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void divisionByZeroExceptionTest() {
        calculator.div(44, 0);
    }

    @Test(dataProvider = "correctLongData")
    public void divideLongTest(long num1, long num2, long expectedResult) {
        long actual = calculator.div(num1, num2);
        assertEquals(actual, expectedResult);
    }

    @Test(dataProvider = "correctDoubleData")
    public void divideDoubleTest(double num1, double num2, double expectedResult) {
        double actual = calculator.div(num1, num2);
        assertEquals(actual, expectedResult, EPS);
    }
}
