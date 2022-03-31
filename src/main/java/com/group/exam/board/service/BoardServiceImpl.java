package com.group.exam.board.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.exam.board.dao.BoardDao;

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	

}
