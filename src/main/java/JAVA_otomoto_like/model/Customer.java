package JAVA_otomoto_like.model;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private Integer nipNumber;

    @Column
    private String hashPassword;

    @Column
    private String email;

    public Customer() {
    }

    public Customer(String name, String surname, String address, Integer nipNumber, String hashPassword, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.nipNumber = nipNumber;
        this.hashPassword = BCrypt.hashpw(hashPassword,BCrypt.gensalt(12));
        this.email = email;
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

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = BCrypt.hashpw(hashPassword,BCrypt.gensalt(12));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
