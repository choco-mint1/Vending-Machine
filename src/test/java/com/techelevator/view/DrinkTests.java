package com.techelevator.view;

import com.techelevator.Items.Drink;
import org.junit.Assert;
import org.junit.Test;

public class DrinkTests {

    @Test
    public void makeSound() {
        Drink drink = new Drink("Coke", 1.75);
        String retV = drink.makeNoise();
        Assert.assertEquals("Glug Glug, Yum!", retV);
    }
    @Test
    public void name() {
        Drink drink = new Drink("Coke", 1.75);
        String retV = drink.getName();
        Assert.assertEquals("Coke", retV);
    }

    @Test
    public void price() {
        Drink drink = new Drink("Coke", 1.75);
        double retV = drink.getPrice();
        Assert.assertEquals(1.75, retV, .01);
    }
    @Test
    public void quantity() {
        Drink drink = new Drink("Coke", 1.75);
        int retV = drink.getQuantity();
        Assert.assertEquals(5, 5);
    }
}

