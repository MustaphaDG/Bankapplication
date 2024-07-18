package net.mustapha;

import net.mustapha.Model.Bankaccount;
import net.mustapha.Model.Currentaccount;
import net.mustapha.Model.SavingAccount;
import net.mustapha.business.BankaccountImpl;
import net.mustapha.business.Bankaccountservice;
import net.mustapha.exeptions.AccountNotfoundExeption;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        //instancier Objet Bankaccountservice
        Bankaccountservice Bankaccountservice=new BankaccountImpl();
        Bankaccountservice.Addbankaccount(new SavingAccount(345,"MAD",556));
        Bankaccountservice.Addbankaccount(new Currentaccount(4445,"DHS",44));
        Bankaccount bankaccount3=new Currentaccount(4567,"PLM",66);
        bankaccount3.setAccountId("CC3");

        Bankaccountservice.Addbankaccount(bankaccount3);


        List<Bankaccount> allaccounts=Bankaccountservice.getAllaccounts();//les methodes pour parcourir allaccounts

        /*
        for (Bankaccount allaccount : allaccounts) {
            System.out.println(allaccount.toString());

        }
        */

        /*
        for (int i=0 ; i< allaccounts.size();){
            System.out.println(allaccounts.get(i));

        }

        System.out.println("===================================================");

        /*
        allaccounts.forEach(new Consumer<Bankaccount>() {

            @Override
            public void accept(Bankaccount bankaccount) {

            }


        */

        allaccounts.forEach(account-> System.out.println(account.toString()));
        System.out.println("===================================================");

        try {
            Bankaccount cc1 = Bankaccountservice.getAccountbyID("CC1");
            System.out.println(cc1.toString());
        }catch (AccountNotfoundExeption e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("===================================================");
        /*
        Bankaccount cc1 = Bankaccountservice.getAccountbyID("CC1");
        System.out.println(cc1.toString());
        System.out.println("===================================================");
        */


    }


}
