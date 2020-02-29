package com.example.myapplication;

public class Biller {
    private String billNumber;
    private String amount;
    private String pwd;

    public Biller(){

    }

    public Biller(String billNumber, String amount, String pwd) {
        this.billNumber = billNumber;
        this.amount = amount;
        this.pwd = pwd;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
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
