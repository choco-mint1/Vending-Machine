package com.techelevator.view;

import com.techelevator.Items.Chip;
import org.junit.Assert;
import org.junit.Test;

public class ChipTests {
    @Test
    public void makeSound() {
        Chip chip = new Chip("Doritos", 2.50);
        String retV = chip.makeNoise();
        Assert.assertEquals("Crunch Crunch, Yum!", retV);
    }
    @Test
    public void name() {
        Chip chip = new Chip("Doritos", 2.50);
        String retV = chip.getName();
        Assert.assertEquals("Doritos", retV);
    }

    @Test
    public void price() {
        Chip chip = new Chip("Doritos", 2.50);
        double retV = chip.getPrice();
        Assert.assertEquals(2.50, 2.50, .01);
    }
    @Test
    public void quantity() {
        Chip chip = new Chip("Doritos", 2.50);
       int  retV = chip.getQuantity();
        Assert.assertEquals(5, 5);
    }
}
