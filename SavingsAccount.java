public class SavingsAccount extends BankAccount {

    public SavingsAccount(BankAccount parentAccount, String name, int dollars, int cents) {
        this.setBalance(dollars, cents);
        this.setName(name);

        parentAccount.linkedAccounts.put(name, this);
    
    }

    public void withdraw(int dollars, int cents) {
        System.out.println("You cannot withdraw directly from the saving's account.");
    }

}