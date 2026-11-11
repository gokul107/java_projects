package LibraryManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();

    // Stores issued books using Book ID as the key
    private HashMap<String, Book> issuedBooks = new HashMap<>();

    // Stores issue dates and due dates using Book ID
    private HashMap<String, IssueRecord> issueRecords = new HashMap<>();

    private Librarian librarian = new Librarian("Gokul");

    private final double FINE_PER_DAY = 5.0;

    // Add Book
    public void addBook(String bookId, String bookName, String author) {

        if (searchBook(bookId) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        Book book = new Book(bookId, bookName, author);
        books.add(book);

        System.out.println("Book added successfully!");
    }

    // Search Book
    public Book searchBook(String bookId) {

        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }

        return null;
    }

    // Display All Books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Check Book Availability
    public void checkAvailability(String bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isAvailable()) {
            System.out.println("Book is available.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    // Issue Book
    public void issueBook(String bookId, String studentId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already issued!");
            return;
        }

        boolean approved = librarian.approveBookIssue(bookId);

        if (approved) {
            book.setAvailable(false);
            issuedBooks.put(bookId, book);

            IssueRecord record = new IssueRecord(studentId);
            issueRecords.put(bookId, record);

            System.out.println("Book issued successfully!");
            System.out.println("Issue Date: " + record.getIssueDate());
            System.out.println("Due Date: " + record.getDueDate());
        }
    }

    // Calculate Fine
    public double calculateFine(String bookId) {

        IssueRecord record = issueRecords.get(bookId);

        if (record == null) {
            return 0;
        }

        LocalDate today = LocalDate.now();
        LocalDate dueDate = record.getDueDate();

        if (today.isAfter(dueDate)) {
            long lateDays = ChronoUnit.DAYS.between(dueDate, today);
            return lateDays * FINE_PER_DAY;
        }

        return 0;
    }

    // Return Book
    public void returnBook(String bookId) {

        Book book = issuedBooks.get(bookId);

        if (book == null) {
            System.out.println("This book is not currently issued.");
            return;
        }

        double fine = calculateFine(bookId);

        System.out.println("Fine Amount: Rs. " + fine);

        if (fine > 0) {
            librarian.collectFine(fine);
        } else {
            System.out.println("No fine. Book returned on time.");
        }

        book.setAvailable(true);

        issuedBooks.remove(bookId);
        issueRecords.remove(bookId);

        System.out.println("Book returned successfully!");
    }

    // Generate Library Report
    public void generateReport() {

        System.out.println("\n===== LIBRARY REPORT =====");
        System.out.println("Total Books: " + books.size());
        System.out.println("Issued Books: " + issuedBooks.size());
        System.out.println("Available Books: "
                + (books.size() - issuedBooks.size()));

        System.out.println("\nCurrently Issued Books:");

        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            for (Map.Entry<String, Book> entry : issuedBooks.entrySet()) {
                System.out.println(entry.getKey() + " - "
                        + entry.getValue().getBookName());
            }
        }
    }

    // Due Date Reminder
    public void dueDateReminder() {

        System.out.println("\n===== DUE DATE REMINDERS =====");

        if (issueRecords.isEmpty()) {
            System.out.println("No pending book returns.");
            return;
        }

        LocalDate today = LocalDate.now();

        for (Map.Entry<String, IssueRecord> entry
                : issueRecords.entrySet()) {

            String bookId = entry.getKey();
            IssueRecord record = entry.getValue();

            System.out.println("Book ID: " + bookId);
            System.out.println("Student ID: " + record.getStudentId());
            System.out.println("Due Date: " + record.getDueDate());

            if (today.isAfter(record.getDueDate())) {
                System.out.println("Status: Overdue");
                System.out.println("Current Fine: Rs. "
                        + calculateFine(bookId));
            } else if (today.equals(record.getDueDate())) {
                System.out.println("Status: Due today!");
            } else {
                System.out.println("Status: Return before due date");
            }

            System.out.println("-------------------------");
        }
    }
}
