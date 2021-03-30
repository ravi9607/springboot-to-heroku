package com.example.springejava.stringService;

import com.example.springejava.User.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {


    public List<user> findByFName(String fName);
}
