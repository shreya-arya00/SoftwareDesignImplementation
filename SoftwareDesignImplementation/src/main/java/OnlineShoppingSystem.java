import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Product class representing individual products
class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

// ShoppingCart class representing the user's shopping cart
class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Add product to shopping cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Remove product from shopping cart
    public void removeProduct(Product product) {
        items.remove(product);
    }

    // View contents of shopping cart
    public Object viewCart() {
        System.out.println("Items in your shopping cart:");
        for (Product item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        return null;
    }

    public Collection<Object> getItems() {
    return null;}
}

// Main class to run the program
public class OnlineShoppingSystem {

    public static void main(String[] args) {
        // Sample products
        Product product1 = new Product("Product 1", "Description for Product 1", 19.99);
        Product product2 = new Product("Product 2", "Description for Product 2", 29.99);

        // Initialize shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add products to shopping cart
        cart.addProduct(product1);
        cart.addProduct(product2);

        // View contents of shopping cart
        cart.viewCart();

        // Remove a product from shopping cart
        cart.removeProduct(product1);

        // View updated contents of shopping cart
        cart.viewCart();
    }
}
