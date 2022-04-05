package com.group.exam.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.dao.BoardDao;
import com.group.exam.board.utils.Criteria;
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
	public List<BoardlistCommand> boardListAday(String bRegday) {
		// TODO Auto-generated method stub
		return boardDao.boardListAday(bRegday);
	}


	@Override
	public List<BoardlistCommand> boardList(Criteria cri) {
		// TODO Auto-generated method stub
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		return boardDao.boardList(cri);
	}


	@Override
	public List<BoardlistCommand> boardListMy(int mSeq) {
		// TODO Auto-generated method stub
		return boardDao.boardListMy(mSeq);
	}
	

	@Override
	public List<BoardlistCommand> boardListDetail(int bSeq) {
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


	//게시물 조횟수 up
	@Override
	public void boardCountup(int bSeq, int mSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("bSeq", bSeq);
		map.put("mSeq", mSeq);
		boardDao.boardCountup(map);
		
	}


	
	
	
	

}
