
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="Expenses")   // defines the name of the database table
public class Expenses implements Serializable {
    
    /****************
     * VARIABLES
     ***************/
    @Id @GeneratedValue// defines the primary key for the database and auto genertate the value
    @Column (name="ExpenseId") // defines the name of the database column
    private int expenseID;
    
    @Column (name="Expense")
    private double expense;
    
    @ManyToOne ()
    @JoinColumn(name = "AccountId")
    private BudgetAccount account;
    
    
    /****************
     * CONSTRUCTORS
     ***************/
    public Expenses() {
        
    }
    
    /****************
     * GETTERS
     ***************/
    public int getExpenseID() {
        return expenseID;
    }

    public double getExpense() {
        return expense;
    }

    public BudgetAccount getAccount() {
        return account;
    }

    /****************
     * SETTERS
     ***************/
    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public void setAccount(BudgetAccount account) {
        this.account = account;
    }
    
}
