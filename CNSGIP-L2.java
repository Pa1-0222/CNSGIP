package cns;
import java.util.Scanner;

// Bank Account class
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0; // Initial balance is set to zero
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of " + amount + " rupees successful.");
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " rupees successful.");
        }
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }
}

// Main class
public class BankTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new bank account
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        BankAccount account = new BankAccount(accountNumber, accountHolderName);
        while(true) {
            System.out.println("Select operation : \n 1. Deposite \t 2. Withdraw  \t 3.exit");
            int select = scanner.nextInt();
            // Deposit mone
            if (select == 1) {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Available balance: " + account.getBalance() + "Rs.");
            } else if (select == 2) {
                // Withdraw money
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                System.out.println("Available balance: " + account.getBalance() + "Rs.");
            }
            else {
                break;
            }
        }
    }
}

