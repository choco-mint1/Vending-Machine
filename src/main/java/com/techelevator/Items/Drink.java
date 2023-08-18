package com.techelevator.Items;

public class Drink extends VendingMachineItem {
    public Drink(String name, double price) {
        super(name, price);
    }
    @Override
    public String makeNoise() {
        return "Glug Glug, Yum!";
    }
}
