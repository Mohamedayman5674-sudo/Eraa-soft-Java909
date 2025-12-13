package Service.impl;

import Exceptions.AccountNotFoundException;
import Exceptions.DuplicateAccountException;
import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidInputException;
import Service.AccountService;
import helper.AccountResult;
import model.Account;
import model.EWalletSystem;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private final EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public Boolean createAccount(Account account) {

        if (getOptionalAccountByUserName(account).isPresent()) {
            throw new DuplicateAccountException("Username already exists");
        }

        if (getOptionalAccountByPhone(account).isPresent()) {
            throw new DuplicateAccountException("Phone number already exists");
        }

        eWalletSystem.getAccounts().add(account);
        return true;
    }

    @Override
    public Boolean getAccountByUserNameAndPassword(Account account) {
        return eWalletSystem.getAccounts().stream()
                .anyMatch(acc ->
                        acc.getUsername().equals(account.getUsername()) &&
                                acc.getPassword().equals(account.getPassword()));
    }

    @Override
    public Account getAccountByUsername(Account account) {
        return getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    @Override
    public AccountResult deposit(Account account, double amount) {

        Account acc = getOptionalAccountByUserName(account)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        if (amount < 100) {
            throw new InvalidInputException("Minimum deposit amount is 100");
        }

        acc.setBalance(acc.getBalance() + amount);
        return new AccountResult(3, acc.getBalance());
    }

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

        return new AccountResult(4, acc.getBalance());
    }

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
    }

    @Override
    public Account searchAccount(int id) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    @Override
    public int generateNewId() {
        return eWalletSystem.getAccounts().size() + 1;
    }

    @Override
    public Boolean isUserNameUnique(String username) {
        return eWalletSystem.getAccounts().stream()
                .noneMatch(acc -> acc.getUsername().equals(username));
    }

    @Override
    public Boolean isPhoneNumberUnique(String phoneNumber) {
        return eWalletSystem.getAccounts().stream()
                .noneMatch(acc -> acc.getPhoneNumber().equals(phoneNumber));
    }

    private Optional<Account> getOptionalAccountByUserName(Account account) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(account.getUsername()))
                .findFirst();
    }

    private Optional<Account> getOptionalAccountByPhone(Account account) {
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getPhoneNumber().equals(account.getPhoneNumber()))
                .findFirst();
    }
}