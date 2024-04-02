package System;

class SimpleBankAccount implements BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public SimpleBankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) throws BankException {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws BankException {
        if (balance < amount) {
            throw new BankException("Insufficient funds");
        }
        balance -= amount;
    }

    @Override
    public void transfer(BankAccount recipient, double amount) throws BankException {
        withdraw(amount);
        recipient.deposit(amount);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
