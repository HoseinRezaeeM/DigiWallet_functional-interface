package digipay.service;

import digipay.model.Transaction;
import digipay.model.TransactionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AdminWalletService extends WalletService {

    public List<Transaction> getTransactions(Predicate<Transaction> predicate) {
        List<Transaction> transactionList =new ArrayList<>();
        Transaction transaction =new Transaction();
        if(transaction.getStatus()==TransactionStatus.PENDING){
            return transactionList;
        }
        return null;
    }
    public  List<Transaction> getAllTransactions(){
        return null;
    }
}
