package net.mustapha.Model;

import java.util.Objects;
import java.util.UUID;

public abstract   class  Bankaccount extends Object{
    private String accountId;
    private double balance;
    private String devise;
    private Accountstatus Status;



    //Création du constructeur 1 et 2 de la classe Bankaccout
    public Bankaccount(){
        this.accountId=UUID.randomUUID().toString();
        this.Status=Accountstatus.CREATED;
    }
    public Bankaccount(double initialbalance, String devise){
        this();//Appel du constructeur 1
        this.balance=initialbalance;
        this.devise=devise;

    }

    // GETTERS ET SETTERS pour acceder aux attribus privés
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDevise() {
        return devise;
    }
    public void setStatus(Accountstatus status) {
        Status = status;
    }

    public Accountstatus getStatus() {
        return Status;
    }
    public void setDevise(String devise) {
        this.devise = devise;
    }

//Redefinition de la methode toString()

    @Override
    public String toString() {
        return "Bankaccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", devise='" + devise + '\'' +
                ", Status=" + Status +
                '}';
    }

    @Override
    public boolean equals(Object acc) {

        Bankaccount account= (Bankaccount) acc;//Sous casting
        if(this.accountId.equals(account.accountId)) {
            return true;
        }
        else{
            return false;

        }
    }
    public abstract String getype();



}


