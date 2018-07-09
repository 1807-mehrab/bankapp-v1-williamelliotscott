import java.util.*;
import java.util.Map.Entry;

public class BankAccount {
    protected Integer PIN;
    protected String name;
    private int dollars;
    private int cents;

    protected HashMap<String, BankAccount> linkedAccounts;

    public BankAccount(HashMap<String, BankAccount> dataBase, String name, Integer PIN) {
        String uniqueKey = name + PIN.toString();
        if (dataBase.containsKey(uniqueKey)) {
            throw new IllegalArgumentException ("A bankAccount with that name and PIN already exists");
        }

        this.setName(name);
        this.setPIN(PIN);

        dataBase.put(uniqueKey, this);
    }
    
    protected void setName(String name) {
        this.name = name;
    }

    protected void setPIN(Integer PIN) {
        this.PIN = PIN;
    }

    protected void addMoney(int dollars, int cents) {
        dollars += this.dollars;
        cents += this.cents;

        while (cents >= 100) {
            cents -= 100;
            dollars++;
        }

        this.dollars = dollars;
        this.cents = cents;
    }

    protected void subtractMoney(int dollars, int cents) {
        int subTotal = dollars*100 + cents;
        int currentBallance = this.dollars*100 + this.cents;

        if (subTotal > currentBallance) {
            throw new IllegalArgumentException ("You don't have enough money in this account.");
            //return;
        }
        
        dollars = this.dollars - dollars;
        cents = this.cents - cents;

        while (cents < 0) {
            dollars--;
            cents += 100;
        }

        this.dollars = dollars;
        this.cents = cents;
    }

    public void deposit(int dollars, int cents) {
        if (dollars < 0 || cents < 0) {
            throw new IllegalArgumentException ("You cannot deposit a negative number of dollars or cents");
            //return;
        }
        
        this.addMoney(dollars, cents);
    }

    public void withdraw(int dollars, int cents) {
        return;
    }

    public void transfer(BankAccount target, int dollars, int cents) {
       if (dollars < 0 || cents < 0) {
            throw new IllegalArgumentException ("You cannot transfer a negative number of dollars or cents");
            //return;
        }

        this.subtractMoney(dollars, cents);
        target.deposit(dollars, cents);
    }

    public void setBalance(int dollars, int cents) {
        if (dollars < 0 || cents < 0) {
            throw new IllegalArgumentException ("You cannot set a negative number of dollars or cents");
            //return;
        }
        
        while (cents >= 100) {
            dollars++;
            cents -= 100;
        }

        this.dollars = dollars;
        this.cents = cents;
    }

    public void getBalance() {
        System.out.println("You have $"+dollars+"."+cents);
    }
}