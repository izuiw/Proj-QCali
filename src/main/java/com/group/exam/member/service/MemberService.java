package com.group.exam.member.service;

import java.util.List;

import com.group.exam.member.command.LoginCommand;

public interface MemberService {
	
	public List<LoginCommand> login(String mid);//로그인

}
