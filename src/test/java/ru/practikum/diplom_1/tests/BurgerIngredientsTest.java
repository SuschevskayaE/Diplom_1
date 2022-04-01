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

        Assert.assertEquals("Ингредиент удалился неверно", nameOne, burger.ingredients.get(0).name);
        Assert.assertEquals("Количество ингредиентов неверно", 1, burger.ingredients.size());

        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientBurgerSuccess() {
        burger.moveIngredient(0, 1);

        Assert.assertEquals("Ингредиент не переместился", nameOne, burger.ingredients.get(1).name);
        Assert.assertEquals("Ингредиент не переместился", nameTwo, burger.ingredients.get(0).name);
    }

}
