package com.example.springBootdemo2.service;

import com.example.springBootdemo2.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

 User addUser(User user);

    void updateUser(User user);

    User getUserId(long id);

    User removeUser(long id);

    User getByName(String username);


}
