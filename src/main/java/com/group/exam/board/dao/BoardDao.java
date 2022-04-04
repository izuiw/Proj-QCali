package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.ListCommand;
import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo);
	
	public void updateBoard (HashMap<String, String> map); 
	
	public void deleteBoardOne (HashMap<String, Integer> map);
	
	public List<ListCommand> boardList();
	
	public List<ListCommand> boardListAday (String bRegday);
	
	public List<ListCommand> boardListMy (int mSeq);
	
	public List<ListCommand> boardListDetail (int bSeq);
	
	public void updateCount (int bSeq);
	
	public String pwdCheck (HashMap<String, String> map); 
}
