package JAVA_otomoto_like.model;

import javax.persistence.*;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction_id;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "agreement")
    private Invoice invoice_id;

    @Column
    @Transient
    private Transaction transaction;

    @Column
    @Transient
    private Salesman salesman;

    @Column
    @Transient
    private Customer customer;

    @Column
    @Transient
    private Vehicle vehicle;

    @Column
    @Transient
    private Invoice invoice;

    @Column
    private String description;

    public Agreement(Transaction transaction, Salesman salesman, Customer customer, Vehicle vehicle, Invoice invoice, String description) {
        this.transaction = transaction;
        this.salesman = salesman;
        this.customer = customer;
        this.vehicle = vehicle;
        this.invoice = invoice;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
