package MovieTicketBooking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Movie movie = new Movie("Pushpa 2", 8.5);

        BookingService booking = new BookingService();

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Movie Details and Rating");
            System.out.println("2. Show Available Seats");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");

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
                    movie.displayMovieDetails();
                    break;

                case 2:
                    booking.showAvailableSeats();
                    break;

                case 3:
                    System.out.print("Enter Row Number (1-5): ");
                    int row = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Column Number (1-5): ");
                    int column = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Coupon Code (MOVIE10 or NO): ");
                    String coupon = sc.nextLine();

                    booking.bookTicket(row, column, coupon);
                    break;

                case 4:
                    System.out.print("Enter Row Number: ");
                    int cancelRow = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Column Number: ");
                    int cancelColumn = Integer.parseInt(sc.nextLine());

                    booking.cancelTicket(cancelRow, cancelColumn);
                    break;

                case 5:
                    System.out.println("Thank you for booking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
