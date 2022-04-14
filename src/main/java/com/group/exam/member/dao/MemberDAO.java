package com.group.exam.member.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.member.command.LoginCommand;

	
public interface MemberDAO {
	
	public abstract List<LoginCommand> login(String mId);//로그인
	
	public abstract LoginCommand findPwd(String mId); // 비밀번호 찾기 => 아이디 검색
	
	public abstract int updateTmpPwd(HashMap<String, Object> map); //임시 비밀번호 셋팅 

}
