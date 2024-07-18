package net.mustapha.business;

public class BalancenotsuffisantExeption extends Throwable {
    public BalancenotsuffisantExeption(String message) {
        super(message);
    }
}
