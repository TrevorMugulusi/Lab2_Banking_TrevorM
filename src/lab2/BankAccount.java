package lab2;

public class BankAccount {

    // Account information
    private String accountNumber;
    private String name;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String name, double balance) {

        if (accountNumber == null || !accountNumber.matches("\\d{9,}")) {
            throw new IllegalArgumentException(
                    "Account number must contain at least 9 digits.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be blank.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        balance = balance + amount;
    }

    // Withdraw money
    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds.");
        }

        balance = balance - amount;
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }
}