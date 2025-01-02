package com.example.demo.service;

import com.example.demo.dao.MembersDao;
import com.example.demo.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MembersDao membersDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        // 데이터베이스에서 ID에 해당하는 멤버 검색
        Members member = membersDao.findById(id);
        if (member == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // UserDetails 객체를 생성하여 반환
        return User.builder()
                .username(member.getId())
                .password(member.getPasswd())  // DB에 저장된 암호화된 비밀번호
                .roles("USER")
                .build();
    }
    
    
}

