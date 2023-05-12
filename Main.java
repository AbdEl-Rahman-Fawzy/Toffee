package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager store = new Manager();
        //  Allows the user to Log in or Register.
        store.Run();

        //  display catalog
        store.displayItems();

        //  search in catalog by product code
        store.search(1);

        //  Allows the user to add items to the cart
        store.Fill_cart();

        // Allows making an order to be paid upon delivery in cash
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount payed :");
        double amount = scanner.nextDouble();
        store.MakeOrder(amount);
    }
}