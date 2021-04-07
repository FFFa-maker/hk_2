package com.example.hk_2.controller;

import com.example.hk_2.dao.PassageRepository;
import com.example.hk_2.dao.RelationRepository;
import com.example.hk_2.dao.UserRepository;
import com.example.hk_2.entities.Passage;
import com.example.hk_2.entities.Relation;
import com.example.hk_2.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;
    private PassageRepository passageRepository;
    private RelationRepository relationRepository;

//    @Bean
//    public GroupedOpenApi storeOpenApi(){
//        String paths[] = {"/users/**", "/user/**"};
//        return GroupedOpenApi.builder().group("users").pathsToMatch(paths).build();
//    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Autowired
    public void setPassageRepository(PassageRepository passageRepository) {
        this.passageRepository = passageRepository;
    }
    @Autowired
    public void setRelationRepository(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

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

    @Operation(description = "")
    @GetMapping("/users/{userId}/friends/blogs")
    public String getSelfList(HttpServletRequest req,
                          Model model,
                          @PathVariable("userId") long id){
//        List<Relation> relationList = relationRepository.findByAOrB(id, id);
//        ArrayList<Long> friends = new ArrayList<>();
//        friends.add(id);
//        for (Relation r : relationList) {
//            friends.add(r.getA()==id?r.getB():r.getA());
//        }
//        List<Passage> passageList = passageRepository.findByUserIn(friends);
//        model.addAttribute("passages", passageList);
//        model.addAttribute("user", id);
//        return "index";
        return "";
    }
    @Operation(description = "")
    @GetMapping("/users/{userId}/friends")
    public String getFriendList(HttpServletRequest req,
                          Model model,
                          @PathVariable("userId") long id){
//        List<Relation> relationList = relationRepository.findByAOrB(id, id);
//        ArrayList<Long> friends = new ArrayList<>();
//        friends.add(id);
//        for (Relation r : relationList) {
//            friends.add(r.getA()==id?r.getB():r.getA());
//        }
//        List<User> friendList = userRepository.findByIdIn(friends);
//        model.addAttribute("friends", friendList);
//        return "friend";
        return "";
    }
}
