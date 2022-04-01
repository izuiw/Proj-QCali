package com.group.exam.board.command;

import java.util.Date;

public class ListAdayCommand {
	
	private int bSeq;
	private String bTitle;
	private Date bRegday;
	private int bLike;
	private int bCount;
	private String mNickname;
	public int getbSeq() {
		return bSeq;
	}
	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public Date getbRegday() {
		return bRegday;
	}
	public void setbRegday(Date bRegday) {
		this.bRegday = bRegday;
	}
	public int getbLike() {
		return bLike;
	}
	public void setbLike(int bLike) {
		this.bLike = bLike;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	@Override
	public String toString() {
		return "ListAdayCommand [bSeq=" + bSeq + ", bTitle=" + bTitle + ", bRegday=" + bRegday + ", bLike=" + bLike
				+ ", bCount=" + bCount + ", mNickname=" + mNickname + "]";
	}
	
	
	

}
