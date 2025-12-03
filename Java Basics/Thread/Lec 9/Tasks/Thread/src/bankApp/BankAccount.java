package bankApp;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("DEPOSIT +" + amount + "  Balance: " + balance);
        notify();
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println("WITHDRAW Not enough balance… waiting");

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        balance -= amount;
        System.out.println("WITHDRAW -" + amount + "  Balance: " + balance);
    }
}
