package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals("Метод getFamily должен возвращать корректное описание семейств",
                expected, animal.getFamily());
    }

    @Test
    public void testGetFoodWithUnknownAnimalThrowsException() {
        try {
            animal.getFood("Неизвестный");
            fail("Ожидалось исключение для неизвестного типа животного");
        } catch (Exception e) {
            assertEquals("Сообщение об ошибке должно быть корректным",
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }
}