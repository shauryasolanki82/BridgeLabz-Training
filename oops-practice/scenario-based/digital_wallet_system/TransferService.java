package scenario_based.digital_wallet_system;

public interface TransferService {
    void transfer(double amount, Wallet sender, Wallet receiver) throws InsufficientBalanceException;
}
