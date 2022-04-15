package com.group.exam.member.dao;

import java.util.HashMap;
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
	public LoginCommand login(String mId) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectOne("login", mId);
		
	}

	@Override
	public LoginCommand findPwd(String mId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("findPwd", mId);
	}

	@Override
	public int updateTmpPwd(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateTmpPwd", map);
	}
	
	
	
	@Override
	public void insert(MemberVo memberVo) {
		sqlSessionTemplate.insert("insert", memberVo);

	}

	@Override
	public int nicknameDup(String mNickname) {
		int res = sqlSessionTemplate.selectOne("nicknameDup", mNickname);
		return res;
	}

	@Override
	public int idDup(String mId) {
		return sqlSessionTemplate.selectOne("idDup", mId);

	}

	@Override
	public void updateAuthkey(MemberVo memberVo) {
		sqlSessionTemplate.update("updateAuthkey", memberVo);
	}
	
	@Override
	public void updateAuth(MemberVo memberVo) {
		sqlSessionTemplate.update("updateAuth", memberVo);
	}

	@Override
	public int updateMemberPwd(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateMemberPwd", map);
	}

	@Override
	public int updateMemberNickname(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateMemberNickname", map);
	}

	@Override
	public int deleteMember(int mSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteMember", mSeq);
	}

	@Override
	public int memberQuestionAdd(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("memberQuestionAdd", map);
	}
	

}
