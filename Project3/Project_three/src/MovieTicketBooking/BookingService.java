package MovieTicketBooking;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BookingService {

    private boolean[][] seats = new boolean[5][5];

    private final double WEEKDAY_PRICE = 150;
    private final double WEEKEND_PRICE = 200;

    // Show available seats
    public void showAvailableSeats() {

        System.out.println("\n===== THEATRE SEATS =====");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[O] ");
                }
            }

            System.out.println();
        }

        System.out.println("[O] Available  [X] Booked");
    }

    // Check weekend pricing
    public double calculateTicketPrice() {

        DayOfWeek day = LocalDate.now().getDayOfWeek();

        if (day == DayOfWeek.SATURDAY ||
            day == DayOfWeek.SUNDAY) {

            return WEEKEND_PRICE;
        }

        return WEEKDAY_PRICE;
    }

    // Book Ticket
    public void bookTicket(int row, int column, String coupon) {

        if (row < 1 || row > 5 || column < 1 || column > 5) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (seats[row - 1][column - 1]) {
            System.out.println("Seat is already booked!");
            return;
        }

        double price = calculateTicketPrice();

        // Apply discount coupon
        if (coupon.equalsIgnoreCase("MOVIE10")) {

            price = price - (price * 10 / 100);

            System.out.println("10% discount applied!");
        } else if (!coupon.equalsIgnoreCase("NO")) {
            System.out.println("Invalid coupon. No discount applied.");
        }

        seats[row - 1][column - 1] = true;

        System.out.println("Ticket booked successfully!");
        System.out.println("Seat: Row " + row + ", Column " + column);
        System.out.println("Ticket Price: Rs. " + price);
    }

    // Cancel Ticket
    public void cancelTicket(int row, int column) {

        if (row < 1 || row > 5 || column < 1 || column > 5) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (!seats[row - 1][column - 1]) {
            System.out.println("This seat is not booked!");
            return;
        }

        seats[row - 1][column - 1] = false;

        System.out.println("Ticket cancelled successfully!");
    }
}
