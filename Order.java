import java.util.Map;

public class Order {
    private final Cart cart;
    private final double cashPaid;
    private final double totalPrice;
    private final double cashChange;

    public Order(Cart cart, double cashPaid) {
        this.cart = cart;
        this.cashPaid = cashPaid;
        this.totalPrice = cart.getTotal();
        this.cashChange = cashPaid - totalPrice;
    }

    public double getCashPaid() {
        return cashPaid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getCashChange() {
        return cashChange;
    }

    public boolean isPaidAccurately() {
        // Calculate the total amount paid by the customer
        double totalPaid = cart.getTotal();

        // Check if the paid amount matches the total price of the cart
        return Math.abs(cashPaid - totalPaid) < 0.001;
    }

    public boolean processOrder() {
        if (isPaidAccurately()) {
            // Process the order by updating the inventory and generating a receipt
            cart.emptyCart();
            generateReceipt();
            return true;
        } else {
            // Print an error message if the paid amount does not match the total price
                System.out.println("Cash paid less than cart's price .");
            return false;
        }
    }

    private void generateReceipt() {
        // Generate a receipt by printing the details of the items in the cart
        System.out.println("Receipt:");
        for (Map.Entry<Product, Integer> item : cart.getProducts().entrySet() ) {
            Product p = item.getKey();
            int quantity = item.getValue();
            System.out.println("- " + p.getName() + " (" + quantity + " x " + p.getUnitPrice() + ")");
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Cash paid: " + cashPaid);
        System.out.println("Cash change: " + cashChange);
    }
}
