import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class VotingSystem {

    // Store registered users
    private Map<String, User> users = new HashMap<>();

    // Track whether each student has voted
    private Map<String, Boolean> userVotes = new HashMap<>();

    // Store candidate details
    private ArrayList<Candidate> candidates = new ArrayList<>();

    // Store candidate ID and total votes
    private Map<String, Integer> candidateVotes = new HashMap<>();

    // Constructor
    public VotingSystem() {

        candidates.add(new Candidate("C101", "Rahul"));
        candidates.add(new Candidate("C102", "Priya"));
        candidates.add(new Candidate("C103", "Arjun"));

        for (Candidate candidate : candidates) {
            candidateVotes.put(candidate.getCandidateId(), 0);
        }
    }

    // Register user
    public void registerUser(String username, String password) {

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }

        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User(username, password);

        users.put(username, user);
        userVotes.put(username, false);

        System.out.println("Registration Successful!");
    }

    // Login user
    public boolean loginUser(String username, String password) {

        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {

            System.out.println("Login Successful!");
            return true;
        }

        throw new IllegalArgumentException("Invalid Username or Password");
    }

    // Display candidates
    public void displayCandidates() {

        System.out.println("\n===== CANDIDATE LIST =====");

        for (Candidate candidate : candidates) {
            candidate.displayCandidate();
        }
    }

    // Cast vote
    public void castVote(String username, String candidateId) {

        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User not registered");
        }

        if (userVotes.get(username)) {
            throw new IllegalArgumentException("You have already voted!");
        }

        if (!candidateVotes.containsKey(candidateId)) {
            throw new IllegalArgumentException("Invalid Candidate ID");
        }

        int currentVotes = candidateVotes.get(candidateId);

        candidateVotes.put(candidateId, currentVotes + 1);

        userVotes.put(username, true);

        System.out.println("Your vote has been submitted successfully!");
    }

    // Display total votes
    public void displayTotalVotes() {

        int totalVotes = 0;

        System.out.println("\n===== VOTE COUNT =====");

        for (Candidate candidate : candidates) {

            int votes = candidateVotes.get(candidate.getCandidateId());

            System.out.println(candidate.getCandidateName()
                    + " : " + votes + " votes");

            totalVotes = totalVotes + votes;
        }

        System.out.println("Total Votes Cast: " + totalVotes);
    }

    // Display winner and runner-up
    public void displayResults() {

        ArrayList<Candidate> results = new ArrayList<>(candidates);

        // Sort candidates based on votes
        results.sort(
            Comparator.comparingInt(
                (Candidate c) -> candidateVotes.get(c.getCandidateId())
            ).reversed()
            .thenComparing(Candidate::getCandidateId)
        );

        System.out.println("\n===== ELECTION RESULTS =====");

        if (results.isEmpty()) {
            System.out.println("No candidates available");
            return;
        }

        Candidate winner = results.get(0);

        System.out.println("Winner: " + winner.getCandidateName());
        System.out.println("Votes: "
                + candidateVotes.get(winner.getCandidateId()));

        if (results.size() >= 2) {

            Candidate runnerUp = results.get(1);

            System.out.println("Runner-Up: "
                    + runnerUp.getCandidateName());

            System.out.println("Votes: "
                    + candidateVotes.get(runnerUp.getCandidateId()));
        }

        if (results.size() > 2) {

            System.out.println("\nOther Finalists:");

            for (int i = 2; i < results.size(); i++) {

                Candidate candidate = results.get(i);

                System.out.println(candidate.getCandidateName()
                        + " - "
                        + candidateVotes.get(candidate.getCandidateId())
                        + " votes");
            }
        }
    }
}
