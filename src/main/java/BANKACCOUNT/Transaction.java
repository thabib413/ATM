package BANKACCOUNT;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class Transaction {

    ArrayList<String> transactionLog = new ArrayList<String>(1);

    String debitTimeStamp;
    String creditTimeStamp;
    String transferTimeStamp;





    protected float debit (Account currentAccount, float amount) {

        Date date = new Date();
        debitTimeStamp = "Debit for amount $"+amount+" completed at "+date.toString()+"\n";
        transactionLog.add(debitTimeStamp);

        if (currentAccount.getOverDraft()){
            float targetBalance = currentAccount.updateBalance(currentAccount.getAcctId(), 0);
            return (targetBalance);
        }else{
            if(amount < 0) {amount = amount * -1;}
            float targetBalance = currentAccount.updateBalance(currentAccount.getAcctId(), - amount);
            return targetBalance;
        }
    }

    protected float credit (Account currentAccount, float amount){

        Date date = new Date();
        creditTimeStamp = "Credit for amount $"+amount+" completed at "+date.toString()+"\n";
        transactionLog.add(creditTimeStamp);

        if(amount < 0) {amount = amount * -1; }
        float targetBalance = currentAccount.updateBalance(currentAccount.getAcctId(), amount);
        return targetBalance;
    }

    public boolean transferFunds(Account sourceAccount, Account destinationAccount, double transferAmount) {

        Date date = new Date();
        transferTimeStamp = "Transfer for amount $"+transferAmount+" completed at "+date.toString()+"\n";
        transactionLog.add(transferTimeStamp);

        boolean sourceAccountTransferRelease = (((sourceAccount.getOverDraft()) && (sourceAccount.getBalance() > transferAmount)) || (!sourceAccount.getOverDraft()));
        boolean destinationAccountTransferRelease = (destinationAccount.getTrackStatus() == Account.Status.OPEN);
        if(sourceAccountTransferRelease && destinationAccountTransferRelease) {
            this.credit(destinationAccount, (float) transferAmount);
            return true;
        } else{
            return false;
        }
    }


    public void printTransactionLog(){
        System.out.println(transactionLog+"\n");
    }

/*
    public float updateBalance(int acctId, float amount){
        return balance += amount;
    }
*/

}
