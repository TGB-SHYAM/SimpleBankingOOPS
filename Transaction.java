import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single transaction with a type, amount, and timestamp.
 * This is a simple data object (POJO) used by the Account class.
 */
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    /**
     * Constructor for a new Transaction.
     * @param type The type of transaction (e.g., "Deposit").
     * @param amount The amount involved in the transaction.
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Returns a formatted string representation of the transaction.
     * @return A string with transaction details.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
        return String.format("Timestamp: %s, Type: %-10s, Amount: $%.2f", 
                             formattedTimestamp, type, amount);
    }
}

