package net.mustapha.business;

import net.mustapha.Model.Bankaccount;
@FunctionalInterface
public interface Condition {
    public boolean Test(Bankaccount acc);

}
