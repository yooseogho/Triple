package com.example.demo.service;

import com.example.demo.dao.MembersDao;
import com.example.demo.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

    @Autowired
    private MembersDao membersDao; // MembersDao 의존성 주입
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원 추가
    public Integer insertMember(Members member) {
        return membersDao.insertMember(member); // 회원 데이터를 DB에 저장
    }

    // ID로 회원 조회
    public Members findById(String id) {
        return membersDao.findById(id); // ID로 회원 조회
    }
    

    
}
