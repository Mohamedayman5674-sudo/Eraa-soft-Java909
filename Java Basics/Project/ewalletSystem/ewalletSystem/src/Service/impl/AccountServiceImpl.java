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
    //  Transaction History
    // accountId -> list of actions
    // =============================
    private final Map<Integer, List<String>> transactionHistory = new HashMap<>();

    // =============================
    //  Constructor (Auto Admin)
    // =============================
    public AccountServiceImpl() {
        Account admin = new Account(
                0,
                "IAM",
                "IAM123",
                "0000000000",
                "ADMIN",
                99
        );
        eWalletSystem.getAccounts().add(admin);
        transactionHistory.put(admin.getId(), new ArrayList<>());
        addTransaction(admin.getId(), "Admin account created");
    }

    // =============================
    // Create Account
    // =============================
    @Override
    public Boolean createAccount(Account account) {

        if (getOptionalAccountByUserName(account).isPresent()) {
            throw new DuplicateAccountException("Username already exists");
        }

        if (getOptionalAccountByPhone(account).isPresent()) {
            throw new DuplicateAccountException("Phone number already exists");
        }

        eWalletSystem.getAccounts().add(account);
        transactionHistory.put(account.getId(), new ArrayList<>());
        addTransaction(account.getId(), "Signup");

        return true;
    }

    // =============================
    // Login
    // =============================
    @Override
    public Boolean getAccountByUserNameAndPassword(Account account) {
        boolean success = eWalletSystem.getAccounts().stream()
                .anyMatch(acc ->
                        Objects.equals(acc.getUsername(), account.getUsername()) &&
                        Objects.equals(acc.getPassword(), account.getPassword()));

        if (success) {
            Account acc = getOptionalAccountByUserName(account).get();
            addTransaction(acc.getId(), "Login");
        }

        return success;
    }

    @Override
    public Account getAccountByUsername(Account account) {
        return getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    // =============================
    // Deposit
    // =============================
    @Override
    public AccountResult deposit(Account account, double amount) {

        Account acc = getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        if (amount < 100) {
            throw new InvalidInputException("Minimum deposit amount is 100");
        }

        acc.setBalance(acc.getBalance() + amount);
        addTransaction(acc.getId(), "Deposit: +" + amount);

        return new AccountResult(3, acc.getBalance());
    }

    // =============================
    // Withdraw
    // =============================
    @Override
    public AccountResult withdraw(Account account, double amount) {

        Account acc = getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

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

    // =============================
    // Transfer
    // =============================
    @Override
    public void transfer(Account from, Account to, double amount) {

        if (from == null || to == null) {
            throw new AccountNotFoundException("Account not found");
        }

        if (amount < 100) {
            throw new InvalidInputException("Minimum transfer amount is 100");
        }

        if (from.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        addTransaction(from.getId(), "Transfer to ID " + to.getId() + ": -" + amount);
        addTransaction(to.getId(), "Transfer from ID " + from.getId() + ": +" + amount);
    }

    // =============================
    // Search Account
    // =============================
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
        acc.setPassword("DEACTIVATED");
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

