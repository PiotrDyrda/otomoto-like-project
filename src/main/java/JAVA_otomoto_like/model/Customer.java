package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {

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
    private Integer nipNumber;

    @Column
    private Integer idNumber;

    public Customer(String name, String surname, String address, Integer nipNumber, Integer idNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.nipNumber = nipNumber;
        this.idNumber = idNumber;
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

    public Integer getNipNumber() {
        return nipNumber;
    }

    public void setNipNumber(Integer nipNumber) {
        this.nipNumber = nipNumber;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }
}
