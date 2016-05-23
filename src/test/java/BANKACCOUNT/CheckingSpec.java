package BANKACCOUNT;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class CheckingSpec {
    @Test
    public void testCheckingAccountCreation() {
        Checking testCheking = new Checking("TestName");
        String expectedName = "TestName";
        String actualName = testCheking.name;
        Assert.assertEquals(expectedName, actualName);
        Date testDate = new Date();
        String printDate = testDate.toString();
        System.out.println("time stamp: "+printDate);
    }






}
