package net.mustapha.business;

import net.mustapha.Model.Accountstatus;
import net.mustapha.Model.Bankaccount;
import net.mustapha.Model.Currentaccount;
import net.mustapha.Model.SavingAccount;
import net.mustapha.exeptions.AccountNotfoundExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class BankaccountImpl implements Bankaccountservice{
    public List<Bankaccount> Bankaccountlist =new ArrayList<>();


    @Override
    public Bankaccount Addbankaccount(Bankaccount account) {
        Bankaccountlist.add(account);
        return account;
    }

    @Override
    public List<Bankaccount> getAllaccounts() {

        return Bankaccountlist;
    }

    @Override
    public Bankaccount getAccountbyID(String id) throws AccountNotfoundExeption {
        //declarative approach
       return   Bankaccountlist.stream()
                .filter(acc->acc.getAccountId().equals(id))
                .findFirst()
                .orElseThrow(()-> new AccountNotfoundExeption("Bank account not found"));
        /*
        //imperative Approach
        for (Bankaccount bankAccount:Bankaccountlist){
            if ( bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }

        throw new AccountNotfoundExeption("Bankaccount not found");

         */
    }

    @Override
    public void addRandomData(int size) {
        Accountstatus[] values=Accountstatus.values();
        Random random=new Random();
        for (int i=0;i<size;){
            Bankaccount bankaccount;
            if (Math.random()>0.5){
                bankaccount=new Currentaccount(Math.random()*1000000,Math.random()>0.5?"USD":"MAD",Math.random()*3000);
                bankaccount.setStatus(values[random.nextInt(values.length)]);
            }else {
                bankaccount=new SavingAccount(Math.random()*1000000,Math.random()>0.5?"USD":"MAD",Math.random()*3000);
                bankaccount.setStatus(values[random.nextInt(values.length)]);
            }
            Bankaccountlist.add(bankaccount);


        }


    }

    @Override
    public void Credit(String accountId, double ammount) throws AccountNotfoundExeption {
        Bankaccount accountbyID = getAccountbyID(accountId);
        accountbyID.setBalance(accountbyID.getBalance()+ammount);


    }

    @Override
    public void Debit(String accountId, double ammount) throws AccountNotfoundExeption, BalancenotsuffisantExeption {
        Bankaccount accountbyID = getAccountbyID(accountId);
        if (ammount>accountbyID.getBalance()) throw new BalancenotsuffisantExeption("Balance not sufficient");

        accountbyID.setBalance(accountbyID.getBalance()-ammount);

    }

    @Override
    public void transfer(String accountsource, String accountdestination, double ammount) throws AccountNotfoundExeption, BalancenotsuffisantExeption {
        Debit(accountsource,ammount);
        Credit(accountdestination,ammount);


    }

    @Override
    public List<Bankaccount> getAllSavingaccounts() {
        /*
        //Declarative approach
        return    Bankaccountlist
                .stream().filter(acc-> acc instanceof SavingAccount).collect(Collectors.toList());
         */
        //imperative approach
        List<Bankaccount> result=new ArrayList<>();
        for (Bankaccount bankaccount:Bankaccountlist){
            if (bankaccount instanceof Currentaccount){
                 result.add(bankaccount);

            }
            return result;
        }
        return null;




    }

    @Override
    public List<Bankaccount> getAllCurrentaccount() {

        return    Bankaccountlist
                .stream().filter(acc-> acc instanceof Currentaccount)
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalbalance() {
        /*
        double sum=0;
        for (Bankaccount acc:Bankaccountlist){
            sum=sum+acc.getBalance();
        }
        return sum;

         */
        return Bankaccountlist.stream()
                .map(acc->acc.getBalance())
                .reduce(0.0,(a,v)->a+v);
    }

    @Override
    public List<Bankaccount> Searchaccounts(Condition condition) {
        List<Bankaccount> result=new ArrayList<>();
        for (Bankaccount acc:Bankaccountlist){
            if (condition.Test(acc)){
                result.add(acc);

            }
        }
        return result;
    }
}
