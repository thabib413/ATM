package BANKACCOUNT;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class Account {

    private int acctId;

    public Account() {
        setAcctId(getAcctId());
        setName(getName());
        setBalance(getBalance());
    }


    public int getAcctId() {
        return acctId;
    }
    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public Account(String n){
        acctId = getNewAcct();
        setName(n);
    }


    public String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private float balance=0;
    private boolean overDraft;
    private double interestRate;
    //public Status testStat = Status.OPEN;
    AccountType userAccountType;


    enum AccountType {
        CHECKING, SAVINGS, INVESTMENT
    }

    public AccountType accountType;
    public AccountType checkingAccount = AccountType.CHECKING;


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    enum Status {
        OPEN, CLOSED, OFAC, FREEZE
    }

    public Status trackStatus = Status.OPEN;

    public Status getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(Status trackStatus) {
        this.trackStatus = trackStatus;
    }

    private ArrayList<String> accountLists = new ArrayList<String>();

    public ArrayList<String> getAccountLists() {
        return accountLists;
    }

    public void setAccountLists(ArrayList<String> accountLists) {
        this.accountLists = accountLists;
    }



    private int getNewAcct(){
        Random rand = new Random();
        return rand.nextInt(999999999);
    }


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float updateBalance(int acctId, float amount){
        return balance += amount;
    }



    public void setOverDraft(boolean overDraft) {
        this.overDraft = overDraft;
    }

    public boolean getOverDraft() {
        return overDraft;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    InputHandler currentInputHandler = new InputHandler();

    public void create (Account acct, Status stat, AccountType acctType, boolean od, double ir, float amount){



        this.setAcctId(acct.getNewAcct());
        this.setTrackStatus(stat);
        if(currentInputHandler.userInputWelcome == 2){
            userAccountType = AccountType.CHECKING;
            acct.setAccountType(acctType);
            Checking newChecking = new Checking(getAcctId(), getName(), amount);
        }

        if(currentInputHandler.userInputWelcome == 3){
            userAccountType = AccountType.SAVINGS;
            acct.setAccountType(acctType);
            Savings newSavings = new Savings(getAcctId(), getName(), amount, getInterestRate());
        }

        if(currentInputHandler.userInputWelcome == 4){
            userAccountType = AccountType.INVESTMENT;
            acct.setAccountType(acctType);
            Investment newInvestment = new Investment(getAcctId(), getName(), amount);
        }

        this.setAccountType(acctType);
        this.setOverDraft(od);
        this.setInterestRate(ir);
        this.setBalance(amount);
    }

    public void addAccountsToUser(int acctId){
        String acctIdString = Integer.toString(acctId);
        accountLists.add(acctIdString);

    }


}
