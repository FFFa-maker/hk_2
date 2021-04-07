package com.example.hk_2.controller;

import com.example.hk_2.dao.UserRepository;
import com.example.hk_2.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LogSignController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Operation(description = "用户登录")
    @GetMapping("/users")
    public String login(HttpServletRequest req,
                        Model model,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password){
//        boolean ifExsit = userRepository.existsByName(name);
//        if(ifExsit){
//            List<User> userList = userRepository.findByName(name);
//            if(userList != null && userList.size() > 0){
//                if(userList.get(0).getPassword().equals(password)){
//                    req.getSession().setAttribute("userId", userList.get(0).getId());
//                    return "redirect:user/"+userList.get(0).getId() + "/friend/passage";
//                }
//                else{
//                    model.addAttribute("result", "密码错误");
//                    return "login";
//                }
//            }
//        }
//        model.addAttribute("result", "用户不存在");
//        return "login";
        return "";
    }

    @Operation(description = "用户注册")
    @PostMapping("/users")
    public String postSign(HttpServletRequest req,
                       Model model,
                       @RequestParam("name") String name,
                       @RequestParam("password") String password){
//        boolean ifExsit = userRepository.existsByName(name);
//        if(!ifExsit){
//            User user = new User(name, password);
//            userRepository.save(user);
//            return "login";
//        }
//        model.addAttribute("result", "该名称已被注册");
//        return "sign";
        return "";
    }
}
