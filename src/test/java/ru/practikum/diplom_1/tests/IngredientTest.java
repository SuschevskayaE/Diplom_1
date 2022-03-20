package ru.practikum.diplom_1.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private String name;
    private float price;
    private IngredientType type;

    public IngredientTest(String name, float price, IngredientType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {"Начинка", 16, IngredientType.FILLING},
                {"Соус", 16.11F, IngredientType.SAUCE}
        };
    }

    @Test
    public void ingredientGetNameSuccess() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String receivedName = ingredient.getName();
        Assert.assertEquals(receivedName, name);
    }

    @Test
    public void ingredientGetPriceSuccess() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float receivedPrice = ingredient.getPrice();
        Assert.assertEquals(receivedPrice, price, 0.001);
    }

    @Test
    public void ingredientGetTypeSuccess() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType receivedType = ingredient.getType();
        Assert.assertEquals(receivedType, type);
    }

}
