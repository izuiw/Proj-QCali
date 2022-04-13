package com.group.exam.board.command;

public class QuestionAdayCommand {

	private String qContent;
	private int qSeq;
	private String qStatus;
	private int mSeq;
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public int getqSeq() {
		return qSeq;
	}
	public void setqSeq(int qSeq) {
		this.qSeq = qSeq;
	}
	public String getqStatus() {
		return qStatus;
	}
	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	@Override
	public String toString() {
		return "QuestionAdayCommand [qContent=" + qContent + ", qSeq=" + qSeq + ", qStatus=" + qStatus + ", mSeq="
				+ mSeq + "]";
	}
	

	
	

	
	
	
}
