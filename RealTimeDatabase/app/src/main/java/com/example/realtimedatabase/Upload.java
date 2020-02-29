package com.example.realtimedatabase;

public class Upload {

    private String userName;
    private String userAccountNum;
    private String userAccountType;
    private String userAccountExpDate;
    private String imageUri;

    public Upload(){


    }

    public Upload(String userName, String userAccountNum, String userAccountType, String userAccountExpDate, String imageUri) {
        this.userName = userName;
        this.userAccountNum = userAccountNum;
        this.userAccountType = userAccountType;
        this.userAccountExpDate = userAccountExpDate;
        this.imageUri = imageUri;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccountNum() {
        return userAccountNum;
    }

    public void setUserAccountNum(String userAccountNum) {
        this.userAccountNum = userAccountNum;
    }

    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getUserAccountExpDate() {
        return userAccountExpDate;
    }

    public void setUserAccountExpDate(String userAccountExpDate) {
        this.userAccountExpDate = userAccountExpDate;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
