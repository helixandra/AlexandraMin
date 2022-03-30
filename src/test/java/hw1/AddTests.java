package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTests {
    static final double EPS = 1e-7;
    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][] {{1.0,2.5,3.5}, {8.7,9.225,17.925}, {1000.0, 105.0, 1105.0}};
    }
    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][] {{8569,274198,282767}, {159874,123698,283572}, {4, 3, 7}};
    }

    @Test(dataProvider = "correctDoubleData")
    public void AddDoubleTest (double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator();
        double actual = calculator.sum(num1,num2);
        assertEquals(actual, expectedResult, EPS);
    }

    @Test(dataProvider = "correctLongData")
    public void AddLongTest (long num1, long num2, long expectedResult) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(num1,num2);
        assertEquals(actual, expectedResult);
    }
}
