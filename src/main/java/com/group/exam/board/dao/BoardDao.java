package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo); //새 게시글 쓰기
	
	public void updateBoard (HashMap<String, String> map); //게시글 수정
	
	public void deleteBoardOne (HashMap<String, Integer> map); //게시글 삭제
	
	public List<BoardlistCommand> boardList(Criteria cri); // 게시글 전체 리스트
	
	public List<BoardlistCommand> boardListAday (String bRegday); //특정 날짜에 올린 게시글 리스트
	
	public List<BoardlistCommand> boardListMy (int mSeq); // 내가 쓴 글 모아보기
	
	public List<BoardlistCommand> boardListDetail (int bSeq); // 특정 게시글 디테일
	
	public int listCount (); // board 테이블 전체 글 수
	
	public String pwdCheck (HashMap<String, String> map);  // 패스워드 체크? 아직 안씀
	
	public void boardCountup (HashMap<String, Integer> map); // 해당 게시글 카운트 업
}
