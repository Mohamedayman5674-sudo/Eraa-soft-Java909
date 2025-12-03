package bankApp;

public class Depositor extends Thread {
    private final BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.deposit(50);

            try {
                Thread.sleep(1500); //
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
