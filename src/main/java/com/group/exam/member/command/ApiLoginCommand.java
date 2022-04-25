package com.group.exam.member.command;

public class ApiLoginCommand {

	private String memberId;
	private String memberApi;
	private String memberBirthDay;
	private String memberNickname;
	@Override
	public String toString() {
		return "ApiLoginCommand [memberId=" + memberId + ", memberApi=" + memberApi + ", memberBirthDay="
				+ memberBirthDay + ", memberNickname=" + memberNickname + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberApi() {
		return memberApi;
	}
	public void setMemberApi(String memberApi) {
		this.memberApi = memberApi;
	}
	public String getMemberBirthDay() {
		return memberBirthDay;
	}
	public void setMemberBirthDay(String memberBirthDay) {
		this.memberBirthDay = memberBirthDay;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	
	
}
