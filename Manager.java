package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private boolean is_logged = false;
    public static int lastID = 6;
    private final Registration R = new Registration();
    private static final ArrayList<Product> items = new ArrayList<>();
    private static final DataBase dataBase = new DataBase();
    static{
        dataBase.AddToDatabase(new User("User1" , "User1@gmail.com","xx1", 1));
        dataBase.AddToDatabase(new User("User2" , "User2@gmail.com","xx2", 2));
        dataBase.AddToDatabase(new User("User3" , "User3@gmail.com","xx3", 3));
        dataBase.AddToDatabase(new User("User4" , "User4@gmail.com","xx4", 4));
        dataBase.AddToDatabase(new User("User5" , "User5@gmail.com","xx5", 5));

    }

    private String name, email, password;
    private final User current = new User("ali", "XD", "15", 1);

    static {
        items.add(new Product(1, "Cupcake   ", 30));
        items.add(new Product(2, "Cake      ", 200));
        items.add(new Product(3, "Cinnabon  ", 100));
        items.add(new Product(4, "Brownies  ", 70));
        items.add(new Product(5, "Biscuit   ", 45));
        items.add(new Product(6, "Croissant ", 50));
        items.add(new Product(7, "Kunafa    ", 175));
        items.add(new Product(8, "basbousa  ", 175));
        items.add(new Product(9, "harissa   ", 150));
    }


    public Manager() {
        System.out.println("\t\t\t\t<<Welcome to Toffee Store>>\n");
    }


    // method to add an item to the list of items available in the toffee shop
    public void addItem(Product item) {
        items.add(item);
    }

    // method to display the list of items available in the toffee shop
    public void displayItems() {
        System.out.println("Items available in the toffee shop:");
        for (Product item : items) {
            System.out.println(item.getCode() + " - " + item.getName() + " - " + item.getUnitPrice());
        }
    }
    // method to search for an item
    private Product searchInCatalog(int productCode) {
        Product newProduct = new Product(0, null, 0);
        for (Product i : items) {
            if (i.getCode() == productCode) {
                newProduct = i;
            }
        }
        return newProduct;
    }

    //  Search
    public void search(int code) {
        System.out.println("After searching for this code " + "{ " + searchInCatalog(code).getCode() + " } ...");
        System.out.println("Product Name and Unit price: [ " + searchInCatalog(code).getName() + "- " + searchInCatalog(code).getUnitPrice() + " .LE ]");
    }
    // method to add items to cart
    public void Fill_cart() {
        int Exit = 100000;
        while (Exit != 0) {
            Scanner scanner = new Scanner(System.in);
            displayItems();
            System.out.println("enter 0 to exit or the item id to be added to cart");
            Exit = scanner.nextInt();
            boolean found = false;
            Product temp = new Product(0, null, 0);
            //  Find the product
            for (Product p : items) {
                if (Exit == p.getCode()) {
                    found = true;
                    temp = p;
                }
            }
            if (!found) {
                continue;
            }
            // add product to the cart
            current.cart.addProduct(temp);
        }
        System.out.println("Cart filled successfully");
    }
    //  method to allow user to make order
    public void MakeOrder(double cashPaid) {
        Order newOrder = new Order(this.current.cart, cashPaid);
        newOrder.processOrder();
    }
    public boolean checkR(User x){
        if(x == null){
            return false;
        }
        dataBase.AddToDatabase(x);
        return true;
    }


    public void Run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Plz Enter (l) if u want to login and (r) if u want to regester..");
        String options = input.nextLine();

        if (options.contentEquals("l")) {
            for (int i = 0; i < 4; i++) {
                if (R.login()) {
                    is_logged = true;
                    break;
                }
            }

        } else if (options.contentEquals("r")) {
            while (true){
                System.out.println("enter 0 to exit or 1 to to register :");
                int Input = input.nextInt();
                if(Input == 1 ){
                    if(checkR(R.Register(lastID++))) return;
                }
                else if( Input == 0) {
                    return;
                }
            }

        }
    }

    public boolean isIs_logged() {
        return is_logged;
    }
}
