package BANKACCOUNT;

/**
 * Created by taiseerhabib on 5/19/16.
 */
public class Checking extends Account {

    public Checking (int acctId, String name, float amount){
        super(name);
        System.out.println("Checking account Number: "+acctId);

        /*
        this.setAcctId(acctId);
        super.setName(name);
        super.setBalance(amount);
        */
    }

    public Checking(String name) {
        super(name);
        int acctId = super.getAcctId();
        System.out.println("Checking account Number: "+ acctId);
    }

/*
    public Checking() {
        super.setAcctId(getAcctId());
        super.setName(getName());
        super.setBalance(getBalance());
    }
    */
}
