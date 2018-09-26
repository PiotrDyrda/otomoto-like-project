package JAVA_otomoto_like.repositories;

import JAVA_otomoto_like.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
