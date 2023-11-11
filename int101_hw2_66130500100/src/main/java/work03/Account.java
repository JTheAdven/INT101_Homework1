package work03;

import java.util.Objects;
import work01.*;
import work02.*;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;
    
    public Account(Person owner) {
        this.owner = owner;
        this.balance = 0;
        
        var result = Utilitor.computeIsbn10(nextNo);
        
        while(result == 10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        
        this.no = 10 * nextNo + result;
        nextNo++;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        
        this.balance += amount;
        return balance;
    }
    
    public double withdraw(double amount) {
        Utilitor.testPositive(amount);
        Utilitor.testPositive(balance - amount); //check if balance is negative before calculate
        
        this.balance -= amount;
        
        return balance;
    }
    
    public void transfer(double amount, Account account) {
        if(account == null) throw new IllegalArgumentException();
        
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account{" + "no=" + no + ", balance=" + balance + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.no != other.no) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return Objects.equals(this.owner, other.owner);
    }
    
    
}
