package org.example.CRUD_SpringBoot.controllers;

import org.example.CRUD_SpringBoot.models.User;
import org.example.CRUD_SpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }



    @GetMapping("/create")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User userAdd) {
        userService.addUser(userAdd);
        return "redirect:/";
    }



    @GetMapping("/edit")
    public String getEditUser(Model model) {
        model.addAttribute("userEdit", new User());
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("userEdit") User user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/";
    }



    @GetMapping("/delete")
    public String getDeleteUser(Model model) {
        model.addAttribute("userDelete", new User());
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("userDelete") User user) {
        userService.removeUserById(user.getId());
        return "redirect:/";
    }

}
