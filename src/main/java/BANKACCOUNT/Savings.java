package BANKACCOUNT;

/**
 * Created by taiseerhabib on 5/19/16.
 */
public class Savings extends Account {

    public Savings (int acctId, String name, float amount, double interestRate) {
        super(name);
    }

    public Savings(String name) {
        super(name);
    }

}
