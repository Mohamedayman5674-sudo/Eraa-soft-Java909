package Service;

import helper.AccountResult;
import model.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {

    // ===== Existing =====
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

    // ===============================


    // ===== Admin Panel =====
    List<Account> getAllAccounts();

    boolean deleteAccount(int accountId);

    boolean deactivateAccount(int accountId);

    // ===== Transaction History =====
    Map<Integer, List<String>> getTransactionHistory();

    void addTransaction(int accountId, String action);
}
