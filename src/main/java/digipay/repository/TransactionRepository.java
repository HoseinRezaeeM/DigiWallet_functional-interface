package digipay.repository;

import digipay.model.Transaction;

import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public interface TransactionRepository extends CrudRepository<Transaction,Long>{


}
