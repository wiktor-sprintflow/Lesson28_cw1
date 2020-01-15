package com.example.springdataexcercise.controller;

import com.example.springdataexcercise.model.Action;
import com.example.springdataexcercise.model.User;
import com.example.springdataexcercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false, defaultValue = "ALL") Action action) {

        List<User> users = new ArrayList<>();
        switch (action) {
            case ALL:
                users = userRepository.findAll();
                break;
            case ALL_JPQL:
                users = userRepository.jpqlFindAll();
                break;
            case ALL_SQL:
                users = userRepository.nativeFindAll();
                break;
            case CONTAINS_O:
                users = userRepository.findByLastNameContaining("o");
                break;
            case CONTAINS_O_JPQL:
                users = userRepository.jpqlFindByLastNameContains("o");
                break;
            case CONTAINS_O_SQL:
                users = userRepository.nativeFindByLastNameContains("o");
                break;
            case DELETE_K:
                userRepository.deleteUserByFirstNameStartsWith("K");
                users = userRepository.findAll();
                break;
            case DELETE_K_JPQL:
                userRepository.jpqlDeleteByFirstNameStartingWith("K");
                users = userRepository.findAll();
                break;
            case DELETE_K_SQL:
                userRepository.nativeDeleteByFirstNameStartingWith("K");
                users = userRepository.findAll();
                break;
            case ORDER:
                users =  userRepository.findByOrderByLastNameDesc();
                break;
            case ORDER_JPQL:
                users = userRepository.jpqlFindUsersByLastNameOrderByLastNameDesc();
                break;
            case ORDER_SQL:
                users = userRepository.nativeFindUsersByLastNameOrderByLastNameDesc();
                break;
        }

        model.addAttribute("users", users);

        return "home";
    }
}