package digipay.model;

import java.math.BigDecimal;
import java.util.Date;
@SuppressWarnings("unused")
public class Transaction {
    private long id;
    private Wallet wallet;
    private TransactionType type;
    private BigDecimal amount;
    private Date createdAt;
    private TransactionStatus status;
    private Date updatedAt;

    public Transaction(long id, Wallet wallet, TransactionType type, BigDecimal amount, Date createdAt, TransactionStatus status) {
        this.id = id;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
        this.status = TransactionStatus.PENDING;
    }


    public void setStatus(TransactionStatus status) {
        this.status = status;
        updatedAt =new Date();
    }
}
