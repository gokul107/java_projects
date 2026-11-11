
package InventoryManagementSystem;

public class Bill {

    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private double total;

    // Constructor
    public Bill(int productId, String productName,
                int quantity, double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;

        this.total = quantity * price;
    }

    // Display Bill
    public void displayBill() {

        System.out.println("\n========== BILL ==========");

        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : Rs. " + price);
        System.out.println("Total Amount : Rs. " + total);

        System.out.println("==========================");
    }

    public double getTotal() {
        return total;
    }
}
