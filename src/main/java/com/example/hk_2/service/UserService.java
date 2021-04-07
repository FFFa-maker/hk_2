package com.example.hk_2.service;

import com.example.hk_2.advice.UserException;
import com.example.hk_2.dao.PassageRepository;
import com.example.hk_2.dao.RelationRepository;
import com.example.hk_2.dao.UserRepository;
import com.example.hk_2.entities.Passage;
import com.example.hk_2.entities.Relation;
import com.example.hk_2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private PassageRepository passageRepository;

    public User login(String name, String password) {
        List<User> users = userRepository.findByName(name);
        if(users==null || users.size()==0){
            throw new UserException("登录用户不存在");
        }
        else if(users.get(0).getPassword().equals(password)){
            return users.get(0);
        }
        throw new UserException("密码错误");
    }
    public User signup(String name, String password){
        if(!userRepository.existsByName(name)){
            User user = new User(name, password);
            userRepository.save(user);
            return user;
        }
        throw new UserException("用户名已被注册");
    }
    public User getUserById(long id){
        List<User> users = userRepository.findById(id);
        if(users==null || users.size()==0){
            throw new UserException("查询用户不存在");
        }else{
            return users.get(0);
        }
    }
    public User setUserById(long id, String name, String password){
        List<User> users = userRepository.findById(id);
        if(users ==null || users.size()==0){
            throw new UserException("修改用户不存在");
        }else{
            User u = users.get(0);
            u.setName(name);
            u.setPassword(password);
            userRepository.saveAndFlush(u);
            return u;
        }
    }
    public User deleteUserById(long id){
        List<User> users = userRepository.findById(id);
        if(users ==null || users.size()==0){
            throw new UserException("注销用户不存在");
        }else{
            User u = users.get(0);
            userRepository.delete(u);
            return u;
        }
    }
    public List<List> getFriends(long id){
        List<Relation> relations = relationRepository.findByAOrB(id, id);
        List<Long> fansId = new ArrayList<>();
        List<Long> noticedId = new ArrayList<>();
        for (Relation r:relations) {
            if(r.getA()==id){
                noticedId.add(r.getB());
            }else{
                fansId.add(r.getA());
            }
        }
        List<User> fans = userRepository.findByIdIn(fansId);
        List<User> noticed = userRepository.findByIdIn(noticedId);
        List<List> lists = new ArrayList<>();
        lists.add(fans);
        lists.add(noticed);
        return lists;
    }
    public void addFriends(long id1, long id2){
        if(userRepository.existsById(id2)){
            if(!relationRepository.existsByAAndB(id1, id2)){
                relationRepository.save(new Relation(id1, id2));
                return;
            }
            throw new UserException("已经关注该好友");
        }
        throw new UserException("添加好友不存在");
    }
    public void deleteFriends(long id1, long id2){
        if(userRepository.existsById(id2)){
            if(relationRepository.existsByAAndB(id1, id2)){
                Relation r = relationRepository.findByAAndB(id1, id2).get(0);
                relationRepository.delete(r);
                return;
            }
            throw new UserException("未关注该好友");
        }
        throw new UserException("删除好友不存在");
    }
    public Passage postBlog(long id, Passage p){
        p.setUser(id);
        passageRepository.save(p);
        return p;
    }
    public void deleteBlog(long userId, long id){
        List<Passage> passages = passageRepository.findById(id);
        if(passages==null || passages.size()==0){
            throw new UserException("删除文章不存在");
        }
        else if(passages.get(0).getUser()==userId){
            passageRepository.delete(passages.get(0));
            return ;
        }
        throw new UserException("登录用户不匹配，无法删除");
    }
    public void putBlog(long userId, long id, Passage p){
        List<Passage> passages = passageRepository.findById(id);
        if(passages==null || passages.size()==0){
            throw new UserException("修改文章不存在");
        }else if(passages.get(0).getUser()==userId){
            Passage passage = passages.get(0);
            passage.setContent(p.getContent());
            passage.setTitle(p.getTitle());
            passageRepository.saveAndFlush(passage);
            return;
        }
        throw new UserException("登录用户不匹配无法修改");
    }
    public List<Passage> getFriendBlog(long id){
        List<List> lists = getFriends(id);
        List<Long> friends = new ArrayList<>();
        for(List<User> l: lists){
            for(User u:l){
                friends.add(u.getId());
            }
        }
        friends.add(id);
        List<Passage> passages = passageRepository.findByUserIn(friends);
        return passages;
    }
    public List<Passage> getSpecificBlog(long id){
        List<Passage> passages = passageRepository.findByUser(id);
        return passages;
    }
}
