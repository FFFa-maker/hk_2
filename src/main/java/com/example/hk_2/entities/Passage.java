package com.example.hk_2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long user;
    private String title;
    private String content;
//    private Date postTime;

    public Passage(){}

    public Passage(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
