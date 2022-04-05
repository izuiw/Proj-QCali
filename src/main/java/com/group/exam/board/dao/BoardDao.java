package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo);
	
	public void updateBoard (HashMap<String, String> map); 
	
	public void deleteBoardOne (HashMap<String, Integer> map);
	
	public List<BoardlistCommand> boardList(Criteria cri);
	
	public List<BoardlistCommand> boardListAday (String bRegday);
	
	public List<BoardlistCommand> boardListMy (int mSeq);
	
	public List<BoardlistCommand> boardListDetail (int bSeq);
	
	public void updateCount (int bSeq);
	
	public String pwdCheck (HashMap<String, String> map); 
	
	public void boardCountup (HashMap<String, Integer> map);
}
