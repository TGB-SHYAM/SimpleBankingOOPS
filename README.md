# SimpleBankingOOPS

Simple Command-Line Banking System

A simple, yet robust, command-line banking application built in Java. This project demonstrates core Object-Oriented Programming (OOP) principles to create a functional and extensible bank account management system.

Features

Create New Bank Accounts: Easily open a new account for a user with an initial deposit. A unique account number is automatically generated.

Deposit Funds: Add money to any existing account.

Withdraw Funds: Withdraw money from an account, with checks to prevent overdrawing.

Check Balance: View the current balance of any account.

Transaction History: View a timestamped log of all deposits and withdrawals for an account.

OOP Concepts Demonstrated

This project is structured around key Object-Oriented Programming principles:

Encapsulation: The Account class encapsulates the balance and transaction history, protecting the data from direct external modification. Access is only provided through public methods like deposit() and withdraw().

Abstraction: The Bank class provides a simple interface to manage accounts (createAccount(), findAccount()), hiding the complex internal logic of how accounts are stored (in this case, a HashMap).

Composition: The Bank class is composed of Account objects, and each Account is composed of Transaction objects, demonstrating the "has-a" relationship.

Modularity: Each class (Account, Bank, Transaction, BankSystem) has a distinct responsibility, making the code easier to understand, maintain, and extend.

Project Structure

The system is organized into four distinct classes:

BankSystem.java: The main driver class that contains the main method. It handles all user input and displays the command-line menu.

Bank.java: Manages all the bank accounts. It is responsible for creating new accounts and retrieving existing ones.

Account.java: Represents a single bank account. It holds the account holder's details, manages the balance, and maintains a history of its transactions.

Transaction.java: A simple data class that represents a single transaction, holding its type, amount, and a timestamp.

How to Compile and Run

You will need a Java Development Kit (JDK) installed on your system to run this application.

Clone the Repository:

git clone <your-repository-url>


Navigate to the Directory:

cd <repository-folder-name>


Compile all Java files:
The javac command compiles the .java source files into .class bytecode files.

javac *.java


Run the Application:
The java command runs the compiled code. You specify the name of the class that contains the main method.

java BankSystem


You will then be greeted with the application menu in your terminal.

Usage Example

--- Welcome to the Simple Banking System! ---

1. Create a new account
2. Deposit money
3. Withdraw money
4. Check balance
5. View transaction history
6. Exit
Please choose an option: 1
Enter account holder's name: John Doe
Enter initial deposit amount: $500
Account created successfully! Your new account number is: 1001
