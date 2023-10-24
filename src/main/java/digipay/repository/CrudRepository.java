package digipay.repository;

import digipay.model.Transaction;

import java.util.List;
import java.util.function.Predicate;
@SuppressWarnings("unused")
public interface CrudRepository<T extends Transaction, ID extends Long> {
    boolean add(T t);

    List<T> getAll();

    List<T> get(ID id);

    List<T> get(Predicate<T> predicate);

}
