package com.techelevator.view;

import com.techelevator.Items.Gum;
import org.junit.Assert;
import org.junit.Test;

public class GumTests {

    @Test
    public void makeSound() {
        Gum gum = new Gum("BigLeague Chew", 1.50);
        String retV = gum.makeNoise();
        Assert.assertEquals("Chew Chew, Yum!", retV);
    }

    @Test
    public void name() {
        Gum gum = new Gum("BigLeague Chew", 1.50);
        String retV = gum.getName();
        Assert.assertEquals("BigLeague Chew", retV);
    }

    @Test
    public void price() {
        Gum gum = new Gum("BigLeague Chew", 1.50);
        double retV = gum.getPrice();
        Assert.assertEquals(1.50, retV, .01);
    }
    @Test
    public void quantity() {
        Gum gum = new Gum("BigLeague Chew", 1.50);
        int retV = gum.getQuantity();
        Assert.assertEquals(5, 5);
    }

}
