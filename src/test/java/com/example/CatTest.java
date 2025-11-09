package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Кот должен мяукать", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals("Список еды кота должен соответствовать ожидаемому",
                expectedFood, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}