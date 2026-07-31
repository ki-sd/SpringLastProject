package com.sist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sist.service.MemberService;
import com.sist.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final BCryptPasswordEncoder encoder;
	private final MemberService mService;
	
	@GetMapping("member/signup.do")
	public String member_signup(Model model) {
		model.addAttribute("main_jsp", "../member/signup.jsp");
		return "main/main";
	}
	@PostMapping("member/signup_ok.do")
	public String member_signup_ok(MemberVO vo) {
		String enPwd=encoder.encode(vo.getUserpwd());
		vo.setUserpwd(enPwd);
		mService.memberInsert(vo);
		return "redirect:../main/main.do";
	}
	@GetMapping("member/login.do")
	public String member_login(Model model) {
		model.addAttribute("main_jsp", "../member/login.jsp");
		return "main/main";
	}
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id,String pwd,HttpServletRequest request) {
		HttpSession session=request.getSession();
		MemberVO vo=mService.memberLogin(id, pwd);
		if(vo.getMsg()=="OK") {
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("username", vo.getUsername());
			session.setAttribute("enable", vo.getEnable());
		}else {
			session.setAttribute("msg", vo.getMsg());
		}
		return "redirect:../main/main.do";
	}
}
