package com.stockML.App.userRequestEntity;

public class UpdatePasswordReq {
    public String userName;
    public String oldPassword;
    public String newPassword;

    public String getUserName() {
        return userName;
    }

    public UpdatePasswordReq() {
    }

    public UpdatePasswordReq(String userName, String oldPassword, String newPassword) {
        this.userName = userName;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
