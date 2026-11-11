package LibraryManagement;

public class Librarian {

    private String librarianName;

    public Librarian(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public boolean approveBookIssue(String bookId) {
        System.out.println("Librarian " + librarianName
                + " approved the issue of book: " + bookId);
        return true;
    }

    public void collectFine(double fine) {
        System.out.println("Fine collected: Rs. " + fine);
    }
}
