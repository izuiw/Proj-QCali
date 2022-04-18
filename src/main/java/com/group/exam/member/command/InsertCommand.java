package com.group.exam.member.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class InsertCommand {
	@NotBlank(message="이메일을 입력하세요.")
	@Email(message="형식에 맞게 입력하세요.")
	private String mId ;
	
	@NotBlank(message="비밀번호를 입력하세요.")
	private String mPassword;
	@NotBlank(message="비밀번호를 입력하세요.")
	private String mPasswordCheck;
	@NotBlank(message="닉네임을 입력하세요.")
	private String mNickname;
	@NotBlank(message="생년월일을 입력하세요.")
	private String mBirthday;
	
	private String mAuthkey;
	
	
	public String getmAuthkey() {
		return mAuthkey;
	}
	public void setmAuthkey(String mAuthkey) {
		this.mAuthkey = mAuthkey;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
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
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getmBirthday() {
		return mBirthday;
	}
	public void setmBirthday(String mBirthday) {
		this.mBirthday = mBirthday;
	}
	@Override
	public String toString() {
		return "InsertCommand [mId=" + mId + ", mPassword=" + mPassword + ", mPasswordCheck=" + mPasswordCheck
				+ ", mNickname=" + mNickname + ", mBirthday=" + mBirthday + ", mAuthkey=" + mAuthkey + "]";
	}

	
	
	
	

}
