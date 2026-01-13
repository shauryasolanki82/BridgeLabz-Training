package scenario_based.digital_wallet_system;

public class Main {
    public static void main(String[] args) {
        Wallet w1 = new Wallet("W001", 500.00);
        Wallet w2 = new Wallet("W002", 100.00);
        User alice = new User("Anuj", w1);
        User bob = new User("Subhash", w2);
        TransferService p2p = new WalletToWalletTransfer();
        TransferService toBank = new WalletToBankTransfer();

        try {
            System.out.println("Scenario 1: P2P Transfer");
            p2p.transfer(100, alice.getWallet(), bob.getWallet());
            System.out.println("Scenario 2: High Value Bank Transfer");
            toBank.transfer(5000, bob.getWallet(), null); 
        } catch (InsufficientBalanceException e) {
            System.out.println("TRANSACTION FAILED: " + e.getMessage());
        }
        
        try {
            System.out.println("Scenario 3: Bank Transfer with Fee");
            toBank.transfer(100, alice.getWallet(), null);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        alice.getWallet().showHistory();
        bob.getWallet().showHistory();
    }
}
