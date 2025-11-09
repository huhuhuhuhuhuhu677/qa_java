package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    private final int kittensCount;
    private final int expectedCount;

    public FelineParamTest(int kittensCount, int expectedCount) {
        this.kittensCount = kittensCount;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1, 1},
                {3, 3},
                {5, 5}
        };
    }

    @Test
    public void testGetKittensWithParameter() {
        assertEquals("Количество котят должно соответствовать переданному параметру",
                expectedCount, feline.getKittens(kittensCount));
    }
}