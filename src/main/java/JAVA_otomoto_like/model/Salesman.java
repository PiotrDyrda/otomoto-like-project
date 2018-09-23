package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Salesman extends Employee {

    @Column
    private Integer salesmanNumber;

    @OneToMany(mappedBy = "salesman_id")
    private List<Transaction> transactions;

    public Salesman(String name, String surname, String address, Date employementDate, Integer salesmanNumber) {
        super(name, surname, address, employementDate);
        this.salesmanNumber = salesmanNumber;
    }

    public Integer getSalesmanNumber() {
        return salesmanNumber;
    }

    public void setSalesmanNumber(Integer salesmanNumber) {
        this.salesmanNumber = salesmanNumber;
    }
}
