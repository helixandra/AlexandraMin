package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubstractTests {
    static final double EPS = 1e-7;
    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][] {{2.5,1.0,1.5}, {9.225, 8.7, 0.525}, {1000.0, 105.0, 895.0}};
    }

    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][] {{1000000,1,999999}, {9, 3, 6}, {155555, 5555, 150000}};
    }

    @Test(dataProvider = "correctDoubleData")
    public void SubstractDoubleTest (double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator();
        double actual = calculator.sub(num1,num2);
        assertEquals(actual, expectedResult,EPS);
    }

    @Test(dataProvider = "correctLongData")
    public void SubstractLongTest (long num1, long num2, long expectedResult) {
        Calculator calculator = new Calculator();
        long actual = calculator.sub(num1,num2);
        assertEquals(actual, expectedResult);
    }
}
