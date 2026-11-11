package LibraryManagement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library = new LibraryService();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Check Book Availability");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Generate Library Report");
            System.out.println("8. Due Date Reminder");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    library.addBook(bookId, bookName, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    String searchId = sc.nextLine();

                    if (library.searchBook(searchId) != null) {
                        library.searchBook(searchId).displayBook();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    String availabilityId = sc.nextLine();

                    library.checkAvailability(availabilityId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    String issueId = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    library.issueBook(issueId, studentId);
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    String returnId = sc.nextLine();

                    library.returnBook(returnId);
                    break;

                case 7:
                    library.generateReport();
                    break;

                case 8:
                    library.dueDateReminder();
                    break;

                case 9:
                    System.out.println("Thank you for using Library Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
