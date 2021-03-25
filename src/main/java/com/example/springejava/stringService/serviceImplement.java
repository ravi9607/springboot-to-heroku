package com.example.springejava.stringService;

import com.example.springejava.User.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class serviceImplement  {

    @Autowired
    private UserRepository userRepository;

    public List<user> getUsers() {
        return userRepository.findAll();
    }


    public user addUser(user User){
        userRepository.save(User);
        return User;
    }

    public user getUserById(long id){
        return userRepository.findById(id).get();   // "getOne(id)" NOT WORK  use  "findById(id).get()"
    }

    public user updateUser(user User){
        return userRepository.save(User);
    }

    public void deleteById(long parseLong) {
        user u = userRepository.findById(parseLong).get();
        userRepository.delete(u);
    }
}
