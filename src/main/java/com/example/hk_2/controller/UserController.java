package com.example.hk_2.controller;

import com.example.hk_2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
//    @Bean
//    public GroupedOpenApi storeOpenApi(){
//        String paths[] = {"/users/**", "/user/**"};
//        return GroupedOpenApi.builder().group("users").pathsToMatch(paths).build();
//    }

    @Operation(description = "获取特定用户信息")
    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "更新用户信息")
    @PutMapping("/users/{id}")
    public String putUser(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "删除用户信息")
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "获取当前用户的好友列表")
    @GetMapping("/users/{id}/friends")
    public String getFriendsList(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "添加好友")
    @PostMapping("/user/{id}/friends")
    public String addFriends(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "删除好友")
    @DeleteMapping("/users/{id1}/friends/{id2}")
    public String deleteFriends(@PathVariable("id1") long userId,
                                @PathVariable("id2") long friendId){
        return "";
    }

    @Operation(description = "发表动态信息")
    @PostMapping("/blogs")
    public String postBlog(){
        return "";
    }

    @Operation(description = "删除动态信息")
    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "编辑动态信息")
    @PutMapping("/blogs/{id}")
    public String changeBlog(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "获取好友的动态列表")
    @GetMapping("/users/{id}/friends/blogs")
    public String getFriendBlog(@PathVariable("id") long id){
        return "";
    }

    @Operation(description = "获取特定的用户动态信息")
    @GetMapping("/user/{id}/blogs")
    public String getSpecificBlog(@PathVariable("id") long id){
        return "";
    }
}
