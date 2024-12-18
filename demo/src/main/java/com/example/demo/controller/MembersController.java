package com.example.demo.controller;

import com.example.demo.dao.MembersDao;
import com.example.demo.entity.Members;
import com.example.demo.service.MembersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class MembersController {
	
	@Autowired
    private  MembersDao membersDao;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
    private  PasswordEncoder passwordEncoder;

    // 회원가입 페이지 표시
    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("member", new Members()); // 회원 객체를 모델에 추가하여 폼에 전달
        return "signup"; // signup.jsp 페이지 반환
    }

    @GetMapping("/login")
    public String loginForm() {
    	
        return "login"; // login.jsp로 매핑
    }
    
    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(@ModelAttribute Members member) {
        // 비밀번호 암호화 처리
        member.setPasswd(passwordEncoder.encode(member.getPasswd()));
        
        // 회원 데이터 저장
        membersService.insertMember(member);

        // 회원가입 후 로그인 페이지로 리디렉션
        return "redirect:./login";

        
    }
    

    

    
    
    
    
}
