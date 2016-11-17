/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.BudgetAccount;
import model.HibernateInterface;


public class CheckBalanceView {
    
    HibernateInterface hib = new HibernateInterface();
    
    public void checkBalances() {
        List<BudgetAccount> accounts = hib.getAllAccounts();
        
        String name = "Account Name";
        String balance = "Balance";
        String divider = "------------------------------------";
        System.out.println("");
        System.out.printf("%-20s %12s %n", name, balance);
        System.out.println(divider);
        
        for (BudgetAccount acc : accounts) {
            System.out.printf("%-22s %10.2f %n", acc.getAccountName(), acc.getBalance());
        }
        System.out.println(divider);
    }
    
}
