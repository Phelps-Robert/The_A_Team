/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Mattafire
 */
public class tmpHandler {
    BudgetViewCLI view = new BudgetViewCLI();
    
    public void test(){
        allAccounts = hib.getAllAccounts();
        for (int i = 0; i < allAccounts.size(); i++) {
            testStuff(i);
        }
    }
    
    public String[] testStuff(int i) {
        /* Object[] acc = new Object[5];
        
                acc[0] = ((BudgetAccount) allAccounts.get(i)).getAccountId();
                acc[1] = ((BudgetAccount) allAccounts.get(i)).getAccountName();
                acc[2] = ((BudgetAccount) allAccounts.get(i)).getAccountDesc();
                acc[3] = ((BudgetAccount) allAccounts.get(i)).getBalance();
                acc[4] = ((BudgetAccount) allAccounts.get(i)).getAccountDeposits();
                acc[5] = ((BudgetAccount) allAccounts.get(i)).getAccountExpenses();
        */
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
        int budget;
        int bal;
        boolean done = false;
        int pk;
        String[] editAccount;
        
        while(!done){
            userIn = view.menu();
            
            switch(userIn){
                case "1":
                    name = view.getName();
                    desc = view.getDiscription();
                    budget = Integer.parseInt(view.getBudget());
                    bal = Integer.parseInt(view.getBalance());//only use if initial ballance will be used.
                    allAccounts.add(new Account(name, desc, budget, bal));//needs to be formated to how we will handle creating a new account.
                    break;
                case "2":
                    pk = view.editAccount();
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
                            editAccount[2] = view.getDesc();
                            break;
                        case "3":
                        editAccount[3] = view.getBudget();
                            break;
                        case "4":
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

    
    
}
