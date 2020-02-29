package com.example.realtimedatabase;

public class User {
    private String usedAmount;
    private String userCardNum;
    private String userCardHolderName;
    private String userCardExpDate;
    private String userCardVerificationValue;

    public User(){


    }

    public User(String usedAmount, String userCardNum, String userCardHolderName, String userCardExpDate, String userCardVerificationValue) {
        this.usedAmount = usedAmount;
        this.userCardNum = userCardNum;
        this.userCardHolderName = userCardHolderName;
        this.userCardExpDate = userCardExpDate;
        this.userCardVerificationValue = userCardVerificationValue;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getUserCardNum() {
        return userCardNum;
    }

    public void setUserCardNum(String userCardNum) {
        this.userCardNum = userCardNum;
    }

    public String getUserCardHolderName() {
        return userCardHolderName;
    }

    public void setUserCardHolderName(String userCardHolderName) {
        this.userCardHolderName = userCardHolderName;
    }

    public String getUserCardExpDate() {
        return userCardExpDate;
    }

    public void setUserCardExpDate(String userCardExpDate) {
        this.userCardExpDate = userCardExpDate;
    }

    public String getUserCardVerificationValue() {
        return userCardVerificationValue;
    }

    public void setUserCardVerificationValue(String userCardVerificationValue) {
        this.userCardVerificationValue = userCardVerificationValue;
    }
}
