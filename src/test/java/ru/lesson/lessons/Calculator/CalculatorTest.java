package ru.lesson.lessons.Calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Andrey on 02.05.2017.
 */
public class CalculatorTest {

    @Test
    public void testPlus() throws Exception {
        Calculator calculator = new Calculator();
        calculator.plus(1, 1);
        assertEquals(2, calculator.getResult());
    }

    @Test
    public void dividing() throws Exception {
        Calculator calculator = new Calculator();
        calculator.dividing(1, 1);
        assertEquals(1, calculator.getResult());
    }

}