package lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Process 3 bank accounts
        for (int i = 1; i <= 3; i++) {

            System.out.println("\n--- Account " + i + " ---");

            try {
                System.out.print("Enter account number: ");
                String accountNumber = input.next();

                System.out.print("Enter account holder name: ");
                String name = input.next();

                System.out.print("Enter starting balance: ");
                double balance = input.nextDouble();

                // Create BankAccount object
                BankAccount account =
                        new BankAccount(accountNumber, name, balance);

                System.out.print("Enter deposit amount: ");
                double deposit = input.nextDouble();
                account.deposit(deposit);

                System.out.print("Enter withdrawal amount: ");
                double withdrawal = input.nextDouble();
                account.withdraw(withdrawal);

                // Display account information
                System.out.println("Account Number: "
                        + account.getAccountNumber());

                System.out.printf("Current Balance: $%.2f%n",
                        account.getBalance());

            } catch (InsufficientFundsException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (InputMismatchException e) {

                System.out.println("Error: Please enter a valid number.");
                input.nextLine();

            } finally {

                System.out.println("Transaction has been processed.");
            }
        }

        input.close();

    } // 

} // 