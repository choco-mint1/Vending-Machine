package com.techelevator.Items;

public class Candy extends VendingMachineItem {
    public Candy(String name, double price) {
        super(name, price);
    }
    @Override
    public String makeNoise() {
        return "Munch Munch, Yum!";
    }
}
