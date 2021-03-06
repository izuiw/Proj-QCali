package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import org.omg.CORBA.OBJ_ADAPTER;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.command.BoardupdateCommand;
import com.group.exam.board.command.QuestionAdayCommand;
import com.group.exam.board.vo.BoardHeartVo;
import com.group.exam.board.vo.BoardVo;
import com.group.exam.board.vo.ReplyVo;
import com.group.exam.utils.Criteria;

public interface BoardDao {
	
	public void insertBoard (BoardVo boardVo); //새 게시글 쓰기
	
	public void updateBoard (BoardupdateCommand command); //게시글 수정
	
	public void deleteBoardOne (Long boardSeq); //게시글 삭제
	
	public List<BoardlistCommand> boardList(Criteria cri); // 게시글 전체 리스트
	
	public List<BoardlistCommand> boardMyList (HashMap<String, Object> map); // 내가 쓴 글 모아보기
	
	public BoardlistCommand boardListDetail (Long boardSeq); // 특정 게시글 디테일
	
	public int listCount (); // board 테이블 전체 글 수
	
	public int boardMylistCount (Long memberSeq); // 내가 쓴 글 수 
	
	public void boardCountup (Long boardSeq); // 해당 게시글 카운트 업
	
	public String memberAuth (Long memberSeq); //멤버 Auth 상태 체크
	
	public int memberLevelup (HashMap<String, Object> map); //멤버 level up 기능
	
	public List<BoardlistCommand> boardSearch (HashMap<String, Object> map); //닉네임, 제목으로 검색
	
	public int boardSearchCount (HashMap<String, Object> map); //서치 게시글 수
	
	//질문 하루마다 출력 기능 관련
	public QuestionAdayCommand questionselect(int num);
	
	public int getSequence();
	
	public int currentSequence();
	
	//좋아요 기능 관련
    public int getBoardLike(BoardHeartVo vo);

    public void insertBoardLike(BoardHeartVo vo);

    public void deleteBoardLike(BoardHeartVo vo);

    public void updateBoardLike(Long boardSeq);
    
  //댓글 기능 관련
  	public List<ReplyVo> replySelect(Long boardSeq); // 게시글에 맞춰서 댓글 리스트 띄우기
  	
  	public int replyCount(Long boardSeq); //댓글 갯수 카운트  -> 해당 글에 달린 댓글 수를 가져와야함.
  	
  	public void replyInsert(ReplyVo replyVo); //댓글 쓰기
  	
  	public void replyUpdate(ReplyVo replyVo); //댓글 수정
  	
  	public void replyDelete(Long replySeq); //댓글 삭제
    
}
