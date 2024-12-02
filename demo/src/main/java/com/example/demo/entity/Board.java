package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
    private Long no;           // 게시글 번호
    private String title;     // 게시글 제목
    private String content;    // 게시글 내용 (CLOB)
    private LocalDate boardDate; // 게시글 작성일
    private Long memNo;       // 작성자 회원 번호 (members 테이블의 id)
    private Integer del;      // 삭제 여부 (0: 활성, 1: 비활성)
}
