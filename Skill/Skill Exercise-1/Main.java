public class Main {

    public static void main(String[] args) {

        // Create overdraft limit
        Money limit = new Money(500000, "INR");

        // Create accounts
        BankAccount a1 = new BankAccount("1001", limit);
        BankAccount a2 = new BankAccount("1002", limit);

        // Deposit
        System.out.println("---- DEPOSIT ----");

        a1.deposit(new Money(1000000, "INR"));
        a2.deposit(new Money(500000, "INR"));

        System.out.println("Account 1: " + a1.getBalance());
        System.out.println("Account 2: " + a2.getBalance());

        // Withdraw
        System.out.println("\n---- WITHDRAW ----");

        a1.withdraw(new Money(200000, "INR"));

        System.out.println("Balance: " + a1.getBalance());

        // Transfer
        System.out.println("\n---- FUND TRANSFER ----");

        FundTransfer f1 = new FundTransfer(
            "T101",
            a1,
            a2,
            new Money(300000, "INR")
        );

        f1.transfer();

        System.out.println("Account 1: " + a1.getBalance());
        System.out.println("Account 2: " + a2.getBalance());

        // Freeze
        System.out.println("\n---- FREEZE ----");

        a1.freeze();

        a1.withdraw(new Money(100000, "INR"));

        // Unfreeze
        System.out.println("\n---- UNFREEZE ----");

        a1.unfreeze();

        // Ledger
        System.out.println("\n---- LEDGER ----");

        LedgerEntry l1 = new LedgerEntry(
            "L101",
            "DEPOSIT",
            new Money(1000000, "INR")
        );

        l1.display();

        // Close account demonstration
        System.out.println("\n---- ACCOUNT STATUS ----");

        System.out.println("Account 1: " + a1.getStatus());
        System.out.println("Account 2: " + a2.getStatus());
    }
}