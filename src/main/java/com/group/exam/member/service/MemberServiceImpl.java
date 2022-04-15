package com.group.exam.member.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.member.command.InsertCommand;
import com.group.exam.member.command.LoginCommand;
import com.group.exam.member.dao.MemberDAO;
import com.group.exam.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public LoginCommand login(String mId) {
		// TODO Auto-generated method stub
		
		return memberDAO.login(mId);
		
	}

	@Override
	public LoginCommand findPwd(String mId) {
		// TODO Auto-generated method stub
		return memberDAO.findPwd(mId);
	}

	@Override
	public int updateTmpPwd(String tmpPwd, String mId) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tmpPwd", tmpPwd);
		map.put("mId", mId);
				
		return memberDAO.updateTmpPwd(map);
	}


	
	
	
	@Override
	public void insert(InsertCommand insertCommand) {
		
		MemberVo memberVo = new MemberVo();
		memberVo.setmId(insertCommand.getmId());
		memberVo.setmPassword(insertCommand.getmPassword());
		memberVo.setmNickname(insertCommand.getmNickname());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(insertCommand.getmBirthday());
			memberVo.setmBirthday(date);
			System.out.println(memberVo);
			memberDAO.insert(memberVo);
		} catch (ParseException e) {
			//날짜로 형변환 실패
		}
		
 
	}

	@Override
	public int nicknameDup(String mNickname) {
		int res = memberDAO.nicknameDup(mNickname);
		return res;
	}

	@Override
	public int idDup(String mId) {	
		return memberDAO.idDup(mId);
	}
	
	@Override
	public void updateAuthkey(InsertCommand insertCommand) {
		MemberVo memberVo = new MemberVo();
		memberVo.setmId(insertCommand.getmId());
		memberVo.setmAuthkey(insertCommand.getmAuthkey());
		memberDAO.updateAuthkey(memberVo);
	}
	
	public void updateAuth(String mAuthkey) {
		MemberVo memberVo = new MemberVo();
		memberVo.setmAuth("T");
		memberVo.setmAuthkey(mAuthkey);
		memberDAO.updateAuth(memberVo);
	}

	@Override
	public int updateMemberPwd(String mPassword, int mSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("mPassword", mPassword);
		map.put("mSeq", mSeq);
		return memberDAO.updateMemberPwd(map);
	}

	@Override
	public int updateMemberNickname(String mNickname, int mSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mNickname", mNickname);
		map.put("mSeq", mSeq);
		
		return memberDAO.updateMemberNickname(map);
	}

	@Override
	public int deleteMember(int mSeq) {
		// TODO Auto-generated method stub
		return memberDAO.deleteMember(mSeq);
	}

	@Override
	public int memberQuestionAdd(String qContent, int mSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qContent", qContent);
		map.put("mSeq", mSeq);
		return memberDAO.memberQuestionAdd(map);
	}


}
