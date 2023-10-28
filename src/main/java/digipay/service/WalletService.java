package digipay.service;

import digipay.model.Transaction;
import digipay.model.enumeration.TransactionStatus;
import digipay.model.Wallet;
import digipay.model.enumeration.TransactionType;
import digipay.repository.impl.TransactionRepositoryImpl;
import jdk.jfr.internal.StringPool;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class WalletService {
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    public boolean addTransaction(Transaction transaction) {
        return transactionRepository.add(transaction);
    }

    public List<Transaction> getTransactions(Wallet wallet) {
        return transactionRepository.getAll().stream().
                filter((a) -> a.getWallet().equals(wallet)).
                collect(Collectors.toList());
    }

    public void getTransactions(Wallet wallet, Predicate<Transaction> predicate) {
        transactionRepository.getAll().stream()
                .filter((a) -> a.getWallet().equals(wallet))
                .filter(predicate).collect(Collectors.toList())
                .forEach(System.out::println);
    }


    public BigDecimal getBalance(Wallet wallet) {
        final Optional<BigDecimal> reduceDeposit = transactionRepository.getAll().stream()
                .filter((a) -> a.getWallet().equals(wallet))
                .filter((a) -> a.getStatus().equals(TransactionStatus.ACCEPTED))
                .filter((a) -> a.getType().equals(TransactionType.DEPOSIT))
                .map(Transaction::getAmount).reduce(BigDecimal::add);

        final Optional<BigDecimal> reduceWidthraw = transactionRepository.getAll().stream()
                .filter((a) -> a.getWallet().equals(wallet))
                .filter((a) -> a.getStatus().equals(TransactionStatus.ACCEPTED))
                .filter((a) -> a.getType().equals(TransactionType.WITHDRAWAL))
                .map(Transaction::getAmount).reduce(BigDecimal::add);

        BigDecimal subtract = null;

        if (reduceWidthraw.isPresent()) {
            if (reduceDeposit.isPresent()) {
                subtract = reduceDeposit.get().subtract(reduceWidthraw.get());
                if (subtract.intValue() < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return subtract;
    }

    public boolean setTransactionStatus(Transaction transaction, TransactionStatus status) {
        if (transaction.getStatus().equals(TransactionStatus.PENDING) ||
                status.equals(TransactionStatus.PENDING)) {
            return false;
        } else if (transaction.getType().equals(TransactionType.WITHDRAWAL) &&
                getBalance(transaction.getWallet()).intValue() < transaction.getAmount().intValue()) {
            throw new IllegalArgumentException(); //uncheck Exception

            
        } else
            transaction.setStatus(status);
        return true;


    }
}