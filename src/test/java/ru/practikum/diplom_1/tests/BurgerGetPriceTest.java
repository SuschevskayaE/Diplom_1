package ru.practikum.diplom_1.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;


    @Before
    public void setUp() {
        burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(19.99F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(16F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(10.11F);
    }

    @Test
    public void getPriceBurgerSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        float price = burger.getPrice();
        Assert.assertEquals("Цена бургера не соответствует", 66.09F, price, 0.001);
    }

    @Test
    public void getPriceOnlyBunSuccess() {
        burger.setBuns(bun);

        float price = burger.getPrice();
        Assert.assertEquals("Цена булки не соответствует", 39.98F, price, 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void getPriceEmptyBurgerFail() {
        burger.getPrice();
    }

}
