package com.group.exam.member.dao;

import java.util.List;

import com.group.exam.member.command.LoginCommand;

	
public interface MemberDAO {
	
	public abstract List<LoginCommand> login(String mId);//로그인

}
