package com.techelevator.Items;

public class VendingMachineItem {
    private String slot;
    private String name;
    private double price;
    private int quantity = 5;

    public VendingMachineItem (String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getSlot(){
        return slot;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String makeNoise() {
        return "Yummy Yummy in my Tummy";
    }
}
