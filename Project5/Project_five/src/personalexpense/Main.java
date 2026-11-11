package personalexpense;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseService service = new ExpenseService();

        int id = 1;

        while (true) {

            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");

            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. Display All Expenses");
            System.out.println("4. Calculate Total Expense");
            System.out.println("5. Find Highest Expense");
            System.out.println("6. Category Wise Expenses");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println(
                            "Amount must be greater than zero!"
                        );
                        break;
                    }

                    System.out.println("Select Category:");

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

                        System.out.println("Invalid Category!");
                        break;
                    }

                    Category category =
                            categories[categoryChoice - 1];

                    Expense expense = new Expense(
                        id++, description, amount, category
                    );

                    service.addExpense(expense);

                    break;

                case 2:

                    System.out.print("Enter Expense ID: ");

                    int deleteId = sc.nextInt();

                    service.deleteExpense(deleteId);

                    break;

                case 3:

                    service.displayExpenses();

                    break;

                case 4:

                    service.calculateTotal();

                    break;

                case 5:

                    service.highestExpense();

                    break;

                case 6:

                    service.categoryWiseExpenses();

                    break;

                case 7:

                    System.out.println("Thank you!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}