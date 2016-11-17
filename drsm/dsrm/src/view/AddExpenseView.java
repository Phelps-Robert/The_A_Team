/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.HibernateInterface;

/**
 *
 * @author Dallas
 */
public class AddExpenseView {
    
    Scanner in = new Scanner(System.in);
    ChooseAccount chooseAccount =  new ChooseAccount();
    HibernateInterface hib = new HibernateInterface();

    public String chooseExpense() {
        System.out.println("To add an expense select an account.");
        System.out.println("When done press 0.");

        List<String> accounts = hib.getAccountNames();
        System.out.println();
            
        for (int i = 0; i < accounts.size(); i++) {

            System.out.println((i + 1) + ": " + accounts.get(i));
        }
            
        String account = null;
        int choice;
        choice = in.nextInt();
        for (int i = 0; i < accounts.size(); i++) {
            
            if (choice == (i + 1)) {
                account = accounts.get(i);
            }
        }
        System.out.println(account);
        
        return account;
    }

    public double expenseAmount() {
        System.out.println("Amount to deduct: ");
        double deposit = 0.0;
        deposit = in.nextDouble();
    
        return deposit;
    }
    
}
