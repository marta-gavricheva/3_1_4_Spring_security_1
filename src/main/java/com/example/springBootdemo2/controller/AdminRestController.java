package com.example.springBootdemo2.controller;

import com.example.springBootdemo2.model.Role;
import com.example.springBootdemo2.model.User;
import com.example.springBootdemo2.service.RoleService;
import com.example.springBootdemo2.service.UserService;
import com.example.springBootdemo2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin_api")
public class AdminRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //Все юзеры(возвращать ResponceEntity)
    @GetMapping()
    public ResponseEntity <List<User>> userALL() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    //Юзер по ID
    @GetMapping("/{id}")
    public ResponseEntity<User> usersId(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.getUserId(id),HttpStatus.OK);
    }

    //Добавить нового юзера
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
          return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    //Изменить юзера
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user); // вот тут изменила с addUser
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Удалить юзера
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
    }

    @GetMapping("/getroles")
    private ResponseEntity<List<Role>> allRoles() {
        return new ResponseEntity<>((List<Role>) roleService.findAll(),HttpStatus.OK);
    }
}
