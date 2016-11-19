/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.HibernateInterface;

/**********************************************************
*      MODEL FOR ADD DEPOSIT ** CURRENTLY NOT USED **
***********************************************************/
public class AddDepositView {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String BLUE = "\u001B[34m";  // Blue color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String PURPLE = "\u001B[35m"; // Purple color
    public static final String RESET = "\u001B[0m"; //Reset code
    
    Scanner in = new Scanner(System.in);
    ChooseAccount chooseAccount =  new ChooseAccount();
    HibernateInterface hib = new HibernateInterface();
       
    public String chooseDeposit() {

        System.out.println("To add a deposit select an account.");
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
    
    public double depositAmount() {
        System.out.println("Amoount to deposit: ");
        boolean done = true;
        double deposit = 0.0;
    
        deposit = in.nextDouble();
    
        return deposit;
    }
    
}
