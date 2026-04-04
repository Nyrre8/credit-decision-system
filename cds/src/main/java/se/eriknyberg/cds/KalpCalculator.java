package se.eriknyberg.cds;


import org.springframework.stereotype.Service;

@Service
public class KalpCalculator {

    private final KalpProperties kalpProperties;
    private final LtvCalculator ltvCalculator;


    public KalpCalculator(KalpProperties kalpProperties, LtvCalculator ltvCalculator) {
        this.kalpProperties = kalpProperties;
        this.ltvCalculator = ltvCalculator;
    }

    public KalpResult calculate(Customer customer) {
        double netIncome = customer.getMonthlySalary() * (1 - kalpProperties.getFlatTaxRate());
        double livingCost = kalpProperties.getLivingCost();
        double carCost = customer.getNumberOfCars() * kalpProperties.getCostPerCar();
        double privateLoanCost = customer.getPrivateLoanAmount() * kalpProperties.getPrivateLoanCostMultiple() / 12;
        double studyLoanCost = customer.getStudyLoanMonthlyPayment();
        double secondaryHousingCost = customer.getNumberOfSecondaryHousing() * kalpProperties.getSecondaryHousingCost();
        double primaryHousingCost = customer.getPrimaryHousingCost();
        double mortgageLoanCost = customer.getMortgageLoanAmount() * kalpProperties.getMortgageLoanCostMultiple() / 12;
        double ltv = ltvCalculator.calculate(customer);


        double amortizationRate = ltv > 0.70 ? kalpProperties.getAmortizationRateTwo() : kalpProperties.getAmortizationRateOne();
        double amortizationCost = customer.getMortgageLoanAmount() * amortizationRate / 12;


        double kalp = netIncome - livingCost - carCost - privateLoanCost - studyLoanCost - secondaryHousingCost - primaryHousingCost - mortgageLoanCost - amortizationCost;

        KalpDecision decision = kalp >= 0 ? KalpDecision.APPROVED : KalpDecision.DENIED;
        return new KalpResult(kalp, decision);

    }


}
