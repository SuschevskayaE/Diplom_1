package ru.practikum.diplom_1.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

public class BurgerBunTest {

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsBurgerSuccess() {
        String name = "Черная";
        float price = 19.99F;
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        Assert.assertEquals("Название булки не соответствует", name, burger.bun.name);
    }
}
