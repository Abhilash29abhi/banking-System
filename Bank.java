import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

   
    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // List all accounts with details
    public void listAllAccounts() {
        for (Account account : accounts) {
            account.showAccountDetails();
            System.out.println("-------------------");
        }
    }

    // Return the list of accounts used for saving to a file
    public List<Account> getAccounts() {
        return accounts;
    }

    // Set accounts used for loading from a file
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
