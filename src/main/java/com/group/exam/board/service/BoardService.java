package com.group.exam.board.service;

import java.util.Date;
import java.util.List;

import com.group.exam.board.command.ListAdayCommand;
import com.group.exam.board.vo.BoardVo;


public interface BoardService {
	
	public void insertBoard(BoardVo boardVo);
	
	public List<ListAdayCommand> boardListAday(String bRegday);
	


}
