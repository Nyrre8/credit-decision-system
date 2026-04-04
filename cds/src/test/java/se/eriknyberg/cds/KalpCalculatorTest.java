package se.eriknyberg.cds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KalpCalculatorTest {

    KalpProperties kalpProperties = Mockito.mock(KalpProperties.class);
    LtvCalculator ltvCalculator = Mockito.mock(LtvCalculator.class);
    Customer customer = new Customer();

    @BeforeEach
    void setUp() {


        Mockito.when(kalpProperties.getFlatTaxRate()).thenReturn(0.25);
        Mockito.when(kalpProperties.getLivingCost()).thenReturn(8000.0);
        Mockito.when(kalpProperties.getCostPerCar()).thenReturn(2300.0);
        Mockito.when(kalpProperties.getPrivateLoanCostMultiple()).thenReturn(0.12);
        Mockito.when(kalpProperties.getMortgageLoanCostMultiple()).thenReturn(0.07);
        Mockito.when(kalpProperties.getSecondaryHousingCost()).thenReturn(1500.0);
        Mockito.when(kalpProperties.getAmortizationRateOne()).thenReturn(0.01);
        Mockito.when(kalpProperties.getAmortizationRateTwo()).thenReturn(0.02);



        customer.setId("1");
        customer.setName("Testing Once Again Testing");
        customer.setPersonalNumber("199001011234");
        customer.setMonthlySalary(45000);
        customer.setPrivateLoanAmount(50000);
        customer.setMortgageLoanAmount(1750000);
        customer.setStudyLoanMonthlyPayment(1200);
        customer.setNumberOfCars(1);
        customer.setNumberOfSecondaryHousing(0);
        customer.setPrimaryHousingCost(8000);
        customer.setPropertyValue(2500000);
    }

    @Test
    void shouldApplyOnePercentAmortizationWhenLtvEqualOrBelow70() {



        KalpCalculator kc = new KalpCalculator(kalpProperties, ltvCalculator);
        Mockito.when(ltvCalculator.calculate(customer)).thenReturn(0.70);
        KalpResult result = kc.calculate(customer);

        assertEquals(KalpDecision.APPROVED, result.getDecision());
        assertEquals(2083.33, result.getKalpAmount(), 0.01);


    }

    @Test
    void shouldApplyTwoPercentAmortizationWhenLtvIsAbove70() {


        KalpCalculator kc = new KalpCalculator(kalpProperties, ltvCalculator);
        Mockito.when(ltvCalculator.calculate(customer)).thenReturn(0.701);
        KalpResult result = kc.calculate(customer);

        assertEquals(KalpDecision.APPROVED, result.getDecision());
        assertEquals(624.99, result.getKalpAmount(), 0.01);


    }

}
