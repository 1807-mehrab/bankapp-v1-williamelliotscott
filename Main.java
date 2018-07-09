import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        HashMap<String, BankAccount> dataBase = new HashMap<>();
        BankAccount test = new BankAccount(dataBase, "Cinder", 230);
        CheckingAccount testChecking = new CheckingAccount(test, "CinderChecking", 100, 123);
        SavingsAccount testSaving = new SavingsAccount(test, "CinderSavings", 500, 517);

        testChecking.getBalance();
        testSaving.getBalance();
    }
}