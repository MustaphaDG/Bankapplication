package net.mustapha.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        //Creer un tableau de 4 variable
        Bankaccount[] accounts = new Bankaccount[4];
        //attribuer les valeurs de accounts[i]
        accounts[0] = new Currentaccount(44, "MAD", 4);
        accounts[1] = new Currentaccount(46, "USD", 4);
        accounts[2] = new SavingAccount(666, "YON", 4.9);
        accounts[3] = new SavingAccount(44, "MAD", 4.4);

        //Creer Une boucle
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].toString());
        }
        for (Bankaccount acc : accounts) {
            System.out.println(acc.getype());
        }
        ////Creer une boucle 2
        for (Bankaccount accc : accounts){
            if (accc instanceof SavingAccount){
                System.out.println(((SavingAccount) accc).getInterestRate());
            }
            if (accc instanceof Currentaccount){
                System.out.println(((Currentaccount) accc).getOverDraft());
            }
        }

        //Creer une Liste:
        List<Bankaccount> BankaccountList = new ArrayList<Bankaccount>();

        BankaccountList.add(new Currentaccount(66, "DDK", 79));
        BankaccountList.add(new Currentaccount(55, "IJK", 90));

        //Creer Collection de type MAP;
        System.out.println("=====================================================");
        Map<String, Bankaccount> BankaccountMap = new HashMap<>();
        BankaccountMap.put("CC1", new SavingAccount(33, "MAD", 55));
        BankaccountMap.put("CC2", new Currentaccount(33, "MAD", 99));
        BankaccountMap.put("CC3", new Currentaccount(33, "MAD", 78));
        BankaccountMap.put("CC4", new SavingAccount(33, "MAD", 54));

        Bankaccount acc = BankaccountMap.get("CC1");
        System.out.println(acc);

        //une boucle dans les lists:

        for (String Key : BankaccountMap.keySet()) {
            System.out.println(BankaccountMap.get(Key));
        }
        for (Bankaccount ba : BankaccountMap.values()) {
            System.out.println(toJson(ba));
        }

    }

    public static String toJson(Object o ){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
