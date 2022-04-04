package com.group.exam.board.vo;

import java.util.Date;

public class MemberVo {
	
	private int mSeq;
	private String mId;
	private String mBpw;
	private String mPassword;
	private String mNickname;
	private Date mBirthday;
	private Date mRegday;
	private String mAuth;
	private String mAuthkey;
	private int mLevel;
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmBpw() {
		return mBpw;
	}
	public void setmBpw(String mBpw) {
		this.mBpw = mBpw;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
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
	public String getmAuthkey() {
		return mAuthkey;
	}
	public void setmAuthkey(String mAuthkey) {
		this.mAuthkey = mAuthkey;
	}
	public int getmLevel() {
		return mLevel;
	}
	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
	}
	@Override
	public String toString() {
		return "MemberVo [mSeq=" + mSeq + ", mId=" + mId + ", mBpw=" + mBpw + ", mPassword=" + mPassword
				+ ", mNickname=" + mNickname + ", mBirthday=" + mBirthday + ", mRegday=" + mRegday + ", mAuth=" + mAuth
				+ ", mAuthkey=" + mAuthkey + ", mLevel=" + mLevel + "]";
	}
	
	
	

}
