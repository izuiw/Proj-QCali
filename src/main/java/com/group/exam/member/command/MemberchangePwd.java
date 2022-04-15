package com.group.exam.member.command;

import org.hibernate.validator.constraints.NotBlank;


public class MemberchangePwd {
	@NotBlank(message = "비밀번호를 입력하세요.")
	private String mPassword;
	@NotBlank(message="비밀번호를 입력하세요.")
	private String mPasswordCheck;

	
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmPasswordCheck() {
		return mPasswordCheck;
	}
	public void setmPasswordCheck(String mPasswordCheck) {
		this.mPasswordCheck = mPasswordCheck;
	}
	
	

	
	
	
	

	

}
