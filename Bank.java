import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of bank accounts.
 * This class demonstrates Abstraction by hiding the internal details of how
 * accounts are stored and managed (using a HashMap).
 * It also shows Composition, as a Bank "has-a" collection of Accounts.
 */
public class Bank {
    private Map<String, Account> accounts;
    private int nextAccountNumber = 1001;

    /**
     * Constructor to initialize the Bank.
     */
    public Bank() {
        this.accounts = new HashMap<>();
    }

    /**
     * Creates a new account and adds it to the bank.
     * @param accountHolderName The name of the new account holder.
     * @param initialDeposit The initial deposit amount.
     * @return The newly created Account object.
     */
    public Account createAccount(String accountHolderName, double initialDeposit) {
        String accountNumber = String.valueOf(nextAccountNumber++);
        Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully! Your new account number is: " + accountNumber);
        return newAccount;
    }

    /**
     * Finds and returns an account by its account number.
     * @param accountNumber The account number to search for.
     * @return The Account object if found, otherwise null.
     */
    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * Transfers money from one account to another.
     * @param fromAccountNumber The account number to transfer from.
     * @param toAccountNumber The account number to transfer to.
     * @param amount The amount to transfer.
     */
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount == null) {
            System.out.println("Error: Source account " + fromAccountNumber + " not found.");
            return;
        }
        if (toAccount == null) {
            System.out.println("Error: Destination account " + toAccountNumber + " not found.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return;
        }
        
        if (fromAccount.getBalance() < amount) {
             System.out.println("Insufficient funds for transfer.");
             return;
        }

        // Perform the transfer
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transfer of $" + amount + " from " + fromAccountNumber + " to " + toAccountNumber + " was successful.");
    }
}
