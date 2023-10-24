package digipay.repository.impl;

import digipay.model.Transaction;
import digipay.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class TransactionRepositoryImpl implements TransactionRepository {
    public final static List<Transaction> transactionList = new ArrayList<>();

    @Override
    public boolean add(Transaction transaction) {
        transactionList.add(transaction);
        if (transactionList.contains(transaction)) {
            return false;
        } else
            return true;
    }

    @Override
    public List<Transaction> getAll() {
        return transactionList;
    }

    @Override
    public List<Transaction> get(Long aLong) {
        return transactionList.stream().filter((a) -> a.getId().equals(aLong)).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> get(Predicate<Transaction> predicate) {
        return transactionList.stream().filter(predicate).collect(Collectors.toList());

    }
}
