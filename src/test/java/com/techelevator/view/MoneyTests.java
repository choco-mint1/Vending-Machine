package com.techelevator.view;

import com.techelevator.Money;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTests {
    @Test
    public void addMoney(){
        Money money = new Money(0.0);
        money.addBalance(2.50);
        double retV = money.getBalance();
        Assert.assertEquals(2.50, 2.50, .01);
    }
    @Test
    public void subMoney(){
        Money money = new Money(0.0);
        money.addBalance(2.50);
        money.subtractBalance(1.50);
        double retV = money.getBalance();
        Assert.assertEquals(1.00, 1.00, .01);
    }
}
