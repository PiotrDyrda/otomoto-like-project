package JAVA_otomoto_like.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private Date employementDate;

    public Employee(){
    }

    public Employee(String name, String surname, String address, Date employementDate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.employementDate = employementDate;
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

    public Date getEmployementDate() {
        return employementDate;
    }

    public void setEmployementDate(Date employementDate) {
        this.employementDate = employementDate;
    }
}
