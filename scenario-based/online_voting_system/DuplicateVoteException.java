package scenario_based.online_voting_system;

public class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}
