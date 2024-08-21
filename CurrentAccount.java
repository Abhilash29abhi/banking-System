public class CurrentAccount extends Account {
    private double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, String accountHolderName) {
        super(accountNumber, accountHolderName);
        this.overdraftLimit = 5000; 
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}
