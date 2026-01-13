package scenario_based.online_voting_system;
import java.util.*;

public class VotingSystem implements ElectionService {
    private List<Voter> voters;
    private List<Candidate> candidates;

    public VotingSystem() {
        this.voters = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    @Override
    public void registerVoter(Voter v) {
        voters.add(v);
        System.out.println("Voter Registered: " + v.getName());
    }

    @Override
    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    @Override
    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter currentVoter = null;
        for (Voter v : voters) {
            if (v.getVoterId() == voterId) {
                currentVoter = v;
                break;
            }
        }
        if (currentVoter == null) {
            System.out.println("Voter ID " + voterId + " not found.");
            return;
        }
        if (currentVoter.hasVoted()) {
            throw new DuplicateVoteException("Voter " + currentVoter.getName() + " has already cast a vote!");
        }
        Candidate chosenCandidate = null;
        for (Candidate c : candidates) {
            if (c.getId() == candidateId) {
                chosenCandidate = c;
                break;
            }
        }
        if (chosenCandidate == null) {
            System.out.println("Candidate ID " + candidateId + " invalid.");
            return;
        }
        chosenCandidate.incrementVote();
        currentVoter.markAsVoted();
        System.out.println("Vote Cast Successfully by " + currentVoter.getName());
    }

    @Override
    public void displayResults() {
        System.out.println("Election Results");
        Candidate winner = null;
        int maxVotes = -1;

        for (Candidate c : candidates) {
            System.out.println(c.getName() + ": " + c.getVoteCount() + " votes");
            if (c.getVoteCount() > maxVotes) {
                maxVotes = c.getVoteCount();
                winner = c;
            }
        }
        
        if (winner != null) {
            System.out.println("Current Winner: " + winner.getName());
        }
    }
}
