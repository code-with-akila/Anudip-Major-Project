package com.xwiggy.food.controller;

import com.xwiggy.food.dao.UserDaoImpl;
import com.xwiggy.food.model.Login;
import com.xwiggy.food.model.User;
import com.xwiggy.food.utility.StrongAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private UserDaoImpl userDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/login")
    public Login showLogin() {
        return new Login();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public User loginProcess(@RequestBody Login login, Model model) {
        User user = null;
        user = userDao.validateUser(login);
        if(user!=null)
        user.setPassword(null);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/xx")
    private String xx(){
        return new StrongAES().encrypt("");
    }

}
