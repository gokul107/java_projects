
package InventoryManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService service = new InventoryService();

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Product");
            System.out.println("2. Search Product By ID");
            System.out.println("3. Update Product Price");
            System.out.println("4. Add Stock");
            System.out.println("5. Sell Product");
            System.out.println("6. Show All Products");
            System.out.println("7. Display Low Stock Products");
            System.out.println("8. Delete Product");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.println("\nSelect Category:");

                        Category[] categories = Category.values();

                        for (int i = 0; i < categories.length; i++) {

                            System.out.println(
                                (i + 1) + ". " + categories[i]
                            );
                        }

                        System.out.print("Enter Category Number: ");
                        int categoryChoice = sc.nextInt();

                        if (categoryChoice < 1 ||
                            categoryChoice > categories.length) {

                            throw new IllegalArgumentException(
                                "Invalid category!"
                            );
                        }

                        Category category =
                                categories[categoryChoice - 1];

                        System.out.print("Enter Product Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Enter Initial Stock: ");
                        int stock = sc.nextInt();

                        Product product = new Product(
                            id, name, category, price, stock
                        );

                        service.addProduct(product);

                        break;

                    case 2:

                        System.out.print("Enter Product ID: ");

                        int searchId = sc.nextInt();

                        service.searchProduct(searchId);

                        break;

                    case 3:

                        System.out.print("Enter Product ID: ");

                        int priceId = sc.nextInt();

                        System.out.print("Enter New Price: ");

                        double newPrice = sc.nextDouble();

                        service.updatePrice(priceId, newPrice);

                        break;

                    case 4:

                        System.out.print("Enter Product ID: ");

                        int stockId = sc.nextInt();

                        System.out.print("Enter Quantity To Add: ");

                        int quantity = sc.nextInt();

                        service.addStock(stockId, quantity);

                        break;

                    case 5:

                        System.out.print("Enter Product ID: ");

                        int sellId = sc.nextInt();

                        System.out.print("Enter Quantity To Sell: ");

                        int sellQuantity = sc.nextInt();

                        Bill bill = service.sellProduct(
                            sellId, sellQuantity
                        );

                        bill.displayBill();

                        break;

                    case 6:

                        service.displayAllProducts();

                        break;

                    case 7:

                        service.lowStockProducts();

                        break;

                    case 8:

                        System.out.print("Enter Product ID: ");

                        int deleteId = sc.nextInt();

                        service.deleteProduct(deleteId);

                        break;

                    case 9:

                        System.out.println(
                            "Thank you for using Inventory Management System!"
                        );

                        sc.close();

                        return;

                    default:

                        System.out.println("Invalid Choice!");

                }

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }
        }
    }
}
