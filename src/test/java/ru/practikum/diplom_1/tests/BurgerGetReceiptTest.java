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
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetReceiptTest {

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

        Mockito.when(bun.getName()).thenReturn("Батон");
        Mockito.when(bun.getPrice()).thenReturn(19.99F);

        Mockito.when(ingredientOne.getName()).thenReturn("Помидорка");
        Mockito.when(ingredientTwo.getName()).thenReturn("Кетчунез");
        Mockito.when(ingredientOne.getPrice()).thenReturn(16F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(10.11F);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.SAUCE);

    }

    @Test
    public void getReceiptBurgerSuccess() {

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        String[] receiptList = burger.getReceipt().split("\\r");

        Assert.assertTrue(receiptList[0].contains("Батон"));
        Assert.assertTrue(receiptList[1].contains("filling Помидорка"));
        Assert.assertTrue(receiptList[2].contains("sauce Кетчунез"));
        Assert.assertTrue(receiptList[3].contains("Батон"));
        Assert.assertTrue(receiptList[5].contains("Price"));
    }

    @Test
    public void getReceiptOnlyBunSuccess() {
        burger.setBuns(bun);

        String[] receiptList = burger.getReceipt().split("\\r");

        Assert.assertTrue(receiptList[0].contains("Батон"));
        Assert.assertTrue(receiptList[1].contains("Батон"));
        Assert.assertTrue(receiptList[3].contains("Price"));
    }

    @Test
    public void getReceiptEmptyBurgerFail() {

        try {
            burger.getReceipt();
        } catch (Exception e) {
            assert e instanceof NullPointerException;
        }
    }

}
