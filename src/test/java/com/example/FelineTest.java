package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Хищник должен есть мясо, птиц и рыбу",
                expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Feline должен принадлежать к семейству кошачьих",
                "Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals("Метод getKittens() без параметров должен возвращать 1",
                1, feline.getKittens());
    }
}