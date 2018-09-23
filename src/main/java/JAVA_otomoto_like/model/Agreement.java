package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Agreement {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Transaction transaction;

    @Column
    private Salesman salesman;

    @Column
    private Customer customer;

    @Column
    private Vehicle vehicle;

    @Column
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
