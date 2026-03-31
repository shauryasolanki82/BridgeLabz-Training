package scenario_based.online_voting_system;

public interface ElectionService {
    void registerVoter(Voter v);
    void addCandidate(Candidate c);
    void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    void displayResults();
}
