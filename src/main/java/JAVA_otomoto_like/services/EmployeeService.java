package JAVA_otomoto_like.services;

import JAVA_otomoto_like.model.Employee;
import JAVA_otomoto_like.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public Employee save (Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete (Employee employee){
        employeeRepository.delete(employee);
    }
}
