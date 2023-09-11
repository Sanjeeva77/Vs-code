package cgg.springboot.db.springbootdbdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springboot.db.springbootdbdemo.entities.User1;



public interface UserRepo extends JpaRepository<User1,Integer> {

    User1 findByUsername(String username);
    
}
