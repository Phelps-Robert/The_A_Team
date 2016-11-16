/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BudgetProgram;

/**
 *
 * @author Mattafire
 */
public class Starter {
    public static void main(String[] args) throws Exception {
        BudgetViewCLI handle = new BudgetViewCLI();
        String[][] accounts = new String[3][4];
        accounts[0][0] = "Mitch";
        accounts[1][0] = "Sarah";
        accounts[2][0] = "A really really long long name just to see where it is cut off";
        accounts[0][1] = "100";
        accounts[1][1] = "200";
        accounts[2][1] = "0.50";
        accounts[0][2] = "25";
        accounts[1][2] = "450";
        accounts[2][2] = "123456789";
        accounts[0][3] = "True";
        accounts[1][3] = "True";
        accounts[2][3] = "False";
        handle.accountView(accounts);
        handle.viewAccount(accounts[2]);
    }
}
