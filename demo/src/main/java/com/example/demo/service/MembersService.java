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
    
    // 비밀번호 일치 여부 확인
    public boolean isPasswordMatch(Members member) {
        Members dbMember = membersDao.findById(member.getId());
        if (dbMember == null) {
            return false;
        }
        // 비밀번호 비교
        return passwordEncoder.matches(member.getPasswd(), dbMember.getPasswd());
    }
    
}
