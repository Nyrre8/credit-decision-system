package se.eriknyberg.cds;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final KalpCalculator kalpCalculator;

    public CustomerService(CustomerRepository customerRepository, KalpCalculator kalpCalculator) {
        this.customerRepository = customerRepository;
        this.kalpCalculator = kalpCalculator;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(String id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public KalpResult calculateKalp(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
        return kalpCalculator.calculate(customer);
    }

    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
