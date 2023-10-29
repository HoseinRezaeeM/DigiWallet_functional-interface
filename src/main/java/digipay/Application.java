package digipay;

import digipay.model.Transaction;
import digipay.model.enumeration.TransactionStatus;
import digipay.model.enumeration.TransactionType;
import digipay.model.Wallet;
import digipay.repository.TransactionRepository;
import digipay.repository.impl.TransactionRepositoryImpl;
import digipay.service.AdminWalletService;



import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {

        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        AdminWalletService adminWalletService = new AdminWalletService();

        Wallet wallet = new Wallet("x-y-z");
        Wallet wallet1 = new Wallet("p-c-z");
        Wallet wallet2 = new Wallet("i-a-z");
        Wallet wallet3 = new Wallet("t-w-z");
        Transaction transaction = new Transaction(1L, wallet, TransactionType.DEPOSIT, new BigDecimal(1000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction1 = new Transaction(2L, wallet1, TransactionType.DEPOSIT, new BigDecimal(4000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction2 = new Transaction(3L, wallet2, TransactionType.WITHDRAWAL, new BigDecimal(5000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction3 = new Transaction(4L, wallet3, TransactionType.WITHDRAWAL, new BigDecimal(7000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction4 = new Transaction(5L, wallet, TransactionType.WITHDRAWAL, new BigDecimal(8000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction5 = new Transaction(2L, wallet2, TransactionType.DEPOSIT, new BigDecimal(7000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        Transaction transaction6 = new Transaction(1L, wallet1, TransactionType.WITHDRAWAL, new BigDecimal(100), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        transaction.setStatus(TransactionStatus.ACCEPTED);
        transaction1.setStatus(TransactionStatus.ACCEPTED);
        transaction2.setStatus(TransactionStatus.ACCEPTED);
        transaction3.setStatus(TransactionStatus.ACCEPTED);
        transaction4.setStatus(TransactionStatus.ACCEPTED);
        transaction5.setStatus(TransactionStatus.ACCEPTED);
        transactionRepository.add(transaction);
        transactionRepository.add(transaction1);
        transactionRepository.add(transaction2);
        transactionRepository.add(transaction3);
        transactionRepository.add(transaction4);
        transactionRepository.add(transaction5);
        transactionRepository.add(transaction6);

       

        Predicate<Transaction> transactionPredicate = (a) -> a.getWallet().equals(wallet1);
        System.out.println(adminWalletService.getTransactions(transactionPredicate));

        System.out.println(adminWalletService.getAllTransactions());
        System.out.println(adminWalletService.addTransaction(transaction));

        System.out.println(adminWalletService.getAllTransactions());

        System.out.println(adminWalletService.getBalance(wallet2));
        Transaction transaction7 =new Transaction(2L, wallet2, TransactionType.WITHDRAWAL, new BigDecimal(7000), new Date(2020 - 2 - 2), TransactionStatus.ACCEPTED);
        transaction7.setStatus(TransactionStatus.ACCEPTED);
        System.out.println(transaction7.getUpdatedAt());

        System.out.println(adminWalletService.setTransactionStatus(transaction,TransactionStatus.PENDING));
        System.out.println(adminWalletService.setTransactionStatus(transaction7,TransactionStatus.ACCEPTED));



    }
}
