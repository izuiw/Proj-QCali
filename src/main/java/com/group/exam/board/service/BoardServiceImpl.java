package com.group.exam.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.board.command.ListCommand;
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
	public List<ListCommand> boardListAday(String bRegday) {
		// TODO Auto-generated method stub
		return boardDao.boardListAday(bRegday);
	}


	@Override
	public List<ListCommand> boardList() {
		// TODO Auto-generated method stub
		return boardDao.boardList();
	}


	@Override
	public List<ListCommand> boardListMy(int mSeq) {
		// TODO Auto-generated method stub
		return boardDao.boardListMy(mSeq);
	}
	

	@Override
	public List<ListCommand> boardListDetail(int bSeq) {
		// TODO Auto-generated method stub
		return boardDao.boardListDetail(bSeq);
	}
	


	@Override
	public void deleteBoardOne(int bSeq, int mSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("bSeq", bSeq);
		map.put("mSeq", mSeq);
		boardDao.deleteBoardOne(map);
		
		
		
	}


	
	
	
	

}
