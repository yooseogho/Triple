package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Board;

@Mapper
public interface BoardDao {

    // 게시글 추가
    Integer insertBoard(Board board);

    // 게시글 조회 (게시글 번호로 조회)
    Board selectBoardByNo(Long no);

    // 모든 게시글 조회
    List<Board> selectAllBoards();

    // 게시글 수정
    Integer updateBoard(Board board);

    // 게시글 삭제 (비활성화)
    
    Integer deleteBoardByNo(Long no);
    
}
