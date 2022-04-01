package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.ListAdayCommand;
import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo);
	
	public void updateBoard (HashMap<String, String> map); 
	
	public void deleteBoardOne (int bSeq);
	
	public List<ListAdayCommand> boardListAday (String bRegday);
	
	public List<BoardVo> boardListMy (HashMap<String, String> map);
	
	public BoardVo boardListDetail (int bSeq);
	
	public void updateCount (int bSeq);
	
	public String pwdCheck (HashMap<String, String> map); 
}
