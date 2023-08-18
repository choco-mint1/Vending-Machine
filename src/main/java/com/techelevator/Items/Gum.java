package com.techelevator.Items;

public class Gum extends VendingMachineItem {
    public Gum(String name, double price) {
        super(name, price);
    }
    @Override
    public String makeNoise() {
        return "Chew Chew, Yum!";
    }
}
