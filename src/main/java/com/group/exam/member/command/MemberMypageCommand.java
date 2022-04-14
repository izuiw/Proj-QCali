package com.group.exam.member.command;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberMypageCommand {
	@NotEmpty(message = "비밀버호를 입력해주세요.")
	private String memberPassword;
	
	private String memberBpw;
	@NotEmpty(message = "닉네임을 입력해주세요.")
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
