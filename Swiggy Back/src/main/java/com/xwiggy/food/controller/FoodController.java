package com.xwiggy.food.controller;

import com.xwiggy.food.dao.FoodDaoImpl;
import com.xwiggy.food.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {

    @Autowired
    FoodDaoImpl foodDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/menu")
    public List<Food> getMenu(Model model) {
        List<Food> foodItems ;
        foodItems = foodDao.getFoodList();
        return foodItems;
    }


}
