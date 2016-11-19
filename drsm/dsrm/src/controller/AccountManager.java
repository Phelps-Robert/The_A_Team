
package controller;

import java.util.List;
import model.BudgetAccount;
import model.Deposits;
import model.Expenses;
import model.HibernateInterface;
import view.AddDepositView;
import view.AddExpenseView;
import view.BudgetViewCLI;
import view.CreateAccountView;




public class AccountManager {
    
    BudgetAccount bAccounts = new BudgetAccount();
    Deposits deposit = new Deposits();
    Expenses expense =  new Expenses();
    CreateAccountView createAccount = new CreateAccountView();
    AddDepositView addDepositView = new AddDepositView();
    AddExpenseView addExpenseView = new AddExpenseView();
    HibernateInterface hib = new HibernateInterface();
    BudgetViewCLI view = new BudgetViewCLI();
    
    List<BudgetAccount> allAccounts;
    
    
    
    /********************************
     *     MENU HANDLER
     ******************************/
    public void menuHandler() {
        String userIn = new String();
        String name;
        String desc;
        //int budget;
        double bal;
        boolean done = false;
        int pk;
        String[] editAccount;
 
        while (!done) {
            test();
            userIn = view.menu();
 
            switch (userIn) {
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
                    boolean finished = false;
                    while (!finished) {
                        userIn = null;
                        view.viewAccount(editAccount);
                        userIn = view.editAccountChoice();
                        switch (userIn) {
                            case "1":
                                editAccount[1] = view.getName();
                                break;
                            case "2":
                                editAccount[2] = view.getDescription();
                                break;
                            case "3":
                                editAccount[3] = view.getBudget();
                                break;
                            case "4":
                                finished = true;
                                break;
                            default:
                                view.notEdit();
                                break;
                        }
                        updateAccounts(editAccount);
                    }
                    break;
                case "3":
                    view.accountView(test());
                    break;
                default:
                     System.exit(0);
                    break;
            }
        }
    }
    
    /******************************
     *      METHODS
     ****************************/
            
     // creates an account in the database       
    public void createAccount(){ // creates an account in the database
        createAccount.createAccount(bAccounts);
    }
    
    // updates an account in the database
    public void updateAccounts(String[] editAccount) {
        BudgetAccount tempAccount = hib.convertStringToObject(editAccount);
        hib.updateAccount(tempAccount);
    }

    // adds a deposit to an account in the database
    public void commitDeposit(String account, double dep) {
        int primID = hib.getOneAccount(account);
        BudgetAccount acc = hib.getAccountsById(primID);
        hib.addDeposit(acc, dep);
    }
    
    // adds a expense to an account in the database
    public void commitExpense(String account, double exp) {
        int primID = hib.getOneAccount(account);
        BudgetAccount acc = hib.getAccountsById(primID);
        hib.addExpense(acc, exp);
    }

    // delte an account along with all its expenses and deposits
    public void deleteAccount() {
        // TODO stub function
    }
    

    public String[][] test(){
        allAccounts = hib.getAllAccounts();
        String[][] all = new String[allAccounts.size()][6];
        int index = 0;
        for (int i = 0; i < allAccounts.size(); i++) {
            all[index] = testStuff(i);
            index++;
        }
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
            
           /* System.out.println("ACCOUNT ID: " + acc[0]);
            System.out.println("ACCOUNT NAME: " +acc[1]);
            System.out.println(acc[2]);
            System.out.println(acc[3]);
            System.out.println(); */
        return acc;
    }
}
