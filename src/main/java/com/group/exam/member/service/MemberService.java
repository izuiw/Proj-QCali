package com.group.exam.member.service;

import java.util.List;

import com.group.exam.member.command.LoginCommand;

public interface MemberService {
	
	public List<LoginCommand> login(String mid);//로그인
	
	public LoginCommand findPwd(String mId); //비밀번호 찾기 관련 => 해당 하는 회원 정보 가져오기
	
	public int updateTmpPwd(String tmpPwd, String mId);

}
