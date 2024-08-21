public class SavingsAccount extends Account {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName) {
        super(accountNumber, accountHolderName);
        this.interestRate = 0.03; 
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }
}
