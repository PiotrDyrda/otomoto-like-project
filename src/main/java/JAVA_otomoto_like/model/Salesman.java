package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Salesman extends Employee {

    @Column
    private Integer salesmanNumber;

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
