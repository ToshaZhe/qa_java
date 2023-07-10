package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;


    @Test
    public void getFoodHerbivoreReturnListHerbivoreFood() throws Exception {
        List<String> herbivoreFood = List.of("Трава", "Различные растения");
        assertEquals(herbivoreFood, feline.getFood("Травоядное"));
    }

    @Test
    public void getFoodPredatorReturnListPredatorFood() throws Exception {
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(predatorFood, feline.getFood("Хищник"));
    }

    @Test
    public void getFoodIncorrectAnimalKindExpectException() {
        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood("Насекомые");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyReturnFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensNoParamReturn1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensIntParamReturnsTheSameValue() {
        int kittensCount = 10;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}