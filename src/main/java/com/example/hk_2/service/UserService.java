package com.example.hk_2.service;

import com.example.hk_2.dao.PassageRepository;
import com.example.hk_2.dao.RelationRepository;
import com.example.hk_2.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private PassageRepository passageRepository;
}
