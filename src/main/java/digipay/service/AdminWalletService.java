package digipay.service;

import digipay.model.Transaction;
import digipay.model.enumeration.TransactionStatus;
import digipay.repository.impl.TransactionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdminWalletService extends WalletService {
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    public List<Transaction> getTransactions(Predicate<Transaction> predicate) {
        return transactionRepository.getAll().stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll();
    }
}
