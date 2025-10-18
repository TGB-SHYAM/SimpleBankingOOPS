import java.util.Scanner;

/**
 * The main driver class for the banking application.
 * Provides a command-line interface for users to interact with the system.
 */
public class BankSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("--- Welcome to the Simple Banking System! ---");

        while (true) {
            printMenu();
            System.out.print("Please choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createAccount(scanner, bank);
                    break;
                case "2":
                    performDeposit(scanner, bank);
                    break;
                case "3":
                    performWithdrawal(scanner, bank);
                    break;
                case "4":
                    checkBalance(scanner, bank);
                    break;
                case "5":
                    viewTransactionHistory(scanner, bank);
                    break;
                case "6":
                    System.out.println("Thank you for using the Simple Banking System. Goodbye!");
                    scanner.close();
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); // Add a blank line for better readability
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Create a new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check balance");
        System.out.println("5. View transaction history");
        System.out.println("6. Exit");
    }

    private static void createAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: $");
        double initialDeposit = getValidDouble(scanner);
        scanner.nextLine(); // Consume the rest of the line

        bank.createAccount(name, initialDeposit);
    }

    private static void performDeposit(Scanner scanner, Bank bank) {
        Account account = findAccount(scanner, bank);
        if (account != null) {
            System.out.print("Enter amount to deposit: $");
            double amount = getValidDouble(scanner);
            scanner.nextLine(); // Consume the rest of the line
            account.deposit(amount);
        }
    }

    private static void performWithdrawal(Scanner scanner, Bank bank) {
        Account account = findAccount(scanner, bank);
        if (account != null) {
            System.out.print("Enter amount to withdraw: $");
            double amount = getValidDouble(scanner);
            scanner.nextLine(); // Consume the rest of the line
            account.withdraw(amount);
        }
    }

    private static void checkBalance(Scanner scanner, Bank bank) {
        Account account = findAccount(scanner, bank);
        if (account != null) {
            System.out.printf("The balance for account %s is: $%.2f%n", 
                              account.getAccountNumber(), account.getBalance());
        }
    }

    private static void viewTransactionHistory(Scanner scanner, Bank bank) {
        Account account = findAccount(scanner, bank);
        if (account != null) {
            account.printTransactionHistory();
        }
    }

    private static Account findAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        Account account = bank.findAccount(accNum);
        if (account == null) {
            System.out.println("Account not found. Please check the account number.");
        }
        return account;
    }

    private static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: $");
            scanner.next(); // discard non-double input
        }
        return scanner.nextDouble();
    }
}
