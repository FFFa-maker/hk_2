package com.example.hk_2.controller;

import com.example.hk_2.entities.User;
import com.example.hk_2.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//@Controller
@RestController
public class LogSignController {
    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录", description = "用户登录")
    @GetMapping("/users")
    @JsonView(User.UserPassword.class)
    public User login(HttpServletRequest req,
                        Model model,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password){
        User user = userService.login(name, password);
        req.getSession().setAttribute("user", user.getId());
        return user;
    }

    @Operation(description = "用户注册")
    @PostMapping("/users")
    @JsonView(User.UserPassword.class)
    public User postSign(HttpServletRequest req,
                       Model model,
//                       @RequestParam("name") String name,
//                       @RequestParam("password") String password,
                         @RequestBody User u){
        User user = userService.signup(u.getName(), u.getPassword());
        return user;
    }
}
