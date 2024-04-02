package System;

interface BankAccount {
    void deposit(double amount) throws BankException;
    void withdraw(double amount) throws BankException;
    void transfer(BankAccount recipient, double amount) throws BankException;
    double getBalance();
}