import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VotingSystem voting = new VotingSystem();

        String loggedInUser = null;

        while (true) {

            System.out.println("\n===== ONLINE VOTING SYSTEM =====");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Candidates");
            System.out.println("4. Cast Vote");
            System.out.println("5. View Total Votes");
            System.out.println("6. Display Election Results");
            System.out.println("7. Logout");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        voting.registerUser(username, password);
                        break;

                    case 2:

                        System.out.print("Enter Username: ");
                        String loginName = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String loginPassword = sc.nextLine();

                        if (voting.loginUser(loginName, loginPassword)) {
                            loggedInUser = loginName;
                        }
                        break;

                    case 3:

                        voting.displayCandidates();
                        break;

                    case 4:

                        if (loggedInUser == null) {
                            throw new IllegalArgumentException(
                                "Please login before voting"
                            );
                        }

                        voting.displayCandidates();

                        System.out.print("Enter Candidate ID: ");
                        String candidateId = sc.nextLine();

                        voting.castVote(loggedInUser, candidateId);
                        break;

                    case 5:

                        voting.displayTotalVotes();
                        break;

                    case 6:

                        voting.displayResults();
                        break;

                    case 7:

                        if (loggedInUser == null) {
                            System.out.println("No user is currently logged in");
                        } else {
                            System.out.println(loggedInUser + " logged out successfully");
                            loggedInUser = null;
                        }
                        break;

                    case 8:

                        System.out.println("Thank you for using Online Voting System!");
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
