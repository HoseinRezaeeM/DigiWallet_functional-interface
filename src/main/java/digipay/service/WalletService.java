package digipay.service;

import digipay.model.Transaction;
import digipay.model.enumeration.TransactionStatus;
import digipay.model.Wallet;
import digipay.repository.impl.TransactionRepositoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class WalletService {
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    public boolean addTransaction(Transaction transaction) {
        return transactionRepository.add(transaction);
    }

    public List<Transaction> getTransactions(Wallet wallet) {
        return transactionRepository.getAll().stream().filter((a)->a.getWallet().equals(wallet)).collect(Collectors.toList()) ;
    }

    public void getTransactions(Wallet wallet, Predicate<Transaction> predicate) {

    }

    public BigDecimal getBalance(Wallet wallet) {
        return null;
    }

    public boolean setTransactionStatus(Transaction transaction, TransactionStatus status) {
        return true;
    }


}
