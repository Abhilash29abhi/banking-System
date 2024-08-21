import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); 
    }

    // Display transaction details
    public void showTransactionDetails() {
        System.out.println("Transaction Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
    }
}

