package com.group.exam.member.command;

public class MemberMypageCommand {

	private String memberPassword;
	
	private String memberBpw;

	private String MemberNickname;
	
	
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberBpw() {
		return memberBpw;
	}
	public void setMemberBpw(String memberBpw) {
		this.memberBpw = memberBpw;
	}
	public String getMemberNickname() {
		return MemberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		MemberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "MemberMypageCommand [memberPassword=" + memberPassword + ", memberBpw=" + memberBpw
				+ ", MemberNickname=" + MemberNickname + "]";
	}
	
	
	
}
