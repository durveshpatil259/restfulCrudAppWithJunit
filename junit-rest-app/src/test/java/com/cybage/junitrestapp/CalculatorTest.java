package com.cybage.junitrestapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testMultiply(){
        assertEquals(20,calculator.multiply(4,5));
        //assertEquals(25,calculator.multiply(2,3));

    }

    @Test
    public void testDivide(){
        assertEquals(2,calculator.divide(4,2));

    }

}
