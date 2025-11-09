package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;
    Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void testGetFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals("Друзья Алекса должны быть как в мультике",
                expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Алекс должен жить в Нью-Йоркском зоопарке",
                "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() {
        assertEquals("У Алекса не должно быть львят", 0, alex.getKittens());
    }

    @Test
    public void testAlexHasMane() {
        assertTrue("У Алекса должна быть грива", alex.doesHaveMane());
    }
}