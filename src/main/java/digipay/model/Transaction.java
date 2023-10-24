package digipay.model;

import digipay.model.enumeration.TransactionStatus;
import digipay.model.enumeration.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
@SuppressWarnings("unused")
public class Transaction {
    private Long id;
    private Wallet wallet;
    private TransactionType type;
    private BigDecimal amount;
    private Date createdAt;
    private TransactionStatus status;
    private Date updatedAt;

    public Transaction(Long id, Wallet wallet, TransactionType type, BigDecimal amount, Date createdAt, TransactionStatus status) {
        this.id = id;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
        this.status =TransactionStatus.PENDING;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "id=" + id +
                ", wallet " + wallet +
                ", type=" + type +
                ", amount=" + amount +
                ", status=" + status +
                '}'+"\n";
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
        updatedAt =new Date();

    }

}
