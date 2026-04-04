package se.eriknyberg.cds;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String personalNumber;
    private int monthlySalary;
    private int privateLoanAmount;
    private int mortgageLoanAmount;
    private int studyLoanMonthlyPayment;
    private int numberOfCars;
    private int numberOfSecondaryHousing;
    private int primaryHousingCost;


    private int propertyValue;


    public Customer() {
    }

    public Customer(String id, String name, String personalNumber, int monthlySalary, int privateLoanAmount, int mortgageLoanAmount, int studyLoanMonthlyPayment, int numberOfCars,
                    int numberOfSecondaryHousing, int primaryHousingCost, int propertyValue) {
        this.id = id;
        this.name = name;
        this.personalNumber = personalNumber;
        this.monthlySalary = monthlySalary;
        this.privateLoanAmount = privateLoanAmount;
        this.mortgageLoanAmount = mortgageLoanAmount;
        this.studyLoanMonthlyPayment = studyLoanMonthlyPayment;
        this.numberOfCars = numberOfCars;
        this.numberOfSecondaryHousing = numberOfSecondaryHousing;
        this.primaryHousingCost = primaryHousingCost;
        this.propertyValue = propertyValue;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getPrivateLoanAmount() {
        return privateLoanAmount;
    }

    public void setPrivateLoanAmount(int privateLoanAmount) {
        this.privateLoanAmount = privateLoanAmount;
    }

    public int getMortgageLoanAmount() {
        return mortgageLoanAmount;
    }

    public void setMortgageLoanAmount(int mortgageLoanAmount) {
        this.mortgageLoanAmount = mortgageLoanAmount;
    }

    public int getStudyLoanMonthlyPayment() {
        return studyLoanMonthlyPayment;
    }

    public void setStudyLoanMonthlyPayment(int studyLoanMonthlyPayment) {
        this.studyLoanMonthlyPayment = studyLoanMonthlyPayment;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public int getNumberOfSecondaryHousing() {
        return numberOfSecondaryHousing;
    }

    public void setNumberOfSecondaryHousing(int numberOfSecondaryHousing) {
        this.numberOfSecondaryHousing = numberOfSecondaryHousing;
    }

    public int getPrimaryHousingCost() {
        return primaryHousingCost;
    }

    public void setPrimaryHousingCost(int primaryHousingCost) {
        this.primaryHousingCost = primaryHousingCost;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }


}

