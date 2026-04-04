package se.eriknyberg.cds;

import org.springframework.stereotype.Service;

@Service
public class LtvCalculator {


    public double calculate(Customer customer) {
        double propertyValue = customer.getPropertyValue();
        double mortgageLoanAmount = customer.getMortgageLoanAmount();

        double ltv = mortgageLoanAmount / propertyValue;
        return Math.round(ltv * 100) / 100;
    }
}
