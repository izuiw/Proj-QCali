package com.group.exam.board.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo);
	
	public void updateBoard (HashMap<String, String> map); 
	
	public void deleteBoardOne (int mSeq);
	
	public List<BoardVo> boardListAday (Date bRegday);
	
	public List<BoardVo> boardListMy (int mSeq);
	
	public BoardVo boardListDetail (int bSeq);
	
	public void updateCount (int bSeq);
	
	public String pwdCheck (HashMap<String, String> map); 
}
