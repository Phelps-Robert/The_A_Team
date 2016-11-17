package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name="BudgetAccount.byName", query="from BudgetAccount where accountName = ?")
@Table (name="Accounts")   // defines the name of the database table
public class BudgetAccount implements Serializable{
    
    // variables
    @Id @GeneratedValue // defines the primary key for the database and auto genertate the value
    @Column (name="AccountId") // defines the name of the database column
    private int accountId;
    
    @Column (name="AccountName") // defines the name of the database column
    private String accountName;
    
    @Column (name="AccountDescription") // defines the name of the database column
    private String accountDesc;
    
    @OneToMany (targetEntity = Deposits.class, mappedBy = "account")
    @Column (name="AccountDeposit") // defines the name of the database column
    private Collection<Deposits> accountDeposits = new ArrayList<>();
    
    @OneToMany (targetEntity = Expenses.class, mappedBy = "account")
    @Column (name="AccountExpense") // defines the name of the database column
    private Collection<Expenses> accountExpenses = new ArrayList<>();
    
    @Column (name="AccountBalance") // defines the name of the database column
    private double balance;

    
    // default constructor
    public BudgetAccount() {
        
    }
    
     public BudgetAccount(String name, String desc, double bal) {
         this.accountName = name;
         this.accountDesc = desc;
         this.balance = bal;
    }
    
    
    //getters
    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public Collection<Deposits> getAccountDeposits() {
        return accountDeposits;
    }

    public Collection<Expenses> getAccountExpenses() {
        return accountExpenses;
    }

    public double getBalance() {
        return balance;
    }

    
    // setters
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public void setAccountDeposits(Collection<Deposits> accountDeposits) {
        this.accountDeposits = accountDeposits;
    }

    public void setAccountExpenses(Collection<Expenses> accountExpenses) {
        this.accountExpenses = accountExpenses;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // hachCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.accountId;
        hash = 29 * hash + Objects.hashCode(this.accountName);
        hash = 29 * hash + Objects.hashCode(this.accountDesc);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        return hash;
    }

    // equals

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
        final BudgetAccount other = (BudgetAccount) obj;
        if (this.accountId != other.accountId) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.accountName, other.accountName)) {
            return false;
        }
        if (!Objects.equals(this.accountDesc, other.accountDesc)) {
            return false;
        }
        return true;
    }


    // toString
    @Override
    public String toString() {
        return "BudgetAccount{" + "accountId=" + accountId + ", accountName=" + accountName + ", accountDesc=" + accountDesc + ", accountDeposits=" + accountDeposits + ", accountExpenses=" + accountExpenses + ", balance=" + balance + '}';
    }
    
}
