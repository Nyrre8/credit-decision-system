package se.eriknyberg.cds;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "kalp")
@Component
public class KalpProperties {

    private double flatTaxRate;
    private double livingCost;
    private double costPerCar;
    private double privateLoanCostMultiple;
    private double mortgageLoanCostMultiple;
    private double secondaryHousingCost;

    public double getFlatTaxRate() {
        return flatTaxRate;
    }

    public void setFlatTaxRate(double flatTaxRate) {
        this.flatTaxRate = flatTaxRate;
    }

    public double getLivingCost() {
        return livingCost;
    }

    public void setLivingCost(double livingCost) {
        this.livingCost = livingCost;
    }

    public double getCostPerCar() {
        return costPerCar;
    }

    public void setCostPerCar(double costPerCar) {
        this.costPerCar = costPerCar;
    }

    public double getPrivateLoanCostMultiple() {
        return privateLoanCostMultiple;
    }

    public void setPrivateLoanCostMultiple(double privateLoanCostMultiple) {
        this.privateLoanCostMultiple = privateLoanCostMultiple;
    }

    public double getMortgageLoanCostMultiple() {
        return mortgageLoanCostMultiple;
    }

    public void setMortgageLoanCostMultiple(double mortgageLoanCostMultiple) {
        this.mortgageLoanCostMultiple = mortgageLoanCostMultiple;
    }

    public double getSecondaryHousingCost() {
        return secondaryHousingCost;
    }

    public void setSecondaryHousingCost(double secondaryHousingCost) {
        this.secondaryHousingCost = secondaryHousingCost;
    }
}
