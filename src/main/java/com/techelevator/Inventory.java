package com.techelevator;

import com.techelevator.Items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private Map<String, VendingMachineItem> itemMap = new TreeMap<>();
    private double totalSales;
    public Inventory() {}
    public void readInventory() {
        String vendingInventory = "vendingmachine.csv";
        File inventoryFile = new File(vendingInventory);
        try (Scanner invScanner = new Scanner(inventoryFile)) {
            while (invScanner.hasNextLine()) {
                String[] lineSplit = invScanner.nextLine().split(("\\|"));

                String slot = lineSplit[0];
                String name = lineSplit[1];
                double price = Double.parseDouble(lineSplit[2]);
                String type = lineSplit[3];

                VendingMachineItem vendingMachineItem = null;
                switch (type) {
                    case "Candy":
                        vendingMachineItem = new Candy(name, price);
                        break;
                    case "Chip":
                        vendingMachineItem = new Chip(name, price);
                        break;
                    case "Drink":
                        vendingMachineItem = new Drink(name, price);
                        break;
                    case "Gum":
                        vendingMachineItem = new Gum(name, price);
                        break;
                }
                itemMap.put(slot, vendingMachineItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void salesLog() {
        for (Map.Entry<String, VendingMachineItem> sales : itemMap.entrySet()) {
            System.out.println(sales.getValue().getName() + "|" + (5 - sales.getValue().getQuantity()));
        }
        System.out.println();
        System.out.println("Total Sales $" + totalSales);
    }

    public Map<String, VendingMachineItem> getItemMap() {
        return itemMap;
    }

    public void displayItems() {
        System.out.printf("%-4s %-20s %-10s", "Slot", "Item", "Price");
        System.out.println();


        for (Map.Entry<String, VendingMachineItem> entry : itemMap.entrySet()) {
            String slot = entry.getKey();
            VendingMachineItem vendingMachineItem = entry.getValue();
            String quantity = vendingMachineItem.getQuantity() == 0 ? "Sold Out" : "";
            System.out.printf("%-4s %-20s $%-10.2f %s%n", slot, vendingMachineItem.getName(), vendingMachineItem.getPrice(), quantity);
        }
    }

    public void purchaseItem(String productCode, Money money, TransactionLog log) {
        if (!itemMap.containsKey(productCode)) {
            System.out.println("Invalid slot. Please select one of the existing options.");
            return;
        }
        VendingMachineItem vendingMachineItem = itemMap.get(productCode);
        if (vendingMachineItem.getPrice() > money.getBalance()) {
            System.out.println("Insufficient balance to purchase this item. Please add more money.");
        } else if (vendingMachineItem.getQuantity() == 0) {
            System.out.println("Sold Out");
        } else {
            money.subtractBalance(vendingMachineItem.getPrice());
            totalSales += vendingMachineItem.getPrice();
            vendingMachineItem.setQuantity(vendingMachineItem.getQuantity() - 1);
            System.out.println(vendingMachineItem.getName() + " $" + String.format("%.2f", vendingMachineItem.getPrice()) + " $" + String.format("%.2f", money.getBalance()));
            System.out.println(vendingMachineItem.makeNoise());

            log.log(vendingMachineItem.getName(), vendingMachineItem.getPrice(), money.getBalance());
        }
    }
    public void logo(){
        System.out.println("**********************|**********************");
        System.out.println("* *  * **  * ___.----' `----.___*  * *  *  * ");
        System.out.println("*  *  * *_.-'   .-'   / `   -   `-._*   * * *");
        System.out.println("* * * .-'    .'               `-    `-.* *  *");
        System.out.println("* * .'              /            `.    `.* * ");
        System.out.println("*  /___    /                       `  .--`.**");
        System.out.println("* '    `-.  _.---._ |_.---._ .--'''-.'       ");
        System.out.println("*         '        '  |     `                ");
        System.out.println("        Umbrella Corp |                     *");
        System.out.println("*                     |                      ");
        System.out.println("*                     |  Vendo-Matic 800   * ");
        System.out.println("                      H                     *");
        System.out.println("                      Yb   dB                ");
        System.out.println("*                      YbmdP                 ");
    }

}
