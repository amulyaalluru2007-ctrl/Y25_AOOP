class Money {

    private final long amountInPaise;
    private final String currency;

    // Constructor
    Money(long amountInPaise, String currency) {

        if (amountInPaise < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        this.amountInPaise = amountInPaise;
        this.currency = currency;
    }

    // Addition
    Money add(Money other) {

        return new Money(
            this.amountInPaise + other.amountInPaise,
            currency
        );
    }

    // Subtraction
    Money subtract(Money other) {

        if (this.amountInPaise < other.amountInPaise) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        return new Money(
            this.amountInPaise - other.amountInPaise,
            currency
        );
    }

    // Check positive amount
    boolean isPositive() {
        return amountInPaise > 0;
    }

    // Getters
    long getAmountInPaise() {
        return amountInPaise;
    }

    String getCurrency() {
        return currency;
    }

    public String toString() {
        return currency + " " + (amountInPaise / 100.0);
    }
}