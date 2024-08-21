import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        // Load existing account data from file
        List<Account> loadedAccounts = FileManager.loadAccountData();
        if (loadedAccounts != null) {
            bank.setAccounts(loadedAccounts);
        }

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Details");
            System.out.println("5. List All Accounts");
            System.out.println("6. Save Data and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account type (savings/current): ");
                    String accountType = scanner.next();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.next();

                    Account newAccount;
                    if (accountType.equalsIgnoreCase("savings")) {
                        newAccount = new SavingsAccount(accountNumber, accountHolderName);
                    } else if (accountType.equalsIgnoreCase("current")) {
                        newAccount = new CurrentAccount(accountNumber, accountHolderName);
                    } else {
                        System.out.println("Invalid account type.");
                        continue;
                    }
                    bank.addAccount(newAccount);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depAccountNumber = scanner.next();
                    Account depAccount = bank.getAccount(depAccountNumber);
                    if (depAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        depAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withAccountNumber = scanner.next();
                    Account withAccount = bank.getAccount(withAccountNumber);
                    if (withAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        withAccount.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String detailsAccountNumber = scanner.next();
                    Account detailsAccount = bank.getAccount(detailsAccountNumber);
                    if (detailsAccount != null) {
                        detailsAccount.showAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    bank.listAllAccounts();
                    break;

                case 6:
                    // Save account data to file
                    FileManager.saveAccountData(bank.getAccounts());
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
