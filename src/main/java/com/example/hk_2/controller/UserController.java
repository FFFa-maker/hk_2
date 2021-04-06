package com.example.hk_2.controller;

import com.example.hk_2.dao.PassageRepository;
import com.example.hk_2.dao.RelationRepository;
import com.example.hk_2.dao.UserRepository;
import com.example.hk_2.entities.Passage;
import com.example.hk_2.entities.Relation;
import com.example.hk_2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;
    private PassageRepository passageRepository;
    private RelationRepository relationRepository;
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

    @GetMapping("/user/{userId}/friend/passage")
    public String getSelfList(HttpServletRequest req,
                          Model model,
                          @PathVariable("userId") long id){
        List<Relation> relationList = relationRepository.findByAOrB(id, id);
        ArrayList<Long> friends = new ArrayList<>();
        friends.add(id);
        for (Relation r : relationList) {
            friends.add(r.getA()==id?r.getB():r.getA());
        }
        List<Passage> passageList = passageRepository.findByUserIn(friends);
        model.addAttribute("passages", passageList);
        model.addAttribute("user", id);
        return "index";
    }

    @GetMapping("/user/{userId}/friend")
    public String getFriendList(HttpServletRequest req,
                          Model model,
                          @PathVariable("userId") long id){
        List<Relation> relationList = relationRepository.findByAOrB(id, id);
        ArrayList<Long> friends = new ArrayList<>();
        friends.add(id);
        for (Relation r : relationList) {
            friends.add(r.getA()==id?r.getB():r.getA());
        }
        List<User> friendList = userRepository.findByIdIn(friends);
        model.addAttribute("friends", friendList);
        return "friend";
    }
}
