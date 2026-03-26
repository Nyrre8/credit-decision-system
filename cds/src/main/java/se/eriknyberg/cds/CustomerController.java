package se.eriknyberg.cds;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<Customer> customers() {

        return customerService.getAll();
    }

    @PostMapping("/api/customers")
    public Customer newCustomer(@RequestBody Customer customer) {

        return customerService.saveCustomer(customer);
    }

    @GetMapping("/api/customers/{id}")
    public Customer searchCustomer(@PathVariable String id) {

        return customerService.getById(id).orElse(null);
    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
    }

    @GetMapping("/api/customers/{id}/kalp")
    public KalpResult kalpResult(@PathVariable String id) {
        return customerService.calculateKalp(id);
    }


}



