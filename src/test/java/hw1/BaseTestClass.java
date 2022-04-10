package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    static final double EPS = 1e-7;
    Calculator calculator;

    @BeforeClass
    public void setupCalculator() {
        calculator = new Calculator();
    }
}
