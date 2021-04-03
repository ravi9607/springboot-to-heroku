package com.example.springejava.controller;

import com.example.springejava.User.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springejava.stringService.*;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/api")
public class springController {

    @Autowired
    private serviceImplement serviceimplement;
    private String fName;


    @GetMapping("/name")
    public String Hello(String name){
        return name;
    }



    @GetMapping("/stu")
    public ResponseEntity<List<user>> findAll(){

        List<user> u=serviceimplement.getUsers();
        if(u.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PostMapping("/stu")
    public ResponseEntity<user> post(@RequestBody user User){
        user u=null;
        try {
            u = serviceimplement.addUser(User);
            return ResponseEntity.of(Optional.of(u));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/stu/id/{id}")
    public ResponseEntity<user> getUserById(@PathVariable("id") Long id){
        user u = serviceimplement.getUserById(id);
        if(u==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(u));
    }

    @PutMapping("/stu")
    public ResponseEntity<user> update(@RequestBody user User){

        try{
            serviceimplement.updateUser(User);
            return ResponseEntity.ok().body(User);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/stu/id/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        try{
            serviceimplement.deleteById(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/stu/fname/{fName}")
    public user getUserByName(@PathVariable("fName") String fName){
        return  this.serviceimplement.getUserByName(fName);
    }
}