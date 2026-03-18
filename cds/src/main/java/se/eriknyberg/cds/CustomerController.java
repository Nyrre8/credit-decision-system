package se.eriknyberg.cds;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<>();

    @GetMapping("/api/customers")
    public List<Customer> customers() {
        return customers;
    }

    @PostMapping("/api/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @GetMapping("/api/customers/{id}")
    public Customer searchCustomer(@PathVariable String id) {

        return customers.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    @DeleteMapping("/api/customers/{id}")
    public Customer deleteCustomer(@PathVariable String id) {

        Customer foundCustomer = customers.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundCustomer != null) {
            customers.remove(foundCustomer);
        }

        return foundCustomer;

    }


}
