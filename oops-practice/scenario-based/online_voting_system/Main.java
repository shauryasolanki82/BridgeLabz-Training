package scenario_based.online_voting_system;

public class Main {
    public static void main(String[] args) {
        ElectionService election = new VotingSystem();
        election.addCandidate(new Candidate(1, "BJP (Party A)"));
        election.addCandidate(new Candidate(2, "Congress (Party B)"));
        Voter v1 = new Voter(101, "Anuj");
        Voter v2 = new Voter(102, "Subhash");
        Voter v3 = new Voter(103, "Vikash");
        election.registerVoter(v1);
        election.registerVoter(v2);
        election.registerVoter(v3);

        System.out.println("Voting Started");

        try {
            election.castVote(101, 1);
            election.castVote(102, 2);
            System.out.println("Anuj attempting to vote again...");
            election.castVote(101, 2);

        } catch (DuplicateVoteException e) {
            System.out.println("FRAUD ALERT: " + e.getMessage());
        }
        try {
            election.castVote(103, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        election.displayResults();
    }
}
