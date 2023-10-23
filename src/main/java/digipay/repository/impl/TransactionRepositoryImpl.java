package digipay.repository.impl;

import digipay.model.Transaction;
import digipay.repository.TransactionRepository;

import java.util.List;
import java.util.function.Predicate;
@SuppressWarnings("unused")
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public boolean add(Transaction transaction) {
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public Transaction get(Long aLong) {
        return null;
    }

    @Override
    public List<Transaction> get(Predicate<Transaction> predicate) {
        return null;
    }
}
