package com.practice.CRUD.service;

import com.practice.CRUD.model.User;
import com.practice.CRUD.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@PropertySource("classpath:test-app.properties")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Value("${external.value:No value found}")
    private String externalTest;

    @Autowired
    private Environment env;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new RuntimeException("No user found with Id of"+ id);
        }

        return user.get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        Optional<User> dbUser = userRepository.findById(user.getId());

        if(dbUser.isEmpty()){
            throw new RuntimeException("No such user user existing in DB with Id of "+user.getId());
        }
        User toUpdateUser = dbUser.get();
        toUpdateUser.setEmail(user.getEmail());
        toUpdateUser.setPassword(user.getPassword());
        toUpdateUser.setUsername(user.getUsername());

        return userRepository.save(toUpdateUser);
    }

    public User deleteUser(Integer id){
        Optional<User> dbUser = userRepository.findById(id);

        if (dbUser.isEmpty()){
            throw new RuntimeException("No such user id of "+id);
        }

        userRepository.deleteById(id);
        return dbUser.get();
    }

    public void test(){
        System.out.println("The value is here "+env.getProperty("testing"));
        System.out.println("The externak value is here: "+ externalTest);
    }

}
