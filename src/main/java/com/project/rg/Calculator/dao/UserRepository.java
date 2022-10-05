package com.project.rg.Calculator.dao;

import com.project.rg.Calculator.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

    HashMap<String, User> tempDb = new HashMap<>();
    public boolean existsByEmail(String email){
        return tempDb.values().stream().anyMatch(data -> data.getEmail().equals(email));
    }
    public boolean existsByUsername(String userName){
        return  tempDb.containsKey(userName);
    }
    public void addUser(User request){
        tempDb.put(request.getUserName(),request);
        System.out.println(tempDb);
    }

    public User getUserByUserName(String userName){
        return tempDb.get(userName);
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "tempDb=" + tempDb +
                '}';
    }
}
