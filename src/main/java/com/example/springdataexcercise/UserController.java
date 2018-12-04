package com.example.springdataexcercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false, defaultValue = "ALL") Action action) {

        List<User> users = new ArrayList<>();
        switch (action) {
            case ALL:
                break;
            case ALL_JPQL:
                break;
            case ALL_SQL:
                break;
            case CONTAINS_O:
                break;
            case CONTAINS_O_JPQL:
                break;
            case CONTAINS_O_SQL:
                break;
            case DELETE_K:
                break;
            case DELETE_K_JPQL:
                break;
            case DELETE_K_SQL:
                break;
            case ORDER:
                break;
            case ORDER_JPQL:
                break;
            case ORDER_SQL:
                break;
        }

        model.addAttribute("users", users);

        return "home";
    }
}