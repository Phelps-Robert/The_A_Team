
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.BudgetAccount;
import model.Deposits;
import model.Expenses;
import model.HibernateInterface;
import view.AddDepositView;
import view.AddExpenseView;
import view.CheckBalanceView;
import view.CreateAccountView;
import view.UpdateAccountView;




public class AccountManager {
    
    private ArrayList accounts;
    BudgetAccount bAccounts = new BudgetAccount();
    Deposits deposit = new Deposits();
    Expenses expense =  new Expenses();
    CreateAccountView createAccount = new CreateAccountView();
    UpdateAccountView updateAccount = new UpdateAccountView();
    AddDepositView addDepositView = new AddDepositView();
    AddExpenseView addExpenseView = new AddExpenseView();
    CheckBalanceView checkBalanceView = new CheckBalanceView();
    HibernateInterface hib = new HibernateInterface();
    
    List<BudgetAccount> allAccounts;
    
    

    
    
    // class methods
    public void createAccount(){
        createAccount.createAccount(bAccounts);
//        hib.updateAccount(bAccounts);
    }
    
    public void updateAccounts() {
        updateAccount.updateAccount(updateAccount);
    }

    public void addDepositV() {
        String account = addDepositView.chooseDeposit();
        double depositAmount = addDepositView.depositAmount();
        this.commitDeposit(account, depositAmount);
    }
    
    public void addExpenseV() {
        String account = addExpenseView.chooseExpense();
        double depositAmount = addExpenseView.expenseAmount();
        this.commitExpense(account, depositAmount);
    }
    
    public void commitDeposit(String account, double dep) {
        int primID = hib.getOneAccount(account);
        BudgetAccount acc = hib.getAccountsById(primID);
        hib.addDeposit(acc, dep);
    }
    
    public void commitExpense(String account, double exp) {
        int primID = hib.getOneAccount(account);
        BudgetAccount acc = hib.getAccountsById(primID);
        hib.addExpense(acc, exp);
    }

    public void checkBalanceV() {
        checkBalanceView.checkBalances();
    }
    
    public void deleteAccount() {
        
    }
    
    public void test(){
        allAccounts = hib.getAllAccounts();
        for (int i = 0; i < allAccounts.size(); i++) {
            testStuff(i);
        }
    }
    
    public void testStuff(int i) {
        /* Object[] acc = new Object[5];
        
                acc[0] = ((BudgetAccount) allAccounts.get(i)).getAccountId();
                acc[1] = ((BudgetAccount) allAccounts.get(i)).getAccountName();
                acc[2] = ((BudgetAccount) allAccounts.get(i)).getAccountDesc();
                acc[3] = ((BudgetAccount) allAccounts.get(i)).getBalance();
                acc[4] = ((BudgetAccount) allAccounts.get(i)).getAccountDeposits();
                acc[5] = ((BudgetAccount) allAccounts.get(i)).getAccountExpenses();
        */
        String[] acc = new String[4];
            acc[0] = Integer.toString(allAccounts.get(i).getAccountId());
            acc[1] = allAccounts.get(i).getAccountName();
            acc[2] = allAccounts.get(i).getAccountDesc();
            acc[3] = Double.toString(allAccounts.get(i).getBalance());

            
            System.out.println("ACCOUNT ID: " + acc[0]);
            System.out.println("ACCOUNT NAME: " +acc[1]);
            System.out.println(acc[2]);
            System.out.println(acc[3]);
            System.out.println();
    }
   
    
    // getters
    public ArrayList getAccounts() {
        return accounts;
    }

    // setters
    public void setAccounts(ArrayList accounts) {
        this.accounts = accounts;
    }




    
}
