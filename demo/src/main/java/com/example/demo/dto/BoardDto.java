package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardDto {

    @Data
    @NoArgsConstructor
    public static class Read {
        private Long no;           // 게시글 번호
        private String title;      // 게시글 제목
        private String writerId;   // 작성자 ID (members 테이블의 id)
        private LocalDate boardDate; // 게시일
        private String content;     // 게시글 내용 (CLOB)
        private Long memNo;        // 작성자 회원 번호
    }
    
    
    
}
