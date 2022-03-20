package ru.practikum.diplom_1.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientsTest {

    @Mock
    Bun bun;

    Burger burger;
    String nameOne = "Начинка";
    String nameTwo = "Соус";

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);

        Ingredient ingredientOne = new Ingredient(IngredientType.FILLING, nameOne, 16);
        Ingredient ingredientTwo = new Ingredient(IngredientType.SAUCE, nameTwo, 10.11F);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
    }

    @Test
    public void removeIngredientBurgerSuccess() {
        burger.removeIngredient(1);

        Assert.assertTrue(burger.getReceipt().contains(nameOne));
        Assert.assertFalse(burger.getReceipt().contains(nameTwo));

        burger.removeIngredient(0);

        Assert.assertFalse(burger.getReceipt().contains(nameOne));
        Assert.assertFalse(burger.getReceipt().contains(nameTwo));
    }

    @Test
    public void moveIngredientBurgerSuccess() {
        burger.moveIngredient(0, 1);

        String[] receipt = burger.getReceipt().split("\\r");

        Assert.assertTrue(receipt[2].contains(nameOne));
        Assert.assertTrue(receipt[1].contains(nameTwo));
    }

}
