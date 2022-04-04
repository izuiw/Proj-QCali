package com.group.exam.board.service;

import java.util.List;

import com.group.exam.board.command.ListCommand;
import com.group.exam.board.vo.BoardVo;


public interface BoardService {
	
	public void insertBoard(BoardVo boardVo);
	
	public List<ListCommand> boardList();
	
	public List<ListCommand> boardListAday(String bRegday);
	
	public List<ListCommand> boardListMy(int mSeq);
	
	public List<ListCommand> boardListDetail(int bSeq);
	
	public void deleteBoardOne(int bSeq, int mSeq);
	


}
