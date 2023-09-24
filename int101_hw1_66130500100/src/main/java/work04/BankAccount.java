package work04;

public class BankAccount {
    private int number;
    private Person owner;
    private double balance;
    
    public BankAccount(int number, Person owner)
    {
        this.number = number;
        this.owner = owner;
    }

    public int getOwner() {
        return owner.getId();
    }

    public double getBalance() {
        return balance;
    }
    
    public double deposit(double amount)
    {
        this.balance = balance + amount;
        return(balance);
    }
    
    public double withdraw(double amount)
    {
        this.balance = balance - amount;
        return(balance);
    }
    
    public void transfer(double amount, BankAccount account)
    {
        this.balance = balance - amount;
        account.balance += amount;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(owner.getId());
    }
}
