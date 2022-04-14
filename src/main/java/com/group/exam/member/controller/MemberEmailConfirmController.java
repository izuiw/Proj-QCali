package com.group.exam.member.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.exam.member.service.MemberService;

@Controller
public class MemberEmailConfirmController {
	
	@Autowired
	private MemberService memberService;
	
	
	 @RequestMapping(value="/member/EmailConfirm") 
	 public String signUpConfirm(HttpServletRequest request){
		 String mId= request.getParameter("email");
		 String mAuthkey = request.getParameter("authKey");
		 if(memberService.idDup(mId)==1) { //가입된 이메일이 있다면
			 memberService.updateAuth(mAuthkey);	//mAuth를 'T'로 바꾸기 
		 }

	    return "/member/signUpSuccess";
	}
	 
	 

	 

}
