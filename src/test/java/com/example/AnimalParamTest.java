package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    private final String animalKind;
    private final List<String> expectedFood;
    private final Class<? extends Exception> expectedException;

    public AnimalParamTest(String animalKind, List<String> expectedFood,
                           Class<? extends Exception> expectedException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][] {

                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Неизвестный", null, Exception.class}
        };
    }

    @Test
    public void testGetFood() throws Exception {

        if (expectedException != null) {
            try {
                animal.getFood(animalKind);
                fail("Ожидалось исключение для неизвестного типа животного");
            } catch (Exception e) {
                assertEquals("Тип исключения должен соответствовать ожидаемому",
                        expectedException, e.getClass());
            }
        } else {
            assertEquals("Список еды должен соответствовать типу животного",
                    expectedFood, animal.getFood(animalKind));
        }
    }
}