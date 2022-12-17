package com.project.rg.Calculator.dao;

import com.project.rg.Calculator.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

       public User findByUserName(String userName);


       public boolean existsUserByEmail(String email);

       public boolean existsUserByUserName(String userName);
}