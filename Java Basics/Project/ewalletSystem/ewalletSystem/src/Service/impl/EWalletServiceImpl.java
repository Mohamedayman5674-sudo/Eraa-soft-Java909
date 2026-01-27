package Service.impl;

import Exceptions.*;
import Service.AccountService;
import Service.AccountValidationService;
import Service.ApplicationService;
import model.Account;

import java.util.Map;
import java.util.Scanner;

public class EWalletServiceImpl implements ApplicationService {

    private final AccountService accountService = new AccountServiceImpl();
    private final AccountValidationService accountValidationService =
            new AccountValidationServiceImpl();

    @Override
    public void startApp() {

        System.out.println("welcome sir :)");
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1.login   2.signup   3.Exit");
                char choice = scanner.next().charAt(0);
                scanner.nextLine();

                switch (choice) {
                    case '1' -> login();
                    case '2' -> signup();
                    case '3' -> {
                        System.out.println("have a nice day :)");
                        return;
                    }
                    default -> throw new InvalidInputException("Invalid choice");
                }

            } catch (RuntimeException exception) {
                System.out.println("❌ " + exception.getMessage());
                counter++;
                if (counter == 3) {
                    System.out.println("pls contact admin");
                    return;
                }
            }
        }
    }

    // ================= LOGIN =================
    private void login() {

        int attempts = 0;

        while (attempts < 4) {
            try {
                Account loginAccount = getAccount(true);

                if (accountService.getAccountByUserNameAndPassword(loginAccount)) {

                    Account fullAccount =
                            accountService.getAccountByUsername(loginAccount);

                    System.out.println("Login successful!");
                    profile(fullAccount);
                    return;
                }

                throw new InvalidInputException("Invalid username or password");

            } catch (RuntimeException exception) {
                System.out.println("❌ " + exception.getMessage());
                attempts++;
            }
        }

        System.out.println("Too many invalid attempts");
    }

    // ================= SIGNUP =================
    private void signup() {

        Account account = getAccount(false);
        accountService.createAccount(account);
        System.out.println("Account created successfully!");
        profile(account);
    }

    // ================= INPUT =================
    private Account getAccount(boolean login) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();
        accountValidationService.validateUserName(username);

        if (!login && !accountService.isUserNameUnique(username)) {
            throw new DuplicateAccountException("Username already exists");
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();
        accountValidationService.validatePassword(password);

        if (login) {
            return new Account(username, password);
        }

        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        accountValidationService.validatePhoneNumber(phone);

        if (!accountService.isPhoneNumberUnique(phone)) {
            throw new DuplicateAccountException("Phone already exists");
        }

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Age must be a number");
        }

        accountValidationService.validateAge(age);

        int id = accountService.generateNewId();
        return new Account(id, username, password, phone, address, age);
    }

    // ================= PROFILE =================
    private void profile(Account account) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                if (account.isAdmin()) {
                    System.out.println("""
                            1.View All Accounts
                            2.Delete Account
                            3.Deactivate Account
                            4.Logout
                            """);

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1 -> viewAllAccounts();
                        case 2 -> deleteAccount();
                        case 3 -> deactivateAccount();
                        case 4 -> { return; }
                        default -> throw new InvalidInputException("Invalid choice");
                    }

                } else {
                    System.out.println("""
                            1.Deposit
                            2.Withdraw
                            3.Transfer
                            4.Show Account Details
                            5.Change Password
                            6.Show Transactions
                            7.Logout
                            """);

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1 -> deposit(account);
                        case 2 -> withdraw(account);
                        case 3 -> transfer(account);
                        case 4 -> showAccountDetails(account);
                        case 5 -> changePassword(account);
                        case 6 -> showTransactions(account);
                        case 7 -> { return; }
                        default -> throw new InvalidInputException("Invalid service");
                    }
                }

            } catch (RuntimeException exception) {
                System.out.println("❌ " + exception.getMessage());
            }
        }
    }


    private void deposit(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        accountService.deposit(account, amount);
        System.out.println("Deposit successful");
    }

    private void withdraw(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        accountService.withdraw(account, amount);
        System.out.println("Withdraw successful");
    }

    private void transfer(Account sender) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Receiver ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Account receiver = accountService.searchAccount(id);

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        accountService.transfer(sender, receiver, amount);
        System.out.println("Transfer successful");
    }

    private void showAccountDetails(Account account) {
        System.out.println(accountService.getAccountByUsername(account));
    }

    private void changePassword(Account account) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Old password: ");
        String oldPass = scanner.nextLine();

        if (!account.getPassword().equals(oldPass)) {
            throw new InvalidInputException("Old password incorrect");
        }

        System.out.print("New password: ");
        String newPass = scanner.nextLine();
        accountValidationService.validatePassword(newPass);

        account.setPassword(newPass);
        System.out.println("Password updated successfully!");
    }

    private void showTransactions(Account account) {
        Map<Integer, java.util.List<String>> history =
                accountService.getTransactionHistory();

        history.get(account.getId())
                .forEach(System.out::println);
    }


    private void viewAllAccounts() {
        accountService.getAllAccounts()
                .forEach(System.out::println);
    }

    private void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        accountService.deleteAccount(id);
        System.out.println("Account deleted successfully");
    }

    private void deactivateAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        accountService.deactivateAccount(id);
        System.out.println("Account deactivated successfully");
    }
}
