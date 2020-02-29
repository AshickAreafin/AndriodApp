package com.example.myapplication;

public class Customer {

    private String operator;
    private String types;
    private String cellNumber;
    private String rechargeAmount;
    public Customer(){

    }

    public Customer(String operator, String types, String cellNumber, String rechargeAmount) {
        this.operator = operator;
        this.types = types;
        this.cellNumber = cellNumber;
        this.rechargeAmount = rechargeAmount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }
}
