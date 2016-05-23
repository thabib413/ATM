package BANKACCOUNT;

import java.util.Scanner;

/**
 * Created by taiseerhabib on 5/21/16.
 */
public class InputHandler {
    Scanner scanner = new Scanner(System.in);
    public int userInputWelcome;
    public int userInputAtm;
    public int userInputXfer;
    private String userName;
    private String password;
    private String customerName;
    public int initialBalance;
    public boolean linkAccount;
    public float savingsInterest;
    public String customerAuthenticated;
    private String authenticateUsername;
    private String authenticatePassword;
    public int tries;
    private float customerBalance;



    //User currentUser1 = new User();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void welcomeScreen (){
        System.out.println("Welcome to The BANK");
        System.out.println("Please press '1' to create username");
        System.out.println("Please press '2' to create Checking Account");
        System.out.println("Please press '3' to create Savings Account");
        System.out.println("Please press '4' to create Investment Account");
        System.out.println("Please press '5' to log in");
        System.out.println("Please press '6' to go to ATM menu");
        System.out.println("Please press '9' to exit or end current session");
        userInputWelcome = scanner.nextInt();

        if (userInputWelcome == 1){
            System.out.println("Please enter username:");
            userName = scanner.next();
            System.out.println("Please enter password:");
            userName = scanner.next();
            User cUser = new User();

            cUser.addNewUser(userName, password);
        }

        if(userInputWelcome == 2){
            System.out.println("Please Enter full name for the account: ");
            customerName = scanner.next();
            System.out.println("Please enter, initial balance");
            initialBalance = scanner.nextInt();
            Checking customerAccount = new Checking(customerName);
            System.out.println("");
            if(userName == null) {
                System.out.println("Please exit and create username first");
            } else {
                System.out.println("Link this checking account to "+ userName+", with name: "+customerName+"? (Please enter 'true' for yes and 'false' for no");
                linkAccount = scanner.nextBoolean();
                if(linkAccount) {
                    Account linkToAccount = new Account();
                    linkToAccount.addAccountsToUser(customerAccount.getAcctId());
                }
            }
            this.welcomeScreen();
        }

        if(userInputWelcome == 3){
            System.out.println("Please Enter full name for the account: ");
            customerName = scanner.next();
            System.out.println("Please enter, interest rate for savings account");
            savingsInterest = scanner.nextInt();
            System.out.println("Please enter, initial balance");
            initialBalance = scanner.nextInt();
            Savings customerAccount = new Savings(customerName);
            System.out.println("");
            if(userName == null) {
                System.out.println("Please exit and create username first");
            } else {
                System.out.println("Link this savings account to "+ userName+", with name: "+customerName+"? (Please enter 'true' for yes and 'false' for no");
                linkAccount = scanner.nextBoolean();
                if(linkAccount) {
                    Account linkToAccount = new Account();
                    linkToAccount.addAccountsToUser(customerAccount.getAcctId());
                }
            }
            this.welcomeScreen();
        }

        if(userInputWelcome == 4){
            System.out.println("Please Enter full name for the account: ");
            customerName = scanner.next();
            System.out.println("Please enter, initial balance");
            initialBalance = scanner.nextInt();
            Investment customerAccount = new Investment(customerName);
            System.out.println("");
            if(userName == null) {
                System.out.println("Please exit and create username first");
            } else {
                System.out.println("Link this investment account to "+ userName+", with name: "+customerName+"? (Please enter 'true' for yes and 'false' for no");
                linkAccount = scanner.nextBoolean();
                if(linkAccount) {
                    Account linkToAccount = new Account();
                    linkToAccount.addAccountsToUser(customerAccount.getAcctId());
                }
            }
            this.welcomeScreen();
        }

        if(userInputWelcome == 5){
            System.out.println("Please enter username to log in");
            authenticateUsername = scanner.next();
            tries = 0;
            while(authenticatePassword != userName && tries <=3){
                tries++;
                System.out.println("Please re-enter username");
                authenticateUsername = scanner.next();
            }

            System.out.println("please enter password");
            authenticatePassword = scanner.next();
            tries = 0;
            while(authenticatePassword != password){
                tries++;
                System.out.println("Please re-enter password");
                authenticatePassword = scanner.next();

            }
            this.welcomeScreen();
        }

        if (userInputWelcome == 6){
            this.atmMenu();
        }

        if (userInputWelcome == 9){
            System.exit(0);
        }



    }

    public void atmMenu(){
        System.out.println("The BANK ATM");
        System.out.println("Please press '1' to check balance");
        System.out.println("Please press '2' to withdraw");
        System.out.println("Please press '3' to deposit");
        System.out.println("Please press '4' to transfer");
        System.out.println("Please press '5' to print transfer log");
        System.out.println("Please press '6' to go to transfer menu (must have source/destination account numbers)");
        System.out.println("Please press '7' to go back to Welcome Screen");
        System.out.println("Please press '9' to exit or end current session");
        userInputAtm = scanner.nextInt();



        if(userInputAtm == 1) {
            System.out.println("please enter Account ID for balance retrieval");
            Account currentAccount = new Account();
            customerBalance = currentAccount.getBalance();



        }




        if (userInputWelcome == 6){
            this.transferUserInput();
        }

        if (userInputWelcome == 7){
            this.welcomeScreen();
        }

        if (userInputWelcome == 9){
            System.exit(0);
        }

    }

    public void transferUserInput(){
        System.out.println("Enter appropriate account info");
        System.out.println("Please press '1' to enter source account");
        System.out.println("Please press '2' to enter destination account");
        System.out.println("Please press '6' to go back to ATM menu");
        System.out.println("Please press '7' to go back to Welcome Screen");
        System.out.println("Please press '9' to exit or end current session");
        userInputXfer = scanner.nextInt();

        userInputAtm = scanner.nextInt();
        if (userInputWelcome == 6){
            this.atmMenu();
        }

        if (userInputWelcome == 7){
            this.welcomeScreen();
        }

        if (userInputWelcome == 9){
            System.exit(0);
        }
    }
}
