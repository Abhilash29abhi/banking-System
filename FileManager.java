import java.io.*;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "accounts.ser";

    // Save account data to a file
    public static void saveAccountData(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load account data from a file
    @SuppressWarnings("unchecked")
    public static List<Account> loadAccountData() {
        List<Account> accounts = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (List<Account>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return accounts;
    }
}
