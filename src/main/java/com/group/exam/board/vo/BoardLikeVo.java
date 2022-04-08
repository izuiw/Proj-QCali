package com.group.exam.board.vo;

public class BoardLikeVo {
	
	private int lSeq;
	private int bSeq;
	private int mSeq;
	
	public int getlSeq() {
		return lSeq;
	}
	public void setlSeq(int lSeq) {
		this.lSeq = lSeq;
	}
	public int getbSeq() {
		return bSeq;
	}
	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	
	@Override
	public String toString() {
		return "BoardLikeVo [lSeq=" + lSeq + ", bSeq=" + bSeq + ", mSeq=" + mSeq + "]";
	}
	
	
	
	

}
