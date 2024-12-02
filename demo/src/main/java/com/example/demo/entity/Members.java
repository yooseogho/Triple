package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Members {
    private Long no;           // 회원 번호 (NUMBER 타입, NOT NULL)
    private String id;         // 사용자 ID (VARCHAR2(50), NOT NULL)
    private String passwd;     // 비밀번호 (VARCHAR2(255), NOT NULL)
    private String email;      // 이메일 (VARCHAR2(255), NOT NULL)
    private Integer del;       // 삭제 여부 (NUMBER 타입, NOT NULL)
}
