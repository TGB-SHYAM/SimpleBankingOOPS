import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single bank account, encapsulating account details and operations.
 * This class demonstrates Encapsulation by keeping the balance private and only
 * allowing modifications through deposit() and withdraw() methods.
 */
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactionHistory;

    /**
     * Constructor to create a new Account.
     * @param accountNumber The unique number for the account.
     * @param accountHolderName The name of the account holder.
     * @param initialDeposit The initial amount to open the account with.
     */
    public Account(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        // Record the initial deposit
        if (initialDeposit > 0) {
            recordTransaction("Initial Deposit", initialDeposit);
        }
    }

    /**
     * Deposits a specified amount into the account.
     * The amount must be positive.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposit", amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    /**
     * Withdraws a specified amount from the account.
     * The amount must be positive and cannot exceed the current balance.
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance is $" + balance);
        } else {
            balance -= amount;
            recordTransaction("Withdrawal", amount);
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    /**
     * Records a transaction and adds it to the history.
     * @param type The type of transaction (e.g., "Deposit").
     * @param amount The amount of the transaction.
     */
    private void recordTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount);
        transactionHistory.add(transaction);
    }

    /**
     * Prints the transaction history for this account.
     */
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // --- Getters ---

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}
