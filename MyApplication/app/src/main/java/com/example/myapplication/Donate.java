package com.example.myapplication;

public class Donate {
    private String accountNumber;
    private String amount;
    private String pwd;

    public Donate(){

    }

    public Donate(String accountNumber, String amount, String pwd) {

        this.accountNumber = accountNumber;
        this.amount = amount;
        this.pwd = pwd;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
