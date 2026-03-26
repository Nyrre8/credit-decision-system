package se.eriknyberg.cds;


import org.springframework.stereotype.Service;

@Service
public class KalpCalculator {

    private final KalpProperties kalpProperties;

    public KalpCalculator(KalpProperties kalpProperties) {
        this.kalpProperties = kalpProperties;
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

        double kalp = netIncome - livingCost - carCost - privateLoanCost - studyLoanCost - secondaryHousingCost - primaryHousingCost - mortgageLoanCost;

        KalpDecision decision = kalp >= 0 ? KalpDecision.APPROVED : KalpDecision.DENIED;
        return new KalpResult(kalp, decision);

    }


}
