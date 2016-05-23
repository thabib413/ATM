package BANKACCOUNT;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taiseerhabib on 5/21/16.
 */
public class UserSpec {

    @Test
    public void testCreateUserAccount(){
        User testUser = new User();
        testUser.addNewUser("testUser", "123");
        String excpectedUser = "testUser";
        String expectedPwd = "123";
        String actualUser = testUser.userName;
        String actualPwd = testUser.password;
        Assert.assertEquals(excpectedUser, actualUser);
        Assert.assertEquals(expectedPwd, actualPwd);
    }

    @Test
    public void addBankAccounts(){
/*
        InputHandler testHandler = new InputHandler();
        User testUser = new User();
        testHandler.userInputWelcome = 2;
        //Account testAccount = new Account("TestName");
        Checking testAccount = new Checking("TestName");
        testUser.bankAccounts.create(testAccount, Account.Status.OPEN , Account.AccountType.CHECKING, true, 0, 100);
        int expectedCheckingAccount = testAccount.getAcctId();
        int actualCheckingAccount = testAccount.getAcctId();
        System.out.println(testAccount.getAcctId());
        Assert.assertEquals(expectedCheckingAccount, actualCheckingAccount);

        */
    }
}
