package JAVA_otomoto_like.services;

import JAVA_otomoto_like.model.Customer;
import JAVA_otomoto_like.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public Customer getByUsername(String username) {
        Optional<Customer> customer = customerRepository.findByEmail(username);
        return customer.orElse(null);
    }
}

