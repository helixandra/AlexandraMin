package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTests extends BaseTestClass {

    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][]{{45.2, 2.5, 113.0}, {27.25, 8.0, 218.0}, {1000.0, 105.0, 105000.0}};
    }

    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][]{{457, 391, 178687}, {844, 965, 814460}, {11111, 456, 5066616}};
    }

    @Test(dataProvider = "correctDoubleData")
    public void multiplyDoubleTest(double num1, double num2, double expectedResult) {
        double actual = calculator.mult(num1, num2);
        assertEquals(actual, expectedResult, EPS);
    }

    @Test(dataProvider = "correctLongData")
    public void multiplyLongTest(long num1, long num2, long expectedResult) {
        long actual = calculator.mult(num1, num2);
        assertEquals(actual, expectedResult);
    }
}
