package scenario_based.digital_wallet_system;

public class WalletToWalletTransfer implements TransferService {
    @Override
    public void transfer(double amount, Wallet sender, Wallet receiver) throws InsufficientBalanceException {
        System.out.println("Initiating Wallet-to-Wallet Transfer");
        sender.withdraw(amount); 
        receiver.deposit(amount);
        System.out.println("Transfer Complete.");
    }
}
