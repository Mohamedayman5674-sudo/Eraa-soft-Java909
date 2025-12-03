package bankApp;

public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Depositor depositor = new Depositor(account);
        Withdrawer withdrawer = new Withdrawer(account);

        depositor.start();
        withdrawer.start();


    }
}
