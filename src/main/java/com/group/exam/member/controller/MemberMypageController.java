package com.group.exam.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group.exam.member.command.MemberMypageCommand;
import com.group.exam.member.service.MemberService;

@Controller
public class MemberMypageController {

	private MemberService memberService;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberMypageController(MemberService memberService ,BCryptPasswordEncoder passwordEncoder) {
		
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping(value = "/member/Mypage", method = RequestMethod.GET) 
	public String changePwd (@RequestParam MemberMypageCommand mypageCommand, HttpSession session) {
		return "/member/mypage";
	}
	
	
	@RequestMapping(value = "/member/Mypage", method = RequestMethod.POST) 
	public String changePwd (@ModelAttribute("mypagePassword") MemberMypageCommand mypageCommand, BindingResult bindingResult
			,Model model, HttpSession session) {
		
		if (bindingResult.hasErrors()) {
			return "/member/mypage";
		}
		
		
		return "";
	}
	
	
	
}
