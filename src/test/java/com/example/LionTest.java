package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {

        maleLion = new Lion("Самец", felineMock);
        femaleLion = new Lion("Самка", felineMock);
    }

    @Test
    public void testMaleLionHasMane() throws Exception {
        assertTrue("Самец льва должен иметь гриву", maleLion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        assertFalse("Самка льва не должна иметь гриву", femaleLion.doesHaveMane());
    }

    @Test
    public void testGetKittensReturnsCorrectCount() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        int kittensCount = maleLion.getKittens();

        assertEquals("Количество котят должно соответствовать значению из мока",
                3, kittensCount);
    }

    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        maleLion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = femaleLion.getFood();

        assertEquals("Список еды льва должен соответствовать ожидаемому",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        femaleLion.getFood();

        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестный", felineMock);
    }
}