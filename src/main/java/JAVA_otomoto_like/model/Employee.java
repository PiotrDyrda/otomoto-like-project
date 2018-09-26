package JAVA_otomoto_like.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee_id")
    private Invoice invoice_id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private Date employmentDate;

    public Employee(){
    }

    public Employee(String name, String surname, String address, Date employmentDate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.employmentDate = employmentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }
}
