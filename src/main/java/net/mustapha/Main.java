package net.mustapha;
import net.mustapha.Model.Bankaccount;
import net.mustapha.Model.Currentaccount;

import javax.print.attribute.standard.JobName;

public class Main {
    public static void main(String[] args) {
        //instancier un objet account1 type Bankaccount // account1 est notre handler
        Bankaccount account1 = new Currentaccount();

        //attribuer les valeurs de account1 ;

        account1.setBalance(55);
        account1.setDevise("MAD");
        //+++++++++++++++++++++++
        //printaccount(account1);


        //Creer un bankaccout2 en fesant appel au constructeur 2 :
        Bankaccount account2 = new Currentaccount();

        Bankaccount account3=new Currentaccount(456, "MAD",2.1);

        account3.setAccountId(account2.getAccountId());


        printaccount(account1);

        printaccount(account2);
        printaccount(account3);

        System.out.println(account1.hashCode());
        System.out.println(account2.hashCode());
        if (account1.hashCode()==account2.hashCode()){
            System.out.println("meme etat");
        }
        else {
            System.out.println("pas les meme etat");
        }


        System.out.println(account2.equals(account3));
        System.out.println(account2==account3);



    }



    //Function to Print Account variables:
    public static void printaccount(Bankaccount account) {
        System.out.println("================================================");
        System.out.println("Account Id is " + account.getAccountId());
        System.out.println("Account balance is " + account.getBalance());
        System.out.println("Account devise is " + account.getDevise());
        System.out.println("Account status " + account.getStatus());

        //+++++++++++++++++++++++++++++Object famous Class
       // System.out.println(account2.equals(account3));
        //System.out.println(account.toString());
        //System.out.println(account.hashCode());

        System.out.println("================================================");
    }



}

