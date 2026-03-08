package com.stockML.App.controller;

import com.stockML.App.entity.userEntity.UserEntity;
import com.stockML.App.service.UserService;
import com.stockML.App.userRequestEntity.UpdatePasswordReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserLanding {
    @Autowired
    UserService userService;
    /**
     * this will log in into Account
     * by passing userName and password
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody UserEntity user){
        return userService.loginUser(user);
    }
    /**
     * this will create the user who wants to get a new account by passing userName and password
     *
     * @param user
     * @return
     */
    @PostMapping("/sign-up")
    public String signupUser(@RequestBody UserEntity user){
       return userService.createUser(user);
    }
    @PatchMapping("/updateUser")
    public String updateUser(@RequestBody UpdatePasswordReq updatePasswordReq){
       return userService.updateUser(updatePasswordReq);
    }
    /**
     * this will delete the account of a user
     * by passing userName and userPassword
     *
     * @param user
     * @return
     */
    @DeleteMapping("/deleteAccount")
    public String deleteAccount(@RequestBody UserEntity user){
        return userService.deleteUser(user);
    }

}
