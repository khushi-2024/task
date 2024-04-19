import java.util.*;

public class ATM 
{
    private double balance;
    private ArrayList<String> transactionHistory;

    public ATM(double initialBalance) 
    {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void displayMenu() 
    {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
    }

    public void checkBalance() 
    {
        System.out.println("Your balance is :- Rs " + balance);
    }

    public void withdraw(double amount) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdraw: -Rs" + amount);
        System.out.println("Withdrawn: Rs" + amount);
    }

    public void deposit(double amount) 
    {
        balance += amount;
        transactionHistory.add("Deposit: +Rs" + amount);
        System.out.println("Deposited: Rs" + amount);
    }

    public void transfer(double amount) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        transactionHistory.add("Transfer: -Rs" + amount);
        System.out.println("Transferred: Rs" + amount);
    }

    public void displayTransactionHistory() 
    {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) 
        {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) 
    {
        ATM atm = new ATM(1000.0);
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            atm.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    atm.transfer(transferAmount);
                    break;
                case 5:
                    atm.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}