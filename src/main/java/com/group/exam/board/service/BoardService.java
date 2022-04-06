package com.group.exam.board.service;

import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;


public interface BoardService {
	
	public void insertBoard(BoardVo boardVo); // 새 게시글 쓰기
	
	public List<BoardlistCommand> boardList(Criteria cri); // 게시글 전체 리스트
	
	public List<BoardlistCommand> boardListAday(String bRegday); // 특정 날짜 게시글 불러오기
	
	public List<BoardlistCommand> boardListMy(int mSeq); // 내가 쓴 글 불러오기
	
	public List<BoardlistCommand> boardListDetail(int bSeq); // 해당 게시글 디테일
	
	public void boardCountup(int bSeq); // 해당 게시글 카운트 업
	
	public void deleteBoardOne(int bSeq, int mSeq); // 해당 게시글 삭제
	
	public int listCount(); // board 테이블 전체 글 수


}
