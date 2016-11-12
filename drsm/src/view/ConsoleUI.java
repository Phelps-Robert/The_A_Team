/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AccountManager;
import java.util.Scanner;

/**
 *
 * @author Dallas
 */
public class ConsoleUI {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String BLUE = "\u001B[34m";  // Blue color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String PURPLE = "\u001B[35m"; // Purple color
    public static final String RESET = "\u001B[0m"; //Reset code
    
    AccountManager manager = new AccountManager();
    
    public void dispayConsole() {
         
         String mainMenu = "\n"
            + "\n----------------------------------------"
            + "\n | App Menu                           |"
            + "\n ---------------------------------------"
            + "\n1 - Create Accounts"
            + "\n2 - Update Accounts"
            + "\n3 - Add Deposits"
            + "\n4 - Add Expenses"
            + "\n5 - Check Balance"
            + "\n6 - Test stuff"
            + "\n7 - Exit"
            + "\n---------------------------------------";
         
         Scanner in = new Scanner(System.in);
         int choice;
         do {
            System.out.println(mainMenu);
            choice = in.nextInt(); // used to for choice in switch
         
            while (choice < 1 || choice > 6) {
                System.out.print("\nError! Incorrect choice.\n");
                System.out.println(mainMenu);
                choice = in.nextInt();
        }
         
            switch(choice) {
                case 1: // get employee information
                    this.creatAccounts();
                    break;
                case 2:  // display employee info
                    this.updateAccounts();
                    break;
                case 3:  // display employee info
                    this.addDeposit();
                    break;
                case 4: // start threads
                    this.addExpense();
                    break;
                case 5: // check balance
                    this.checkBalance();
                    break;
                case 6: // check balance
                    this.testStuff();
                    break;
                case 7: // exit
                    System.exit(0);
                    break;
            }
         } while (choice != 6);
    }
    
    private void creatAccounts() {
        manager.createAccount();
    }

    private void updateAccounts() {
        manager.updateAccounts();
    }
    private void addDeposit() {
        manager.addDepositV();
    }

    private void addExpense() {
        manager.addExpenseV();
    }

    private void checkBalance() {
        manager.checkBalanceV();
    }

    private void testStuff() {
        manager.test();
      
    }

}
