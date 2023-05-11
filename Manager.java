import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Product> items;

    public Manager() {
        items = new ArrayList<>();
    }

    // method to add an item to the list of items available in the toffee shop
    public void addItem(Product item) {
        items.add(item);
    }

    // method to display the list of items available in the toffee shop
    public void displayItems() {
        System.out.println("Items available in the toffee shop:");
        for (Product item : items) {
            System.out.println(item.getName() + " - " + item.getUnitPrice());
        }
    }

    public void MakeOrder(Cart cart , double cashPaid){
        Order newOrder = new Order(cart , cashPaid);
        newOrder.processOrder();
    }

}
