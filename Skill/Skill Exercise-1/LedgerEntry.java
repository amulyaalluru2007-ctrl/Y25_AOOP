import java.time.LocalDateTime;

class LedgerEntry {

    private final String transactionId;
    private final String transactionType;
    private final Money amount;
    private final String timestamp;

    // Constructor
    LedgerEntry(String transactionId,
                String transactionType,
                Money amount) {

        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;

        timestamp = LocalDateTime.now().toString();
    }

    // Getters
    String getTransactionId() {
        return transactionId;
    }

    String getTransactionType() {
        return transactionType;
    }

    Money getAmount() {
        return amount;
    }

    String getTimestamp() {
        return timestamp;
    }

    // Display transaction
    void display() {

        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Timestamp: " + timestamp);
    }
}