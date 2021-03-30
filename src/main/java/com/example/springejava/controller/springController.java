package com.example.springejava.controller;

import com.example.springejava.User.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springejava.stringService.*;

import java.util.List;


@RestController()
@RequestMapping("/api")
public class springController {

    @Autowired
    private serviceImplement serviceimplement;
    private String fName;

    @GetMapping("/stu")
    public List<user> findAll(){
        return this.serviceimplement.getUsers();
    }

    @GetMapping("/name")
    public String Hello(String name){
        return name;
    }

    @PostMapping("/stu")
    public user post(@RequestBody user User){
        return  this.serviceimplement.addUser(User);
    }

    @GetMapping("/stu/id/{id}")
    public user getUserById(@PathVariable("id") Long id){
        return serviceimplement.getUserById(id);
    }

    @PutMapping("/stu")
    public user update(@RequestBody user User){
        return this.serviceimplement.updateUser(User);
    }

    @DeleteMapping("/stu/id/{id}")
    public void delete(@PathVariable String id){
        this.serviceimplement.deleteById(Long.parseLong(id));
    }

    @GetMapping("/stu/fname/{fName}")
    public List<user> getUserByName(@PathVariable("fName") final String fName){
        return  this.serviceimplement.getUserByName(fName);
    }


}
