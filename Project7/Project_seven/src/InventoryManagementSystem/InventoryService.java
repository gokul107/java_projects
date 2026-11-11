
package InventoryManagementSystem;

import java.util.HashMap;

public class InventoryService {

    private HashMap<Integer, Product> products =
            new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        if (products.containsKey(product.getProductId())) {

            throw new IllegalArgumentException(
                "Product ID already exists!"
            );
        }

        products.put(product.getProductId(), product);

        System.out.println("Product added successfully!");
    }

    // Search Product By ID
    public Product searchProduct(int id) {

        Product product = products.get(id);

        if (product == null) {

            System.out.println("Product not found!");

        } else {

            product.displayProduct();
        }

        return product;
    }

    // Update Product Price
    public void updatePrice(int id, double price) {

        Product product = products.get(id);

        if (product == null) {

            System.out.println("Product not found!");
            return;
        }

        product.setPrice(price);

        System.out.println("Price updated successfully!");
    }

    // Add Stock
    public void addStock(int id, int quantity) {

        Product product = products.get(id);

        if (product == null) {

            System.out.println("Product not found!");
            return;
        }

        product.addStock(quantity);
    }

    // Sell Product
    public Bill sellProduct(int id, int quantity) {

        Product product = products.get(id);

        if (product == null) {

            throw new IllegalArgumentException(
                "Product not found!"
            );
        }

        // Reduce available stock
        product.sellProduct(quantity);

        // Generate bill
        Bill bill = new Bill(
            product.getProductId(),
            product.getProductName(),
            quantity,
            product.getPrice()
        );

        return bill;
    }

    // Display All Products
    public void displayAllProducts() {

        if (products.isEmpty()) {

            System.out.println("No products available!");
            return;
        }

        for (Product product : products.values()) {

            product.displayProduct();
        }
    }

    // Display Products With Stock Below 5
    public void lowStockProducts() {

        boolean found = false;

        System.out.println("\nProducts With Low Stock:");

        for (Product product : products.values()) {

            if (product.getStock() < 5) {

                product.displayProduct();
                found = true;
            }
        }

        if (!found) {

            System.out.println("No low stock products!");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        Product removed = products.remove(id);

        if (removed != null) {

            System.out.println("Product deleted successfully!");

        } else {

            System.out.println("Product not found!");
        }
    }

    // Calculate Bill Total
    public void calculateBillTotal(Bill bill) {

        System.out.println(
            "Bill Total: Rs. " + bill.getTotal()
        );
    }
}
