public class CheckingAccount extends BankAccount {

    public CheckingAccount(BankAccount parentAccount, String name, int dollars, int cents) {
    
        this.setBalance(dollars, cents);
        this.setName(name);

        parentAccount.linkedAccounts.put(name, this);
        
    }

    public void withdraw(int dollars, int cents) {
        int amount = dollars*100 + cents;
        if (amount < 0) {
            throw new IllegalArgumentException ("You cannot deposit a negative value");
        } 
        
        this.subtractMoney(dollars, cents);
    }

}