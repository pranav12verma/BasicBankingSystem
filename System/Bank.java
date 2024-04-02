package System;

interface Bank {
    void createAccount(String accountNumber, String ownerName, double initialBalance) throws BankException;
    BankAccount getAccount(String accountNumber) throws BankException;
}