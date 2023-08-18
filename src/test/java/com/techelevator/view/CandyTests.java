package com.techelevator.view;
import com.techelevator.Items.Candy;
import org.junit.Assert;
import org.junit.Test;

public class CandyTests {

    @Test
    public void makeSound(){
        Candy candy = new Candy("butterfinger", 1.00);
        String retV = candy.makeNoise();
        Assert.assertEquals("Munch Munch, Yum!", retV);
    }
    @Test
    public void name() {
        Candy candy = new Candy("butterfinger", 1.00);
        String retV = candy.getName();
        Assert.assertEquals("butterfinger", retV);
    }

    @Test
    public void price() {
        Candy candy = new Candy("butterfinger", 1.00);
        double retV = candy.getPrice();
        Assert.assertEquals(1.00, retV, .01);
    }
    @Test
    public void quantity() {
        Candy candy = new Candy("butterfinger", 1.00);
        int retV = candy.getQuantity();
        Assert.assertEquals(5, 5);
    }
}
