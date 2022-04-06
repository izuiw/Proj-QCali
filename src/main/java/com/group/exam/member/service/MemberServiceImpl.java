package com.group.exam.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.member.command.LoginCommand;
import com.group.exam.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public List<LoginCommand> login(String mId) {
		// TODO Auto-generated method stub
		
		return memberDAO.login(mId);
		
	}

}
