import java.util.*;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance. Cannot withdraw " + amount + ". Current balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolderName + ", Current Balance: " + balance);
    }
}

class Banking {
    private List<BankAccount> accounts;

    public Banking() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account for " + account.getAccountHolderName() + " created.");
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void transfer(String fromAccNum, String toAccNum, double amount) {
        BankAccount fromAccount = findAccount(fromAccNum);
        BankAccount toAccount = findAccount(toAccNum);

        if (fromAccount == null) {
            System.out.println("Source account not found: " + fromAccNum);
            return;
        }
        if (toAccount == null) {
            System.out.println("Destination account not found: " + toAccNum);
            return;
        }
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer of " + amount + " from " + fromAccNum + " to " + toAccNum + " successful.");
        } else {
            System.out.println("Transfer failed due to insufficient balance in account " + fromAccNum);
        }
    }
}

public class Banking{
    public static void main(String[] args) {
        BankingSystem myBank = new BankingSystem();
        myBank.addAccount(new BankAccount("John Doe", "ACC123", 1500.0));
        myBank.addAccount(new BankAccount("Jane Smith", "ACC456", 500.0));

        myBank.findAccount("ACC123").displayBalance();
        myBank.findAccount("ACC456").displayBalance();

        System.out.println("\nDepositing $200 into ACC123...");
        myBank.findAccount("ACC123").deposit(200.0);
        myBank.findAccount("ACC123").displayBalance();

        System.out.println("\nWithdrawing $800 from ACC123...");
        myBank.findAccount("ACC123").withdraw(800.0);
        myBank.findAccount("ACC123").displayBalance();

        System.out.println("\nTransferring $600 from ACC123 to ACC456...");
        myBank.transfer("ACC123", "ACC456", 600.0);
        myBank.findAccount("ACC123").displayBalance();
        myBank.findAccount("ACC456").displayBalance();
    }
}
