package net.mustapha.business;

import net.mustapha.Model.Bankaccount;
import net.mustapha.exeptions.AccountNotfoundExeption;

import java.util.List;
//creer une interface
public interface Bankaccountservice {

    //les methodes de l'interfaces
    Bankaccount Addbankaccount(Bankaccount account );
    List<Bankaccount> getAllaccounts();
    Bankaccount getAccountbyID(String id) throws AccountNotfoundExeption;
    void addRandomData(int size);
    void Credit(String accountId, double ammount) throws AccountNotfoundExeption;
    void Debit(String accountId,double ammount) throws AccountNotfoundExeption, BalancenotsuffisantExeption;
    void transfer(String accountsource,String accountdestination,double ammount ) throws AccountNotfoundExeption, BalancenotsuffisantExeption;
    List<Bankaccount> getAllSavingaccounts();
    List<Bankaccount> getAllCurrentaccount();
    double getTotalbalance();
    List<Bankaccount> Searchaccounts(Condition condition);


}
