class BankAccount {

    private final String accountNumber;
    private Money balance;
    private final Money overdraftLimit;
    private AccountStatus status;

    // Constructor
    BankAccount(String accountNumber, Money overdraftLimit) {

        this.accountNumber = accountNumber;
        this.overdraftLimit = overdraftLimit;

        balance = new Money(0, "INR");

        status = AccountStatus.ACTIVE;
    }

    // Deposit
    void deposit(Money amount) {

        if (status != AccountStatus.ACTIVE) {
            System.out.println("Account is not active");
            return;
        }

        if (!amount.isPositive()) {
            System.out.println("Invalid amount");
            return;
        }

        balance = balance.add(amount);

        System.out.println("Deposit successful");
    }

    // Withdraw
    void withdraw(Money amount) {

        if (status != AccountStatus.ACTIVE) {
            System.out.println("Account is not active");
            return;
        }

        if (!amount.isPositive()) {
            System.out.println("Invalid amount");
            return;
        }

        long availableBalance =
            balance.getAmountInPaise() +
            overdraftLimit.getAmountInPaise();

        if (amount.getAmountInPaise() > availableBalance) {
            System.out.println("Overdraft limit exceeded");
            return;
        }

        balance = new Money(
            balance.getAmountInPaise() -
            amount.getAmountInPaise(),
            "INR"
        );

        System.out.println("Withdrawal successful");
    }

    // Freeze
    void freeze() {

        status = AccountStatus.FROZEN;

        System.out.println("Account frozen");
    }

    // Unfreeze
    void unfreeze() {

        if (status == AccountStatus.FROZEN) {

            status = AccountStatus.ACTIVE;

            System.out.println("Account unfrozen");
        }
    }

    // Close
    void close() {

        if (balance.getAmountInPaise() == 0) {

            status = AccountStatus.CLOSED;

            System.out.println("Account closed");
        }
        else {
            System.out.println("Balance must be zero to close account");
        }
    }

    // Get balance
    Money getBalance() {
        return balance;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    AccountStatus getStatus() {
        return status;
    }
}