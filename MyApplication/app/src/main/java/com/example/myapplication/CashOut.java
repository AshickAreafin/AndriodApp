package com.example.myapplication;

public class CashOut {
    private String agentNumber;
    private String amount;
    private String pwd;

    public CashOut(){

    }

    public CashOut(String agentNumber, String amount, String pwd) {
        this.agentNumber = agentNumber;
        this.amount = amount;
        this.pwd = pwd;
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
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
