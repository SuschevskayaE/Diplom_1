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
public class BurgerAddIngredientTest {

    Burger burger;

    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientBurgerSuccess() {
        String name = "Начинка";

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 16);
        burger.addIngredient(ingredient);

        Assert.assertEquals("Название ингридиента не соответствует", name, burger.ingredients.get(0).name);
    }
}
