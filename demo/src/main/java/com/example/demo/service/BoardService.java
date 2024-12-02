package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.Board;
@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
    // 모든 게시글 조회
	public List<Board> getAllBoards() {
	    return boardDao.selectAllBoards();
	}
	
    // 게시글 번호로 게시글 조회
    public Board getBoardByNo(Long no) {
        return boardDao.selectBoardByNo(no);
    }
    
    

    public Integer addBoard(Board board) {
        // 작성일 및 기본값 설정
        if (board.getBoardDate() == null) {
            board.setBoardDate(LocalDate.now());
        }
        if (board.getDel() == null) {
            board.setDel(0);
        }

        // 데이터베이스에 저장
        return boardDao.insertBoard(board);
    }
	
}
