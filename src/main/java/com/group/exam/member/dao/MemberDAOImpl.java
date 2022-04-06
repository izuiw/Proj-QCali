package com.group.exam.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.member.command.LoginCommand;
import com.group.exam.member.vo.MemberVo;

@Repository
public class MemberDAOImpl implements MemberDAO{

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberDAOImpl (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<LoginCommand> login(String mId) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectList("login", mId);
		
	}

}