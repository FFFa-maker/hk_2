package com.example.hk_2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Passage {
    public interface PassageInfo{};
    public interface PassageUser extends PassageInfo{};
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    private long user;
    private String title;
    private String content;

    public Passage(){}

    public Passage(String title, String content){
        this.title = title;
        this.content = content;
    }

    @JsonView(PassageUser.class)
    public Long getUser(){
        return user;
    }
    public void setUser(Long user){
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @JsonView(PassageInfo.class)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonView(PassageInfo.class)
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
