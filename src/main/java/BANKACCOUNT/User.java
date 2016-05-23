package BANKACCOUNT;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by taiseerhabib on 5/21/16.
 */
public class User {

    String userName;
    String password;
    private TreeMap<String, String> userAccounts = new TreeMap<String, String>();
    Account bankAccounts = new Account();

    ArrayList<String> userAccountList = new ArrayList<String>(1);
    TreeMap<User, ArrayList<String>> userBankAccounts = new TreeMap<User, ArrayList<String>>();


    InputHandler currentInputHandler = new InputHandler();

    public void addNewUser(String username, String pwd) {
        userName = username;
        password = pwd;
        userAccounts.put(userName, password);
        currentInputHandler.welcomeScreen();
    }

    public void linkUserAndBankAccounts(User user, ArrayList<String> bankAccounts){
        userBankAccounts.put(user, bankAccounts);
    }


}
