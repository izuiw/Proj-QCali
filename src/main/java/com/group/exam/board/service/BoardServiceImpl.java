package com.group.exam.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.board.command.ListAdayCommand;
import com.group.exam.board.dao.BoardDao;
import com.group.exam.board.vo.BoardVo;
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardServiceImpl () {
		
	}
	

	@Override
	public void insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
	
		boardDao.insertBoard(boardVo);
		
	}

	@Override
	public List<ListAdayCommand> boardListAday(String bRegday) {
		// TODO Auto-generated method stub
		return boardDao.boardListAday(bRegday);
	}
	
	
	
	
	

}
