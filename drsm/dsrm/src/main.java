
import controller.AccountManager;
import view.ConsoleUI;



public class main {

    public static void main(String[] args) {
        
        ConsoleUI con = new ConsoleUI();
        AccountManager manager = new AccountManager();
        manager.menuHandler();
        //con.dispayConsole();
    }
    
}
