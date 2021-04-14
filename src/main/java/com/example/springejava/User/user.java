package com.example.springejava.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.hibernate.cfg.annotations.reflection.XMLContext;

import javax.persistence.*;

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

    public user(long i, String ravi, String gupta, long i1) {   /// for testing
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
