
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="Deposits")   // defines the name of the database table
public class Deposits implements Serializable{
    
    // member variables
    @Id @GeneratedValue // defines the primary key for the database and auto genertate the value
    @Column (name="DepositId") // defines the name of the database column
    private int depositId;
    
    @Column (name="Deposit")
    private double deposit;
    
    @ManyToOne ()
    @JoinColumn(name = "AccountId")
    private BudgetAccount account;
    
    
    // default constructor
    public Deposits() {
        
    }
    
    
    // getters
    public int getDepositId() {
        return depositId;
    }

    public double getDeposit() {
        return deposit;
    }

    public BudgetAccount getAccount() {
        return account;
    }
    
    
    // setters
    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setAccount(BudgetAccount account) {
        this.account = account;
    }
    
    
}
