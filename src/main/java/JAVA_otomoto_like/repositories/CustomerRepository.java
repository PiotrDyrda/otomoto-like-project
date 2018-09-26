package JAVA_otomoto_like.repositories;

import JAVA_otomoto_like.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
