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
public class ChooseAccount {
    
    public String chooseAccount() {
        HibernateInterface hib = new HibernateInterface();
        Scanner in = new Scanner(System.in);
        
        List<String> accounts = hib.getAccountNames();

        String account = null;
            
        for (int i = 0; i < accounts.size(); i++) {

            System.out.println((i + 1) + ": " + accounts.get(i));
        }
            
        for (int i = 0; i < accounts.size(); i++) {
            int choice = in.nextInt();
            if (choice == (i + 1)) {
                account = accounts.get(i);
            }
        }
        System.out.println(account);
        
        return account;
    }
    
}
