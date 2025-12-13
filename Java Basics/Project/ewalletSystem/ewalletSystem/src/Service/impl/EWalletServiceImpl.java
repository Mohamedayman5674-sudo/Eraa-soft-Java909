package Service.impl;

import Exceptions.AccountNotFoundException;
import Exceptions.DuplicateAccountException;
import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidInputException;
import Service.AccountService;
import Service.AccountValidationService;
import Service.ApplicationService;
import model.Account;

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
                    case '1':
                        login();
                        break;
                    case '2':
                        signup();
                        break;
                    case '3':
                        System.out.println("have a nice day :)");
                        return;
                    default:
                        throw new InvalidInputException("Invalid choice");
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

    private void login() {

    int attempts = 0;

    while (attempts < 4) {
        try {
            Account loginAccount = getAccount(true);

            if (accountService.getAccountByUserNameAndPassword(loginAccount)) {

                // 🔥 خُد الحساب الكامل من السيستم
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


    private void signup() {

        Account account = getAccount(false);
        accountService.createAccount(account);
        System.out.println("Account created successfully!");
        profile(account);
    }

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

    private void profile(Account account) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1.deposit 2.withdraw 3.transfer 4.Show Account Details 5.change password 6.logout");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> deposit(account);
                    case 2 -> withdraw(account);
                    case 3 -> transfer(account);
                    case 4 -> showAccountDetails(account);
                    case 5 -> changePassword(account);
                    case 6 -> {
                        return;
                    }
                    default -> throw new InvalidInputException("Invalid service");
                }

            } catch (RuntimeException exception) {
                System.out.println("❌ " + exception.getMessage());
            }
        }
    }

    private void deposit(Account account) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");

        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid amount");
        }

        accountService.deposit(account, amount);
        System.out.println("Deposit successful");
    }

    private void withdraw(Account account) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");

        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid amount");
        }

        accountService.withdraw(account, amount);
        System.out.println("Withdraw successful");
    }

    private void transfer(Account sender) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Receiver ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid ID");
        }

        Account receiver = accountService.searchAccount(id);
        if (receiver == null) {
            throw new AccountNotFoundException("Receiver not found");
        }

        System.out.print("Amount: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Invalid amount");
        }

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

        if (newPass.equals(oldPass)) {
            throw new InvalidInputException("New password cannot be same as old");
        }

        accountValidationService.validatePassword(newPass);
        account.setPassword(newPass);

        System.out.println("Password updated successfully!");
    }

}
