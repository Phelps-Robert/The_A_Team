/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.BudgetAccount;
import model.Deposits;
import model.Expenses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateAccountView {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String BLUE = "\u001B[34m";  // Blue color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String PURPLE = "\u001B[35m"; // Purple color
    public static final String RESET = "\u001B[0m"; //Reset code
    
//    Scanner in = new Scanner(System.in);
       
    public void createAccount(BudgetAccount bAccount) {
//        String accountName;
//        System.out.println(CYAN + "Enter account name " + RESET);
//        accountName = in.nextLine();
//        bAccount.setAccountName(accountName);
//        
//        String accountDesc;
//        System.out.println(CYAN + "Enter account description " + RESET);
//        accountDesc = in.nextLine();
//        bAccount.setAccountDesc(accountDesc);
//        
//        double accountBalance;
//        System.out.println(CYAN + "Enter initial account balance " + RESET);
//        accountBalance = in.nextDouble();
//        bAccount.setBalance(accountBalance);

        BudgetAccount account = new BudgetAccount();
        account.setAccountName("Travel");
        account.setAccountDesc("This account is used to budget travel for our family");
        account.setBalance(1265.32);
        
        BudgetAccount account1 = new BudgetAccount();
        account1.setAccountName("Vacation");
        account1.setAccountDesc("This account is used to budget vacations for our family");
        account1.setBalance(985.78);
        
        BudgetAccount account2 = new BudgetAccount();
        account2.setAccountName("Groceries");
        account2.setAccountDesc("This account is used to budget groceries for our family");
        account2.setBalance(450.00);
        
        Deposits deposit1 = new Deposits();
        deposit1.setAccount(account);
        deposit1.setDeposit(100.00);
        
        Deposits deposit2 = new Deposits();
        deposit2.setAccount(account);
        deposit2.setDeposit(859.32);
        
        Expenses expense1 = new Expenses();
        expense1.setAccount(account);
        expense1.setExpense(200.00);
        
        Expenses expense2 = new Expenses();
        expense2.setAccount(account);
        expense2.setExpense(158.38);
        
        account.getAccountDeposits().add(deposit1);
        account.getAccountDeposits().add(deposit2);
        account.getAccountExpenses().add(expense1);
        account.getAccountExpenses().add(expense2);
        
        
       SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.save(account);
        session.save(account1);
        session.save(account2);
        session.save(deposit1);
        session.save(deposit2);
        session.save(expense1);
        session.save(expense2);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
        }
}
