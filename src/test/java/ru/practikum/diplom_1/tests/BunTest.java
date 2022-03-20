package ru.practikum.diplom_1.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"булка", 16},
                {"Черная булка>", 16.11F}
        };
    }

    @Test
    public void bunGetNameSuccess() {
        Bun bun = new Bun(name, price);
        String receivedName = bun.getName();
        Assert.assertEquals(receivedName, name);
    }

    @Test
    public void bunGetPriceSuccess() {
        Bun bun = new Bun(name, price);
        float receivedPrice = bun.getPrice();
        Assert.assertEquals(receivedPrice, price, 0.001);
    }

}
