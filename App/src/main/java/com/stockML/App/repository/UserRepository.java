package com.stockML.App.repository;

import com.stockML.App.entity.userEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUserNameAndUserPassword(String username, String password);

    void deleteByUserNameAndUserPassword(String userName, String userPassword);

     Optional<UserEntity> findByUserName(String userName);
}
