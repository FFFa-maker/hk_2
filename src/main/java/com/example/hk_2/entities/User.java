package com.example.hk_2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    public interface UserInfo{};
    public interface UserPassword extends UserInfo{};
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Size(min = 3, max = 12, message = "3≤用户名长度≤12")
    private String name;
    @Size(min = 6, max = 6, message = "用户密码必须是6位数字")
    @Pattern(regexp = "^[0-9]+$", message = "用户密码必须是6位数字")
    private String password;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    @JsonView(UserInfo.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(UserPassword.class)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
