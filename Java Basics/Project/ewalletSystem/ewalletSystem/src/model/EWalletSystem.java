package model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {

    private final String name = "Eraa Soft E Wallet System";
    private List<Account> accounts = new ArrayList<>();


    public EWalletSystem() {
        createDefaultAdmin();
    }

 
    private void createDefaultAdmin() {

        boolean adminExists = accounts.stream()
                .anyMatch(acc -> "IAM".equals(acc.getUsername()));

        if (!adminExists) {
            Account admin = new Account(
                    0,
                    "IAM",
                    "IAM123",
                    "0000000000",
                    "SYSTEM",
                    30,
                    0
            );
            admin.setAdmin(true);
            admin.setActive(true);

            accounts.add(admin);
        }
    }


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
