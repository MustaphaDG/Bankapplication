package net.mustapha;

import net.mustapha.Model.Bankaccount;
import net.mustapha.business.BalancenotsuffisantExeption;
import net.mustapha.business.BankaccountImpl;
import net.mustapha.business.Bankaccountservice;
import net.mustapha.business.Condition;
import net.mustapha.exeptions.AccountNotfoundExeption;

import java.util.List;

public class Appl3 {
    public static void main(String[] args) {
        Bankaccountservice BankaccountService=new BankaccountImpl();
        BankaccountService.addRandomData(2);
        BankaccountService.getAllaccounts().forEach(System.out::println);//afficher les bankaccounts
        BankaccountService.getAllaccounts().forEach(bankaccount -> System.out.println(Datatransformation.Tojson(bankaccount)));
        BankaccountService.getAllaccounts()
                .stream().map(Datatransformation::Tojson);

        try {
            Bankaccount cce = BankaccountService.getAccountbyID("CCE");
            System.out.println(Datatransformation.Tojson(cce));
            BankaccountService.Debit("CC1",456);
        } catch (Exception | BalancenotsuffisantExeption e) {
            System.out.println(e.getMessage());;
        }

        BankaccountService.getAllSavingaccounts().stream().map(Datatransformation::Tojson).forEach(System.out::println);
        //Total des balances :
        System.out.println("Total balance"+BankaccountService.getTotalbalance());

        //Condition
        List<Bankaccount> searchaccounts = BankaccountService.Searchaccounts(acc -> (acc.getBalance() > 1000));
        searchaccounts.stream().map(Datatransformation::Tojson).forEach(System.out::println);


    }
}
