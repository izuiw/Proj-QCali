package com.group.exam.member.service;

<<<<<<< HEAD
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> e63b26cf916ffc35596a68f8ce98ae02733a93c7
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
	public List<LoginCommand> login(String mId) {
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

<<<<<<< HEAD
	
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

=======
>>>>>>> e63b26cf916ffc35596a68f8ce98ae02733a93c7
}
