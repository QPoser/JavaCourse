package ru.lesson.lessons.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Andrey on 02.05.2017.
 */
public class CalculatorTest {

    @Test
    public void minus() throws Exception {
        Calculator calculator = new Calculator();
        calculator.minus(9, 7);
        assertEquals(2, calculator.getResult());
    }

    @Test
    public void multiply() throws Exception {
        Calculator calculator = new Calculator();
        calculator.multiply(2, 3);
        assertEquals(6, calculator.getResult());
    }


    @Test
    public void testPlus() throws Exception {
        Calculator calculator = new Calculator();
        calculator.plus(3, 8);
        assertEquals(11, calculator.getResult());
    }

    @Test
    public void dividing() throws Exception {
        Calculator calculator = new Calculator();
        calculator.dividing(6, 3);
        assertEquals(2, calculator.getResult());
    }


}