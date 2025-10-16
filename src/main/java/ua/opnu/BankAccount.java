package ua.opnu;

public class BankAccount {
    public double balance;
    public double transactionFee;

    public BankAccount() {
        this.balance = 0;
        this.transactionFee = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
        this.transactionFee = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) return false;
        if (withdraw(amount)) {
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
}
