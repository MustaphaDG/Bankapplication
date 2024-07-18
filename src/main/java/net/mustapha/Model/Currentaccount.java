package net.mustapha.Model;

public class Currentaccount extends Bankaccount{
    private double overDraft;

    public Currentaccount() {
        super();
        this.overDraft = overDraft;
    }

    public Currentaccount(double initialbalance, String devise, double overDraft) {
        super(initialbalance, devise);
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "Currentaccount overDraft=" + overDraft +super.toString();

    }

    @Override
    public String getype() {
        return "CURRENTACCOUNT";
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

}
