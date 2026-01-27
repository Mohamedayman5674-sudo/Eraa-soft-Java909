package Service.impl;

import Exceptions.*;
import Service.AccountService;
import helper.AccountResult;
import model.Account;
import model.EWalletSystem;

import java.util.*;

public class AccountServiceImpl implements AccountService {

    private final EWalletSystem eWalletSystem = new EWalletSystem();

    // =============================
    // 🔥 Transaction History
    // accountId -> list of actions
    // =============================
    private final Map<Integer, List<String>> transactionHistory = new HashMap<>();

    // =============================
    // 🔥 Constructor (Auto Admin)
    // =============================
    public AccountServiceImpl() {

        // prevent duplicate admin
        boolean adminExists = eWalletSystem.getAccounts().stream()
                .anyMatch(acc -> "IAM".equals(acc.getUsername()));

        if (!adminExists) {
            Account admin = new Account(
                    0,
                    "IAM",
                    "IAM123",
                    "0000000000",
                    "ADMIN",
                    0
            );
            admin.setAdmin(true);
            admin.setActive(true);

            eWalletSystem.getAccounts().add(admin);
            transactionHistory.put(admin.getId(), new ArrayList<>());
            addTransaction(admin.getId(), "Admin account created");
        }
    }

    // =============================
    // Account Operations
    // =============================
    @Override
    public Boolean createAccount(Account account) {

        if (getOptionalAccountByUserName(account).isPresent()) {
            throw new DuplicateAccountException("Username already exists");
        }

        if (getOptionalAccountByPhone(account).isPresent()) {
            throw new DuplicateAccountException("Phone number already exists");
        }

        account.setId(generateNewId());
        account.setActive(true);
        account.setAdmin(false);

        eWalletSystem.getAccounts().add(account);
        transactionHistory.put(account.getId(), new ArrayList<>());
        addTransaction(account.getId(), "Signup");

        return true;
    }

    @Override
    public Boolean getAccountByUserNameAndPassword(Account account) {

        Account acc = getOptionalAccountByUserName(account)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (!acc.isActive()) {
            throw new InvalidInputException("Account is inactive");
        }

        if (!Objects.equals(acc.getPassword(), account.getPassword())) {
            throw new InvalidInputException("Invalid username or password");
        }

        addTransaction(acc.getId(), "Login");
        return true;
    }

    @Override
    public Account getAccountByUsername(Account account) {
        return getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    @Override
    public AccountResult deposit(Account account, double amount) {

        Account acc = getAccountByUsername(account);

        if (!acc.isActive()) {
            throw new InvalidInputException("Account is inactive");
        }

        if (amount < 100) {
            throw new InvalidInputException("Minimum deposit amount is 100");
        }

        acc.setBalance(acc.getBalance() + amount);
        addTransaction(acc.getId(), "Deposit: +" + amount);

        return new AccountResult(3, acc.getBalance());
    }

    @Override
    public AccountResult withdraw(Account account, double amount) {

        Account acc = getAccountByUsername(account);

        if (!acc.isActive()) {
            throw new InvalidInputException("Account is inactive");
        }

        if (amount < 100) {
            throw new InvalidInputException("Minimum withdraw amount is 100");
        }

        if (acc.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        addTransaction(acc.getId(), "Withdraw: -" + amount);

        return new AccountResult(4, acc.getBalance());
    }

    @Override
    public void transfer(Account from, Account to, double amount) {

        if (from == null || to == null) {
            throw new AccountNotFoundException("Account not found");
        }

        if (!from.isActive() || !to.isActive()) {
            throw new InvalidInputException("Inactive account involved");
        }

        if (amount < 100) {
            throw new InvalidInputException("Minimum transfer amount is 100");
        }

        if (from.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        addTransaction(from.getId(), "Transfer to " + to.getUsername() + ": -" + amount);
        addTransaction(to.getId(), "Transfer from " + from.getUsername() + ": +" + amount);
    }

    @Override
    public Account searchAccount(int id) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    // =============================
    // Admin Features
    // =============================
    @Override
    public List<Account> getAllAccounts() {
        return eWalletSystem.getAccounts();
    }

    @Override
    public boolean deleteAccount(int accountId) {
        Account acc = searchAccount(accountId);
        eWalletSystem.getAccounts().remove(acc);
        transactionHistory.remove(accountId);
        return true;
    }

    @Override
    public boolean deactivateAccount(int accountId) {
        Account acc = searchAccount(accountId);
        acc.setActive(false);
        addTransaction(accountId, "Account deactivated");
        return true;
    }

    // =============================
    // Transaction History
    // =============================
    @Override
    public Map<Integer, List<String>> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public void addTransaction(int accountId, String action) {
        transactionHistory
                .computeIfAbsent(accountId, k -> new ArrayList<>())
                .add(action);
    }

    // =============================
    // Utils
    // =============================
    @Override
    public int generateNewId() {
        return eWalletSystem.getAccounts().size() + 1;
    }

    @Override
    public Boolean isUserNameUnique(String username) {
        return eWalletSystem.getAccounts().stream()
                .noneMatch(acc -> Objects.equals(acc.getUsername(), username));
    }

    @Override
    public Boolean isPhoneNumberUnique(String phoneNumber) {
        return eWalletSystem.getAccounts().stream()
                .noneMatch(acc -> Objects.equals(acc.getPhoneNumber(), phoneNumber));
    }

    private Optional<Account> getOptionalAccountByUserName(Account account) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> Objects.equals(acc.getUsername(), account.getUsername()))
                .findFirst();
    }

    private Optional<Account> getOptionalAccountByPhone(Account account) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> Objects.equals(acc.getPhoneNumber(), account.getPhoneNumber()))
                .findFirst();
    }
}
