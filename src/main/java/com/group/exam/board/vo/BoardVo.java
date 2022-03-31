package com.group.exam.board.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("BoardVo")
public class BoardVo {
	
	private int bSeq;
	@NotEmpty(message="제목을 입력해주세요.")
	private String bTitle;
	@NotEmpty(message="내용을 입력해주세요.")
	private String bContent;
	private Date bRegday;
	private int bLike;
	private int bCount;
	private int mSeq;
	private int qSeq;
	
	
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
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
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
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	public int getqSeq() {
		return qSeq;
	}
	public void setqSeq(int qSeq) {
		this.qSeq = qSeq;
	}
	@Override
	public String toString() {
		return "BoardVo [bSeq=" + bSeq + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bRegday=" + bRegday
				+ ", bLike=" + bLike + ", bCount=" + bCount + ", mSeq=" + mSeq + ", qSeq=" + qSeq + "]";
	}
	
	
}
