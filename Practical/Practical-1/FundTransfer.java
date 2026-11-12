class FundTransfer {

    private final String transferId;
    private final BankAccount source;
    private final BankAccount destination;
    private final Money amount;

    // Constructor
    FundTransfer(String transferId,
                 BankAccount source,
                 BankAccount destination,
                 Money amount) {

        this.transferId = transferId;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    // Transfer method
    void transfer() {

        if (source.getStatus() != AccountStatus.ACTIVE ||
            destination.getStatus() != AccountStatus.ACTIVE) {

            System.out.println("Both accounts must be active");
            return;
        }

        if (!amount.isPositive()) {
            System.out.println("Invalid transfer amount");
            return;
        }

        if (!source.getBalance().getCurrency().equals(
            destination.getBalance().getCurrency())) {

            System.out.println("Currency mismatch");
            return;
        }

        // Withdraw from source
        long oldSourceBalance =
            source.getBalance().getAmountInPaise();

        source.withdraw(amount);

        // Check whether withdrawal succeeded
        if (source.getBalance().getAmountInPaise() ==
            oldSourceBalance - amount.getAmountInPaise()) {

            // Deposit into destination
            destination.deposit(amount);

            System.out.println("Transfer successful");
            System.out.println("Transfer ID: " + transferId);
        }
        else {
            System.out.println("Transfer failed");
        }
    }
}