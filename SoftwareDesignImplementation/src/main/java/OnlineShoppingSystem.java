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

    // Dependency Injection for items
    public ShoppingCart(List<Product> items) {
        this.items = items;
    }

    // Add product to shopping cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Remove product from shopping cart and return it
    public Product removeProduct(Product product) {
        if (!items.isEmpty()) {
            items.remove(product);
            return product;
        } else {
            throw new EmptyCartException("The shopping cart is empty. Cannot remove a product.");
        }
    }

    // View contents of shopping cart
    public void viewCart() {
        System.out.println("Items in your shopping cart:");
        for (Product item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    // Get items in the shopping cart
    public Collection<Product> getItems() {
        return items;
    }
}

// Custom Exception for an empty shopping cart
class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}

// Main class to run the program
public class OnlineShoppingSystem {

    public static void main(String[] args) {
        // Sample products
        Product product1 = new Product("Product 1", "Description for Product 1", 19.99);
        Product product2 = new Product("Product 2", "Description for Product 2", 29.99);

        // Initialize shopping cart with ArrayList
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        ShoppingCart cart = new ShoppingCart(productList);

        // View contents of shopping cart
        cart.viewCart();

        // Remove a product from shopping cart
        Product removedProduct = cart.removeProduct(product1);
        System.out.println("Removed Product: " + removedProduct.getName());

        // View updated contents of shopping cart
        cart.viewCart();
    }
}
