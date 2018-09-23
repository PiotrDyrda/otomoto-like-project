package JAVA_otomoto_like.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Customer customer;

    @Column
    private Salesman salesman;

    @Column
    private Integer value;

    @Column
    private Date date;

    public Invoice(Customer customer, Salesman salesman, Integer value, Date date) {
        this.customer = customer;
        this.salesman = salesman;
        this.value = value;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
