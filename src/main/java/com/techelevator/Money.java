package com.techelevator;

public class Money {

    private  double balance;

    public Money(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void subtractBalance(double price) {
        this.balance -= price;
    }

    public void change(TransactionLog log) {
        double change = balance;

        int quarters = (int) (change/ 0.25);
        change %= 0.25;
        System.out.println("Quarters: ");
        int dimes = (int) (change/0.10);
        change %= 0.10;

        int nickels = (int) (change/0.05);

        System.out.println("Change returned: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");

        log.log("Dispense Change:", balance, 0);

        balance = 0;
    }

}
