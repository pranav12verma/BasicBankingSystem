package System;

import java.util.*;
//public class BasicBankingSystem {
//    public static void main(String[] args) {
//        Bank bank = new SimpleBank();
//
//        try {
//            bank.createAccount("123456789", "pranav verma", 1000);
//            bank.createAccount("987654321", "manu mathur", 500);
//        } catch (BankException e){
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        try {
//            BankAccount pranavAccount = bank.getAccount("123456789");
//            BankAccount manuAccount = bank.getAccount("987654321");
//
//            pranavAccount.deposit(500);
//            manuAccount.withdraw(200);
//            pranavAccount.transfer(manuAccount, 300);
//
//            System.out.println("pranav's balance: " + pranavAccount.getBalance());
//            System.out.println("manu's balance: " + manuAccount.getBalance());
//        } catch (BankException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//}

public class BasicBankingSystem {
    public static void main(String[] args) {
        Bank bank = new SimpleBank();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    performDeposit(bank, scanner);
                    break;
                case 3:
                    performWithdraw(bank, scanner);
                    break;
                case 4:
                    performTransfer(bank, scanner);
                    break;
                case 5:
                    performCheckBalance(bank, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();
            System.out.print("Enter owner's name: ");
            String ownerName = scanner.next();
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            bank.createAccount(accountNumber, ownerName, initialBalance);
            System.out.println("Account created successfully.");
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void performDeposit(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            BankAccount account = bank.getAccount(accountNumber);
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: " + account.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performWithdraw(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            BankAccount account = bank.getAccount(accountNumber);
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performTransfer(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter sender account number: ");
            String senderAccountNumber = scanner.next();
            System.out.print("Enter recipient account number: ");
            String recipientAccountNumber = scanner.next();
            System.out.print("Enter transfer amount: ");
            double amount = scanner.nextDouble();
            BankAccount senderAccount = bank.getAccount(senderAccountNumber);
            BankAccount recipientAccount = bank.getAccount(recipientAccountNumber);
            senderAccount.transfer(recipientAccount, amount);
            System.out.println("Transfer successful.");
            System.out.println("Sender's balance: " + senderAccount.getBalance());
            System.out.println("Recipient's balance: " + recipientAccount.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performCheckBalance(Bank bank, Scanner scanner) {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();
            BankAccount account = bank.getAccount(accountNumber);
            System.out.println("Current balance: " + account.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}




