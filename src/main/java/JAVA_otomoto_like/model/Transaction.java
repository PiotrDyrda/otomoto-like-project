package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private TransactionType transactionType;

    @Column
    private Date transactionDate;

    @Column
    private Integer value;

    public Transaction(TransactionType transactionType, Date transactionDate, Integer value) {
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
