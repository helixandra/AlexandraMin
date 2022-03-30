package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTests {
    static final double EPS = 1e-7;
    private Calculator calculator;

    @BeforeTest
    public void doBeforeTest(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] correctDoubleData() {
        return new Object[][] {{660.62,97.15,6.8}, {1840.16,164.3,11.2}, {35.7, 4.2, 8.5}};
    }

    @DataProvider
    public static Object[][] correctLongData() {
        return new Object[][] {{67184,988,68}, {121726,22,5533}, {2418, 31, 78}};
    }

    @Test(expectedExceptions = { NumberFormatException.class } )
    public void divisionByZeroExceptionTest() throws Exception {
        calculator.div(44, 0);
    }

    @Test(dataProvider = "correctLongData")
    public void DivideLongTest (long num1, long num2, long expectedResult) {
        Calculator calculator = new Calculator();
        long actual = calculator.div(num1,num2);
        assertEquals(actual, expectedResult);
    }

    @Test(dataProvider = "correctDoubleData")
    public void DivideDoubleTest (double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator();
        double actual = calculator.div(num1,num2);
        assertEquals(actual, expectedResult, EPS);
    }

}
