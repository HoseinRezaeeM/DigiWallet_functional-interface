package digipay.service;

import digipay.model.Transaction;
import digipay.model.TransactionStatus;
import digipay.model.Wallet;

import java.math.BigDecimal;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class WalletService {

    public boolean addTransaction(Transaction transaction) {
        return true;
    }
    public Transaction getTransactions(Wallet wallet){

        return null;
    }
    public void getTransactions(Wallet wallet, Predicate<Transaction> predicate){

    }
    public BigDecimal getBalance(Wallet wallet){
        return null;
    }
    public boolean setTransactionStatus(Transaction transaction, TransactionStatus status){
        return true;
    }


}
