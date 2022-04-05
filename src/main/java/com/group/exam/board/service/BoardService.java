package com.group.exam.board.service;

import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;


public interface BoardService {
	
	public void insertBoard(BoardVo boardVo);
	
	public List<BoardlistCommand> boardList(Criteria cri);
	
	public List<BoardlistCommand> boardListAday(String bRegday);
	
	public List<BoardlistCommand> boardListMy(int mSeq);
	
	public List<BoardlistCommand> boardListDetail(int bSeq);
	
	public void boardCountup(int bSeq, int mSeq);
	
	public void deleteBoardOne(int bSeq, int mSeq);
	


}
