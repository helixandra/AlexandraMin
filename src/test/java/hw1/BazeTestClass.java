package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BazeTestClass {
    static final double EPS = 1e-7;
    Calculator calculator;

    @BeforeClass
    public void setupCalculator() {
        calculator = new Calculator();
    }
}
