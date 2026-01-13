package scenario_based.digital_wallet_system;

public class WalletToBankTransfer implements TransferService {
    private static final double BANK_FEE_PERCENT = 0.02;

    @Override
    public void transfer(double amount, Wallet sender, Wallet receiver) throws InsufficientBalanceException {
        double fee = amount * BANK_FEE_PERCENT;
        double totalDeduction = amount + fee;
        System.out.println("Initiating Bank Transfer (Fee: $" + fee + ")");
        if (sender.getBalance() < totalDeduction) {
            throw new InsufficientBalanceException("Insufficient funds to cover amount + bank fee.");
        }
        sender.withdraw(totalDeduction);
        System.out.println("Sent $" + amount + " to Bank Account. Fee deducted.");
    }
}
