package com.xwiggy.food.controller;

import com.xwiggy.food.dao.ContactDaoImpl;
import com.xwiggy.food.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    @Autowired
    ContactDaoImpl contactDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/contact")
    public boolean contactUs(@RequestBody Contact contact, Model model){
        return contactDao.saveMessage(contact);
    }
}
