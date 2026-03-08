package com.stockML.App.entity.userEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table",schema = "public" )
public class UserEntity {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer accountID;
    @Column(name = "user_name")
    public String userName;
    @Column(name = "user_password")
    public String userPassword;
    @Column(name = "email_id")
    public String userEmail;

    public UserEntity(Integer accountID, String userName, String userPassword,String userEmail) {
        this.accountID = accountID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserEntity() {
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "accountID=" + accountID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}'+'\n';
    }
}
