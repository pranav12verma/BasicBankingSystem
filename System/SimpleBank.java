package System;

import java.util.HashMap;
import java.util.Map;

class SimpleBank implements Bank {
    private Map<String, BankAccount> accounts;

    public SimpleBank() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        BankAccount account = new SimpleBankAccount(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
    }

    @Override
    public BankAccount getAccount(String accountNumber) throws BankException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new BankException("Account not found");
        }
        return account;
    }
}