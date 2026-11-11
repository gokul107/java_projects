
package InventoryManagementSystem;

public class Product {

    private int productId;
    private String productName;
    private Category category;
    private double price;
    private int stock;

    // Constructor
    public Product(int productId, String productName,
                   Category category, double price, int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;

        if (price <= 0) {
            throw new IllegalArgumentException(
                "Price must be greater than zero!"
            );
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                "Stock cannot be negative!"
            );
        }

        this.price = price;
        this.stock = stock;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Update Price
    public void setPrice(double price) {

        if (price <= 0) {
            throw new IllegalArgumentException(
                "Price must be greater than zero!"
            );
        }

        this.price = price;
    }

    // Add Stock
    public void addStock(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero!"
            );
        }

        stock += quantity;

        System.out.println("Stock added successfully!");
    }

    // Sell Product
    public void sellProduct(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero!"
            );
        }

        if (stock == 0) {
            throw new IllegalArgumentException(
                "Product is out of stock!"
            );
        }

        if (quantity > stock) {
            throw new IllegalArgumentException(
                "Insufficient stock available!"
            );
        }

        stock -= quantity;

        System.out.println("Product sold successfully!");
    }

    // Display Product
    public void displayProduct() {

        System.out.println("\nProduct ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
        System.out.println("Price        : Rs. " + price);
        System.out.println("Stock        : " + stock);

        System.out.println("--------------------------------");
    }
}
