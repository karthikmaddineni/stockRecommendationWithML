package com.stockML.App.service;

import com.stockML.App.constants.UserServiceConstants;
import com.stockML.App.entity.userEntity.UserEntity;
import com.stockML.App.repository.UserRepository;
import com.stockML.App.userRequestEntity.UpdatePasswordReq;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public String loginUser(UserEntity user) {
        Optional<UserEntity> byUserName =
                userRepository.findByUserName(user.getUserName());
        if(byUserName.isPresent()){
            if(passwordEncoder.matches(user.getUserPassword(),byUserName.get().getUserPassword())){
                return UserServiceConstants.LOGSUC;
            }
            else return UserServiceConstants.WP;
        }else{
            return UserServiceConstants.LOGFAIL;
        }
    }
    public String createUser(UserEntity user) {
        Optional<UserEntity> byUserName = userRepository.findByUserName(user.getUserName());
        if(byUserName.isPresent()){
            return user.getUserName() + UserServiceConstants.AUNT;
        }else {
            String encode = passwordEncoder.encode(user.getUserPassword());
            user.setUserPassword(encode);
            userRepository.save(user);
            return UserServiceConstants.ACS;
        }
    }
    @Transactional
    public String deleteUser(UserEntity user) {
        Optional<UserEntity> byUserName =
                userRepository.findByUserName(user.getUserName());
        if(byUserName.isPresent()){
            if(passwordEncoder.matches(user.getUserPassword(),byUserName.get().getUserPassword())){
                 userRepository.deleteByUserNameAndUserPassword(user.getUserName(),
                         passwordEncoder.encode(user.getUserPassword()));
                return UserServiceConstants.ADS;
            }else {
                return UserServiceConstants.WP;
            }
        }else{
            return UserServiceConstants.LOGFAIL;
        }
    }

    @Transactional
    public String updateUser(UpdatePasswordReq updatePasswordReq) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserName(updatePasswordReq.getUserName());
        if(userEntityOptional.isPresent()){
            if(passwordEncoder.matches(updatePasswordReq.getOldPassword(),userEntityOptional.get().getUserPassword())){
                userEntityOptional.get().setUserPassword(passwordEncoder.encode(updatePasswordReq.getNewPassword()));
                return UserServiceConstants.PUS;
            }else {
                return UserServiceConstants.WP;
            }
        }else {
            return UserServiceConstants.LOGFAIL;
        }
    }
}
