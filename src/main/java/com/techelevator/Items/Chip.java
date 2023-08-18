package com.techelevator.Items;

public class Chip extends VendingMachineItem {
    public Chip(String name, double price) {
        super(name, price);
    }
    @Override
    public String makeNoise() {
        return "Crunch Crunch, Yum!";
    }
}
