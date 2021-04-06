package com.example.springejava.stringService;

import com.example.springejava.User.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {


    public user findByFName(String fName);


    // https://www.youtube.com/watch?v=6bxxsoCqll4&list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&index=15
    @Query("select u from user u where u.id >:n")
    public List<user> getuserByIdMoreThanFive(@Param("n") Long id);

//    @Query("select u FROM user u where u.fName =:fname and u.lName =:lname")
//    public List<user> ABCEFNameAndLName(@Param("fname") String fname, @Param("lname") String lname);

    List<user> findByFNameAndLName(String fname, String lname);
}
