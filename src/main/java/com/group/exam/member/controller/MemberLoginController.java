package com.group.exam.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.member.command.LoginCommand;
import com.group.exam.member.command.MemberFindPwdCommand;
import com.group.exam.member.command.NaverLoginBO;
import com.group.exam.member.service.MailSendService;
import com.group.exam.member.service.MemberService;
import com.group.exam.utils.MemberSessionConfig;


@Controller
public class MemberLoginController {
	
	
	private BCryptPasswordEncoder passwordEncoder;
	
	private NaverLoginBO naverLoginBO;
	
	private MemberService memberService;
	
	private MailSendService mss;
	
	@Autowired
	public MemberLoginController(BCryptPasswordEncoder passwordEncoder, MemberService memberService, NaverLoginBO naverLoginBO,
			MailSendService mss) {
		
		// TODO Auto-generated constructor stub
		this.passwordEncoder = passwordEncoder;
		this.memberService = memberService;
		this.naverLoginBO = naverLoginBO;
		this.mss = mss;
	}

	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String handleLogin(@ModelAttribute("loginMemberData") LoginCommand logincommand, HttpSession session, Model model) {
		
		//네이버 로그인
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("네이버:" + naverAuthUrl);
		
		model.addAttribute("naverLoginURL", naverAuthUrl);
		
		//카카오 로그인 추가
		
		
		
		
		//로그인 세션이 이미 있을 경우 
		if (session.getAttribute("memberLogin") != null) {
			return "home";
		}
		return "/member/loginForm";
	}
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginMemberData") LoginCommand command, BindingResult bindingResult,HttpSession session, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/member/loginForm";
		}
		
		
		LoginCommand member = memberService.login(command.getMemberId());
		
		if(member == null) {
			System.out.println("로그인 정보 없음 : " + member);
			
			model.addAttribute("msg", "해당 회원 정보가 없습니다.");
			
		}
	
		
		//네이버 - 카카오 간편 로그인  한 적있는 계정 체크 
		if(member != null && member.getNaver().equals("T")) {
			
			model.addAttribute("msg", "네이버 간편 로그인 사용 기록이 있습니다.");
			return "/member/loginForm";
		
		} else if (member != null && member.getKakao().equals("T")) {
		
			model.addAttribute("msg", "카카오 간편 로그인 사용 기록이 있습니다.");
			return "/member/loginForm";
		}
		
		
		String password = command.getMemberPassword();
		
		LoginCommand login = member;
		
		//로그인 (비밀번호 암호화 했을 때)
		String encodePassword = memberService.findPwd(command.getMemberId()).getMemberPassword();
		boolean pwdEncode= passwordEncoder.matches(password, encodePassword);
	
		
		
		if(member != null && pwdEncode) {

			System.out.println("로그인 성공 ");
			
			//중복 로그인 방지
			String memberId = MemberSessionConfig.getSessionidCheck("memberLogin", command.getMemberId());
			
			// 세션 만료 시간
			session.setMaxInactiveInterval(60 * 60);

			session.setAttribute("memberLogin", login);	
			return "redirect:/board/list";
			
		} else {
			System.out.println("비밀번호 불일치 : " + member);
			
			model.addAttribute("msg", "해당 회원 정보가 없습니다.");
			
		}
		
		return "/member/loginForm";
	}
	
	

	@RequestMapping(value = "/member/findPwd", method = RequestMethod.GET)
	public String findPwd(@ModelAttribute("findPwdData") MemberFindPwdCommand findcommand) {

		return "member/findPwdForm";
	}

	@RequestMapping(value = "/member/findPwd", method = RequestMethod.POST)
	public String findPwd(@Valid @ModelAttribute("findPwdData") MemberFindPwdCommand findcommand,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "member/findPwdForm";
		}

		LoginCommand findMember = memberService.findPwd(findcommand.getMemberId());

		if (findMember != null) {
			String tmpPwd = mss.sendPwdMail(findcommand.getMemberId()); // 임시 비밀번호 메일 발송
			String encodePwd = passwordEncoder.encode(tmpPwd); // 임시 비밀번호 암호화

			int result = memberService.updateTmpPwd(encodePwd, findcommand.getMemberId()); // db에 해당 회원 비밀번호 임시 비밀번호로 변경

			if (result == 1) {
				// 임시 비밀번호로 변경 성공
				return "member/member_alert/findPwdNext";
			}

		}

		model.addAttribute("msg", "해당 회원 정보가 없습니다.");
		return "member/findPwdForm";
	}
	
	
	
	
}
