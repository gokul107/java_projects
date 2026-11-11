package personalexpense;

import java.time.LocalDate;

public class Expense {

    private int expenseId;
    private String description;
    private double amount;
    private Category category;
    private LocalDate date;

    public Expense(int expenseId, String description,
                   double amount, Category category) {

        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = LocalDate.now();
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void displayExpense() {

        System.out.println("Expense ID : " + expenseId);
        System.out.println("Description: " + description);
        System.out.println("Amount     : " + amount);
        System.out.println("Category   : " + category);
        System.out.println("Date       : " + date);

        System.out.println("--------------------------");
    }
}