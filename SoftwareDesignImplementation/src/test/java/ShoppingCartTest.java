import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test Product", "Description for Test Product", 9.99);

        cart.addProduct(product);

        assertEquals(1, cart.getItems().size());
        assertTrue(cart.getItems().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Product 1", "Description for Product 1", 19.99);
        Product product2 = new Product("Product 2", "Description for Product 2", 29.99);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertEquals(1, cart.getItems().size());
        assertFalse(cart.getItems().contains(product1));
        assertTrue(cart.getItems().contains(product2));
    }

    @Test
    public void testViewEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals("Items in your shopping cart:\nYour shopping cart is empty.\n", cart.viewCart());
    }

    @Test
    public void testViewNonEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Product 1", "Description for Product 1", 19.99);
        Product product2 = new Product("Product 2", "Description for Product 2", 29.99);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals("Items in your shopping cart:\nProduct 1 - $19.99\nProduct 2 - $29.99\n", cart.viewCart());
    }

    @Test
    public void testAddAndRemoveMultipleProducts() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Product 1", "Description for Product 1", 19.99);
        Product product2 = new Product("Product 2", "Description for Product 2", 29.99);
        Product product3 = new Product("Product 3", "Description for Product 3", 39.99);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.removeProduct(product2);

        assertEquals(2, cart.getItems().size());
        assertTrue(cart.getItems().contains(product1));
        assertFalse(cart.getItems().contains(product2));
        assertTrue(cart.getItems().contains(product3));
    }
}
