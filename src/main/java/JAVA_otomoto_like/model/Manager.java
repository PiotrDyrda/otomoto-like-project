package JAVA_otomoto_like.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Manager extends Employee {

    @OneToMany(mappedBy = "manager_id")
    private List<Transaction> transactions;

}
