package net.mustapha.Model;

public class SavingAccount extends Bankaccount{
    private double InterestRate;

    //faire appel au constructeur mere
    public SavingAccount() {
        super();
    }

    public SavingAccount(double initialbalance, String devise, double interestRate) {
        super(initialbalance, devise);
        this.InterestRate = interestRate;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        this.InterestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "InterestRate=" + InterestRate + super.toString();
    }

    @Override
    public String getype() {
        return "SavingAccont";
    }
}
