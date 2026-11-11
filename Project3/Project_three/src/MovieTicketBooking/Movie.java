package MovieTicketBooking;

public class Movie {

    private String movieName;
    private double rating;

    public Movie(String movieName, double rating) {
        this.movieName = movieName;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getRating() {
        return rating;
    }

    public void displayMovieDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Movie Rating: " + rating + "/10");
    }
}
