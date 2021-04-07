package com.example.hk_2.controller;

import com.example.hk_2.advice.UserException;
import com.example.hk_2.entities.Passage;
import com.example.hk_2.entities.User;
import com.example.hk_2.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(description = "获取特定用户信息")
    @GetMapping("/users/{id}")
    @JsonView(User.UserInfo.class)
    public User getUser(@PathVariable("id") long id){
        User u = userService.getUserById(id);
        return u;
    }

    @Operation(description = "更新用户信息")
    @PutMapping("/users/{id}")
    @JsonView(User.UserPassword.class)
    public User putUser(HttpServletRequest req,
                          @PathVariable("id") long id,
                          @RequestParam("name") String name,
                          @RequestParam("name") String password){
        //id在登录之后进行修改，修改时id只需要判断是否一致即可
        if(Long.parseLong(req.getSession().getAttribute("user").toString())==id){
            User u = userService.setUserById(id, name, password);
            return u;
        }
        throw new UserException("登录与修改用户不匹配");
    }

    @Operation(description = "删除用户信息")
    @DeleteMapping("/users/{id}")
    public String deleteUser(HttpServletRequest req,
                           @PathVariable("id") long id){
        if(Long.parseLong(req.getSession().getAttribute("user").toString())==id){
            userService.deleteUserById(id);
            req.getSession().removeAttribute("user");
            return "用户注销成功";
        }
        throw new UserException("登录与注销用户不匹配");
    }

    @Operation(description = "获取当前用户的好友列表, 返回两个列表，第一个是粉丝列表，第二个是关注列表")
    @GetMapping("/users/{id}/friends")
    @JsonView(User.UserInfo.class)
    public List<List> getFriendsList(HttpServletRequest req,
                                     @PathVariable("id") long id){
//        if(Long.parseLong(req.getSession().getAttribute("user").toString())==id){
            List<List> users = userService.getFriends(id);
            return users;
//        }
//        throw new UserException("登录用户不匹配");
    }

    @Operation(description = "添加好友，关注")
    @PostMapping("/user/{id}/friends")
    @JsonView(User.UserInfo.class)
    public String addFriends(HttpServletRequest req,
                             @PathVariable("id") long friendId){
        Long userId = Long.parseLong(req.getSession().getAttribute("user").toString());
        userService.addFriends(userId, friendId);
        return "200:添加成功";
    }

    @Operation(description = "删除好友，取消关注")
    @DeleteMapping("/users/{id}/friends")
    public String deleteFriends(HttpServletRequest req,
                                @PathVariable("id") long friendId){
        Long userId = Long.parseLong(req.getSession().getAttribute("user").toString());
        userService.deleteFriends(userId, friendId);
        return "200:取消关注";
    }

    @Operation(description = "发表动态信息")
    @PostMapping("/blogs")
//    @JsonView(Passage.PassageInfo.class)
    public Passage postBlog(HttpServletRequest req,
                            @RequestBody Passage passage){
        long id = Long.parseLong(req.getSession().getAttribute("user").toString());
        userService.postBlog(id, passage);
        return passage;
    }

    @Operation(description = "删除动态信息")
    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(HttpServletRequest req,
                             @PathVariable("id") long id){
        long userId = Long.parseLong(req.getSession().getAttribute("user").toString());
        userService.deleteBlog(userId, id);
        return "成功删除该文章";
    }

    @Operation(description = "编辑动态信息")
    @PutMapping("/blogs/{id}")
    public String changeBlog(HttpServletRequest req,
                             @PathVariable("id") long id,
                             @RequestBody Passage p){
        long userId = Long.parseLong(req.getSession().getAttribute("user").toString());
        userService.putBlog(userId, id, p);
        return "成功修改该文章";
    }

    @Operation(description = "获取好友的动态列表")
    @GetMapping("/users/friends/blogs")
    public List<Passage> getFriendBlog(HttpServletRequest req){
        long userId = Long.parseLong(req.getSession().getAttribute("user").toString());
        return userService.getFriendBlog(userId);
    }

    @Operation(description = "获取特定的用户动态信息")
    @GetMapping("/user/{id}/blogs")
    public List<Passage> getSpecificBlog(@PathVariable("id") long id){
        return userService.getSpecificBlog(id);
    }
}
