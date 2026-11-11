package personalexpense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ExpenseService {

    ArrayList<Expense> expenses = new ArrayList<>();

    // Add Expense
    public void addExpense(Expense expense) {

        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

    // Delete Expense
    public void deleteExpense(int id) {

        boolean removed = expenses.removeIf(
            e -> e.getExpenseId() == id
        );

        if (removed) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Expense ID not found!");
        }
    }

    // Display All Expenses
    public void displayExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        for (Expense e : expenses) {
            e.displayExpense();
        }
    }

    // Calculate Total Expense
    public void calculateTotal() {

        double total = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        System.out.println("Total Expenses: " + total);
    }

    // Find Highest Expense
    public void highestExpense() {

        Expense highest = expenses.stream()
                .max(Comparator.comparingDouble(
                    Expense::getAmount))
                .orElse(null);

        if (highest == null) {
            System.out.println("No expenses available!");
        } else {
            System.out.println("Highest Expense:");
            highest.displayExpense();
        }
    }

    // Category Wise Expenses
    public void categoryWiseExpenses() {

        HashMap<Category, Double> categoryMap =
                expenses.stream()
                .collect(Collectors.groupingBy(
                    Expense::getCategory,
                    HashMap::new,
                    Collectors.summingDouble(
                        Expense::getAmount
                    )
                ));

        if (categoryMap.isEmpty()) {
            System.out.println("No expenses available!");
            return;
        }

        System.out.println("Category Wise Expenses:");

        for (Map.Entry<Category, Double> entry :
                categoryMap.entrySet()) {

            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}