package com.example.springejava.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class user {


    private long id;
    private String fName;
    private String lName;
    private long pNumber;

    public user(Long id, String fName, String lName, Long pNumber) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.pNumber = pNumber;
    }

    public user() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
