package Service;

import helper.AccountResult;
import model.Account;

public interface AccountService {

    Boolean createAccount(Account account);

    Boolean getAccountByUserNameAndPassword(Account account);

    Account getAccountByUsername(Account account);

    AccountResult deposit(Account account, double amount);

    AccountResult withdraw(Account account, double amount);

    void transfer(Account from, Account to, double amount);

    Account searchAccount(int id);

    int generateNewId();

    Boolean isUserNameUnique(String username);

    Boolean isPhoneNumberUnique(String phoneNumber);
}