package com.group.exam.board.command;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

//@Alias("BoardupdateCommand")
public class BoardupdateCommand {
	
	private int bSeq;
	private int mSeq;
	@NotBlank(message="제목을 입력해 주세요")
	private String bTitle;
	@NotEmpty(message="내용을 입력해 주세요")
	private String bContent;
	
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
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	@Override
	public String toString() {
		return "BoardupdateCommand [bSeq=" + bSeq + ", mSeq=" + mSeq + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ "]";
	}
	
	


	
}
