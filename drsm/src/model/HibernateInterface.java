package model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateInterface {
    
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void updateAccount(BudgetAccount account) {
        
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.save(account);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close(); 
    }
    
    public void addDeposit(BudgetAccount account, double dep) {
        Deposits deposit = new Deposits();
        deposit.setAccount(account);
        deposit.setDeposit(dep);
        double balance = account.getBalance() + dep;
        account.setBalance(balance);

        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.update(account);
        session.save(deposit);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
        
    }
    
    public void addExpense(BudgetAccount account, double exp) {
        Expenses expense = new Expenses();
        expense.setAccount(account);
        expense.setExpense(exp);
        double balance = account.getBalance() - exp;
        account.setBalance(balance);

        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.update(account);
        session.save(expense);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
        
    }
        
    public BudgetAccount getAccountsById(int id) {

        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        int num = id;
        //create a new transaction
        session.beginTransaction();
        BudgetAccount account = (BudgetAccount) session.get(BudgetAccount.class, num);
        session.getTransaction().commit();
        //close the session
        session.close();
        
        System.out.println(account.getAccountName());
        
        return account;
        }
    
    public List<BudgetAccount> getAllAccounts() {

        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Query query = session.createQuery("from BudgetAccount");
        List<BudgetAccount> accounts = (List<BudgetAccount>) query.list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        System.out.println();
        
        return accounts;
        }
    
    public List<String> getAccountNames() {
        Session session2 = sessionFactory.openSession();
        //create a new transaction
        session2.beginTransaction();
        Query query = session2.createQuery("select accountName from BudgetAccount");
        List<String> accountNames = (List<String>) query.list();
        session2.getTransaction().commit();
        //close the session
        session2.close();
        
        return accountNames;
    }
    
    public int getOneAccount(String accountName) {
        
        Session session3 = sessionFactory.openSession();
        //create a new transaction
        session3.beginTransaction();
        // get a single account name
        Query query1 = session3.getNamedQuery("BudgetAccount.byName");
        query1.setString(0, accountName);
        // store the account name in a variable
        List<BudgetAccount> acco = (List<BudgetAccount>) query1.list();
        //commit the transaction to the database
        session3.getTransaction().commit();
        // close the session
        session3.close();
        
        int result = 0;
        for (BudgetAccount acc1 : acco) {
            result = acc1.getAccountId();
            System.out.println(result);
        }
        
        return result;
    }
        
    public static void main(String[] args) {
        HibernateInterface hib = new HibernateInterface();
        
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
        
       
        Session session1 = sessionFactory.openSession();
        int id = 2;
        //create a new transaction
        session1.beginTransaction();
        BudgetAccount accoount2 = (BudgetAccount) session1.get(BudgetAccount.class, id);
        System.out.println("Get Account: " + accoount2.getAccountName());
        session1.getTransaction().commit();
        //close the session
        session1.close();
//        
//
//        Session session2 = sessionFactory.openSession();
//        //create a new transaction
//        session2.beginTransaction();
//        Query query = session2.createQuery("select accountName from BudgetAccount");
//        List<String> accountNames = (List<String>) query.list();
//        session2.getTransaction().commit();
//        //close the session
//        session2.close();
//        
//        System.out.println();
//        
//        for (String ba : accountNames) {
//            System.out.println("Account Name: " + ba);
//        }
//        
        
//        Session session3 = sessionFactory.openSession();
//        String accountName = "Groceries";
//        String acc = "select accountId from BudgetAccount where accountName=" + accountName;
//        //create a new transaction
//        session3.beginTransaction();
//        // get a single account name
//        Query query1 = session3.getNamedQuery("BudgetAccount.byName");
//        query1.setString(0, accountName);
//        // store the account name in a variable
//        List<BudgetAccount> acco = (List<BudgetAccount>) query1.list();
//        //commit the transaction to the database
//        session3.getTransaction().commit();
//        // close the session
//        session3.close();
//        
//        for (BudgetAccount acc1 : acco)
//            System.out.println("Get ID from Query: " + acc1.getAccountId());
        
        

    }
  
}
