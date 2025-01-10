package com.example.demo.controller;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Board;
import com.example.demo.entity.Members;
import com.example.demo.service.BoardService;
import com.example.demo.service.MembersService;
import com.example.demo.service.ProducerService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private ProducerService producerService;
	
	


	@GetMapping(value = {"/", "/index"})
	public String home(Model model, Principal principal) {
	    if (principal != null) {
	        // 로그인된 사용자가 있을 경우, 사용자 이름을 가져와서 모델에 추가
	        System.out.println("Logged in as: " + principal.getName()); // 로그인된 사용자의 이름을 로그로 확인
	        model.addAttribute("username", principal.getName());
	    } else {
	        System.out.println("No user logged in");
	    }

	    model.addAttribute("boards", boardService.getAllBoards());

	    return "index"; // index.jsp로 이동
	}

	
	
	
    // 게시글 번호로 게시글 조회
    @GetMapping("/{no}")
    public String getBoard(@PathVariable Long no, Model model) {
        Board board = boardService.getBoardByNo(no);
        model.addAttribute("board", board);
        return "view"; // 게시글 상세보기 페이지
    }
	
    @GetMapping("/write")
    public String getWritePage(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
            // 여기서 memNo를 추가하는 것이 필요할 수 있습니다
            // model.addAttribute("memNo", principal.getId()); // 사용자 ID가 필요할 경우
        }
        model.addAttribute("board", new Board());
        return "write";
    }
    
    
    
    
    @PostMapping("/write")
    public String addBoard(Board board, Principal principal, RedirectAttributes redirectAttributes) {
        if (principal == null) {
            redirectAttributes.addFlashAttribute("message", "로그인 정보가 없습니다.");
            return "redirect:/write";
        }

        String username = principal.getName();
     
        Members member = membersService.findById(username);
        if (member == null) {
            redirectAttributes.addFlashAttribute("message", "회원 정보를 찾을 수 없습니다.");
            return "redirect:/write";
        }

        board.setMemNo(member.getNo()); // 작성자 회원 번호 설정

       
        if (boardService.addBoard(board) > 0) {   // 게시글 저장
        	
            String message = String.format("New board created by %s: [Title: %s, Content: %s]", // Kafka에 메시지 전송
                    username, board.getTitle(), board.getContent());
            
            producerService.sendMessage(message); // Kafka 토픽으로 메시지 전송

            redirectAttributes.addFlashAttribute("message", "게시글이 성공적으로 작성되었습니다.");
            return "redirect:/index";
            
        } 
        
        else {
            redirectAttributes.addFlashAttribute("message", "게시글 작성에 실패했습니다.");
            return "redirect:/write";
        }
    }
    
    
    
    
    
    
    


    
}
