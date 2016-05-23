package BANKACCOUNT;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class TransactionSpec {

    @Test

    public void testCredit(){


        Checking testChecking = new Checking(1, "Steve", 100);
        Transaction testTransaction = new Transaction();
        testChecking.setBalance(100);
        float expectedBalance = 150;
        float actualBalance = testTransaction.credit(testChecking, 50);

        Assert.assertEquals(" ", expectedBalance, actualBalance, 0.1);
    }

    @Test
    public void testDebit() {
        Checking testChecking = new Checking(1, "Steve", 100);
        Transaction testTransaction = new Transaction();
        testChecking.setBalance(100);
        float expectedBalance = 50;
        float actualBalance = testTransaction.debit(testChecking, 50);
        Assert.assertEquals(" ", expectedBalance, actualBalance, 0.1);
    }

    @Test
    public void transferTest(){
        Checking testSourceChecking = new Checking(1, "Steve", 100);
        Checking testDestinationChecking = new Checking(1, "Steve", 500);
        testSourceChecking.setOverDraft(false);
        Transaction testTransaction = new Transaction();
        boolean transferSucces = testTransaction.transferFunds(testSourceChecking, testDestinationChecking, 50);
        Assert.assertTrue(transferSucces);
    }

    @Test
    public void transactionLogTest() {
        Checking testChecking = new Checking(1, "Steve", 100);
        Transaction testTransaction = new Transaction();
        testChecking.setBalance(100);
        float expectedCreditBalance = 150;
        float actualCreditBalance = testTransaction.credit(testChecking, 50);
        float expectedDebitBalance = 50;
        float actualDebitBalance = testTransaction.debit(testChecking, 50);
        Checking testSourceChecking = new Checking(1, "Steve", 100);
        Checking testDestinationChecking = new Checking(1, "Steve", 500);
        testSourceChecking.setOverDraft(false);
        boolean transferSucces = testTransaction.transferFunds(testSourceChecking, testDestinationChecking, 50);

        testTransaction.printTransactionLog();
    }
}
