
package controller;

import java.util.ArrayList;
import java.util.List;
import model.BudgetAccount;
import model.Deposits;
import model.Expenses;
import model.HibernateInterface;
import view.AddDepositView;
import view.AddExpenseView;
import view.BudgetViewCLI;
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
    BudgetViewCLI view = new BudgetViewCLI();
    
    List<BudgetAccount> allAccounts;
    
    

    
    
    // class methods
    public void createAccount(){
        createAccount.createAccount(bAccounts);
//        hib.updateAccount(bAccounts);
    }
    
    public void updateAccounts(String[] editAccount) {
        BudgetAccount tempAccount = hib.convertStringToObject(editAccount);
        hib.updateAccount(tempAccount);
       // updateAccount.updateAccount(updateAccount);
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
    
    public String[][] test(){
        allAccounts = hib.getAllAccounts();
        String[][] all = new String[allAccounts.size()][6];
        int index = 0;
        for (int i = 0; i < allAccounts.size(); i++) {
            all[index] = testStuff(i);
            index++;
        }
        System.out.println(all[0][1]);
    return all;
    }
    
    public String[] testStuff(int i) {

        String[] acc = new String[6];
            acc[0] = Integer.toString(allAccounts.get(i).getAccountId());
            acc[1] = allAccounts.get(i).getAccountName();
            acc[2] = allAccounts.get(i).getAccountDesc();
            acc[3] = Double.toString(allAccounts.get(i).getBalance());
            //acc[4] = budget;
            //acc[5] = rollover;
            
            System.out.println("ACCOUNT ID: " + acc[0]);
            System.out.println("ACCOUNT NAME: " +acc[1]);
            System.out.println(acc[2]);
            System.out.println(acc[3]);
            System.out.println();
        return acc;
    }
    
        public void menuHandler(){
        String userIn = new String();
        String name;
        String desc;
        //int budget;
        double bal;
        boolean done = false;
        int pk;
        String[] editAccount;
        
        while(!done){
            userIn = view.menu();
            
            switch(userIn){
                case "1":
                    name = view.getName();
                    desc = view.getDescription();
                   //budget = Integer.parseInt(view.getBudget());
                    bal = Double.parseDouble(view.getBalance());//only use if initial ballance will be used.
                    BudgetAccount newAccount = new BudgetAccount(name, desc, bal); // create a new account object and assign values
                    hib.createNewAccount(newAccount); // save the new account to the database
                    break;
                case "2":
                    userIn = view.editAccount();
                    editAccount = testStuff(Integer.parseInt(userIn));
                    view.viewAccount(editAccount);
                    userIn = view.editAccountChoice();
                    while(userIn != "4"){
                        view.viewAccount(editAccount);
                        userIn = view.editAccountChoice();
                    switch(userIn){
                        case"1":
                            editAccount[1] = view.getName();
                            break;
                        case "2":
                            editAccount[2] = view.getDescription();
                            break;
                        //case "3":
                        //editAccount[3] = view.getBudget();
                        //    break;
                        case "3":
                        default:
                            view.notEdit();
                            break;
                    }
                    updateAccounts(editAccount);
                    }
                    break;
                case"3":
                    view.accountView(test());
                    break;
                default:
                    done = true;
                    break;
            }
            
        }
        
        
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
