package se.eriknyberg.cds;

public class KalpResult {
    private double kalpAmount;
    private KalpDecision decision;

    public KalpResult(double kalpAmount, KalpDecision decision) {
        this.kalpAmount = kalpAmount;
        this.decision = decision;
    }

    public double getKalpAmount() {
        return kalpAmount;
    }


    public KalpDecision getDecision() {
        return decision;
    }

}
