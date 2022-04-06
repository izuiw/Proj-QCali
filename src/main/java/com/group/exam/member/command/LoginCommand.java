package com.group.exam.member.command;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("LoginCommand")
public class LoginCommand {
	private int mSeq;
	@NotEmpty(message = "아이디를 입력해주세요.")
	private String mId;
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	private String mPassword;

	private String mNickname;
	private Date mBirthday;
	private Date mRegday;
	private String mAuth;

	private int mLevel;

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public Date getmBirthday() {
		return mBirthday;
	}

	public void setmBirthday(Date mBirthday) {
		this.mBirthday = mBirthday;
	}

	public Date getmRegday() {
		return mRegday;
	}

	public void setmRegday(Date mRegday) {
		this.mRegday = mRegday;
	}

	public String getmAuth() {
		return mAuth;
	}

	public void setmAuth(String mAuth) {
		this.mAuth = mAuth;
	}

	public int getmLevel() {
		return mLevel;
	}

	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
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

	@Override
	public String toString() {
		return "LoginCommand [mSeq=" + mSeq + ", mId=" + mId + ", mPassword=" + mPassword + ", mNickname=" + mNickname
				+ ", mBirthday=" + mBirthday + ", mRegday=" + mRegday + ", mAuth=" + mAuth + ", mLevel=" + mLevel + "]";
	}


}
