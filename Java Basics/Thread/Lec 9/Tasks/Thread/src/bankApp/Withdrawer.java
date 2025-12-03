package bankApp;

public class Withdrawer extends Thread {
    private final BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.withdraw(30);  // Try withdrawing 30

            try {
                Thread.sleep(1200); // sleep 1.2 sec
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
