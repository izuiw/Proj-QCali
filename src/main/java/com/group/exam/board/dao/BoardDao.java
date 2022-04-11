package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardLikeVo;
import com.group.exam.board.vo.BoardVo;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo); //새 게시글 쓰기
	
	public void updateBoard (HashMap<String, Object> map); //게시글 수정
	
	public void deleteBoardOne (HashMap<String, Integer> map); //게시글 삭제
	
	public List<BoardlistCommand> boardList(Criteria cri); // 게시글 전체 리스트
	
	public List<BoardlistCommand> boardMyList (HashMap<String, Object> mapq); // 내가 쓴 글 모아보기
	
	public List<BoardlistCommand> boardListDetail (int bSeq); // 특정 게시글 디테일
	
	public int listCount (); // board 테이블 전체 글 수
	
	public int boardMylistCount (int mSeq); // 내가 쓴 글 수 
	
	public void boardCountup (int bSeq); // 해당 게시글 카운트 업
	
	public String memberAuth (int mSeq); //멤버 Auth 상태 체크
	
	//좋아요 기능 관련
    public int getBoardLike(BoardLikeVo vo);

    public void insertBoardLike(BoardLikeVo vo);

    public void deleteBoardLike(BoardLikeVo vo);

    public void updateBoardLike(int bSeq);
}
