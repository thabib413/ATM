package BANKACCOUNT;

import org.junit.Assert;
import org.junit.Test;

//import static BANKACCOUNT.Account.Status.CLOSED;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class AccountSpec {

    @Test
    public void testAccountId(){
        Account testAcct = new Account("Bob");
        int actualId =  testAcct.getAcctId();
        Assert.assertEquals(true, actualId > 0);
        String expectedName = "Bob";
        String actualName = testAcct.getName();
        Assert.assertEquals(" ", expectedName, actualName);
        testAcct.setName("Tom");
        String actualName1 = testAcct.getName();
        Assert.assertEquals(" ", "Tom", actualName1);


    }
    @Test
    public void retrievingBalance(){
        Account testAcct = new Account("Test Name");
        float expectedBalance = testAcct.updateBalance(testAcct.getAcctId(), 100);
        float actualBalance = testAcct.getBalance();
        Assert.assertTrue(expectedBalance == actualBalance);
    }

    @Test
    public void settingBalance(){
        Account testAccount = new Account("Test Name");
        float expectedBalance = 100; //testChecking.getBalance();
        testAccount.setBalance(100);
        Assert.assertEquals(" ", expectedBalance, testAccount.getBalance(),0.1);
    }

    @Test
    public void updatingBalance(){
        Account testAccount = new Account("Test Name");

        float expectedBalance =100; //testChecking.setBalance(50);
        testAccount.updateBalance(testAccount.getAcctId(), 100);
        Assert.assertEquals(" ", expectedBalance, testAccount.getBalance(),0.1);
    }

    @Test
    public void trackingStatusClosedTest (){
        Account testAccount = new Account("Test Name");
        testAccount.setTrackStatus(Account.Status.CLOSED);
        Account.Status expectedStatus = Account.Status.CLOSED;
        Assert.assertEquals(" ", expectedStatus, testAccount.getTrackStatus());
    }

    @Test
    public void trackingStatusOpenTest (){
        Account testAccount = new Account("Test Name");
        testAccount.setTrackStatus(Account.Status.OPEN);
        Account.Status expectedStatus = Account.Status.OPEN;
        Assert.assertEquals(" ", expectedStatus, testAccount.getTrackStatus());
    }

    @Test
    public void trackingStatusOFACTest (){
        Account testAccount = new Account("Test Name");
        testAccount.setTrackStatus(Account.Status.OFAC);
        Account.Status expectedStatus = Account.Status.OFAC;
        Assert.assertEquals(" ", expectedStatus, testAccount.getTrackStatus());
    }

    @Test
    public void testAccountCheckingType (){
        Account testAccount = new Account("Test Name");
        testAccount.setAccountType(Account.AccountType.CHECKING);
        Account.AccountType expectedType = Account.AccountType.CHECKING;
        Assert.assertEquals(" ", expectedType, testAccount.getAccountType());
    }

    @Test
    public void testAccountSavingsType (){
        Account testAccount = new Account("Test Name");
        testAccount.setAccountType(Account.AccountType.SAVINGS);
        Account.AccountType expectedType = Account.AccountType.SAVINGS;
        Assert.assertEquals(" ", expectedType, testAccount.getAccountType());
    }

    @Test
    public void testAccountInvestmentType (){
        Account testAccount = new Account("Test Name");
        testAccount.setAccountType(Account.AccountType.INVESTMENT);
        Account.AccountType expectedType = Account.AccountType.INVESTMENT;
        Assert.assertEquals(" ", expectedType, testAccount.getAccountType());
    }

    @Test
    public void testOverDraftStatus(){
        Account testAccount = new Account("Test Name");
        boolean expectedOd = true;
        testAccount.setOverDraft(true);
        boolean actualOd = testAccount.getOverDraft();
        Assert.assertEquals(" ", expectedOd, actualOd);
    }

    @Test
    public void testInterestRate(){
        Account testAccount = new Account("Test Name");
        double expectedInterestRate = 1.2;
        testAccount.setInterestRate(expectedInterestRate);
        double actualInterestRate = testAccount.getInterestRate();
    }

    @Test
    public void testCreate(){
        Account testAccount = new Account("Test Name");
        testAccount.create(testAccount, (Account.Status.OPEN), Account.AccountType.CHECKING, true, 1.2, 102);
        double expectedInterestRate = 1.2;
        double actualInterestRate = testAccount.getInterestRate();
        Assert.assertEquals(" ", expectedInterestRate, actualInterestRate, 0.1);

    }

}
