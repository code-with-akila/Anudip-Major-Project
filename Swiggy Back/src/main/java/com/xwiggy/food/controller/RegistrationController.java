package com.xwiggy.food.controller;
import com.xwiggy.food.dao.UserDaoImpl;
import com.xwiggy.food.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private UserDaoImpl userDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/register")
    public User showRegister() {
        return new User();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public User addUser(@RequestBody User user, Model model) {
        System.out.println(user.toString());
        userDao.register(user);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/checkUserName")
    public boolean checkAvailability(@RequestBody String username, Model model){
        return userDao.usernameExists(username);
    }
}
