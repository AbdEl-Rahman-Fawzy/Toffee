import java.util.HashMap;
import java.util.Map;

public class Cart {
    // Map of products and their quantities in the cart
    private final Map<Product, Integer> products;
    // Total price of products in the cart
    private double total;

    public Cart() {
        products = new HashMap<>();
        total = 0.0;
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        // If the product is already in the cart, increment its quantity
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else { // Otherwise, add the product to the cart with a quantity of 1
            products.put(product, 1);
        }
        total += product.getUnitPrice();
    }

    // Remove a product from the cart
    public void removeProduct(Product product) {
        // If the product is in the cart, decrement its quantity
        if (products.containsKey(product)) {
            int quantity = products.get(product);
            if (quantity == 1) {
                products.remove(product);
            } else {
                products.put(product, quantity - 1);
            }
            total -= product.getUnitPrice();
        }
    }

    // Get the map of products and their quantities in the cart
    public Map<Product, Integer> getProducts() {
        return products;
    }

    // Get the total price of products in the cart
    public double getTotal() {
        return total;
    }

    // Get the number of products in the cart
    public int getProductCount() {
        int count = 0;
        for (int quantity : products.values()) {
            count += quantity;
        }
        return count;
    }

    // Empty the cart
    public void emptyCart() {
        products.clear();
        total = 0.0;
    }

    // Display the products that are currently in the cart
    public void displayCart() {
        System.out.println("Products in cart: ");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + " (x" + quantity + ") costs " + (product.getUnitPrice() * quantity) + " LE");
        }
        System.out.println("Total = " + getTotal() + " LE");
    }
}
