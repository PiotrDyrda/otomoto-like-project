package JAVA_otomoto_like.services;

import JAVA_otomoto_like.model.Customer;
import JAVA_otomoto_like.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).get();
    }

    public void save(Customer updatedCustomer) {
        customerRepository.save(updatedCustomer);
    }

    public void delete(Integer id) {
        Customer customer = getCustomer(id);
        customerRepository.deleteById(customer.getId());
    }
}