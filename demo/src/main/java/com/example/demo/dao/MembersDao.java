package com.example.demo.dao;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Members;

@Mapper
public interface MembersDao {

    // 회원 추가
    Integer insertMember(Members member);

    // ID로 회원 조회 (스프링 시큐리티에서 사용)
    Members findById(String id);
    
    
    
}

  
