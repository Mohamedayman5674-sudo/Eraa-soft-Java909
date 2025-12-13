package model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {
    private final String name = "Eraa Soft E Wallet System";
    private List<Account> accounts = new ArrayList<Account>();

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
