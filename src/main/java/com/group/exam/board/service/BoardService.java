package com.group.exam.board.service;

import java.util.HashMap;
import java.util.List;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.command.BoardupdateCommand;
import com.group.exam.board.command.QuestionAdayCommand;
import com.group.exam.board.vo.BoardHeartVo;
import com.group.exam.board.vo.BoardVo;
import com.group.exam.board.vo.ReplyVo;
import com.group.exam.utils.Criteria;

public interface BoardService {

	public void insertBoard(BoardVo boardVo); // 새 게시글 쓰기

	public List<BoardlistCommand> boardList(Criteria cri); // 게시글 전체 리스트

	public List<BoardlistCommand> boardMyList(Criteria cri, Long memberSeq); // 내가 쓴 글 불러오기

	public BoardlistCommand boardListDetail(Long boardSeq); // 해당 게시글 디테일

	public void boardCountup(Long boardSeq); // 해당 게시글 카운트 업

	public void deleteBoardOne(Long boardSeq); // 해당 게시글 삭제

	public int listCount(); // board 테이블 전체 글 수

	public int mylistCount(Long memberSeq); // 게시글 쓴 글 수

	public void updateBoard(BoardupdateCommand command); // 게시글 수정

	public String memberAuth(Long memberSeq); // 멤버 Auth 상태 확인

	public int memberLevelup(Long memberSeq, int mytotal, int memberLevel);

	public List<BoardlistCommand> boardSearch(HashMap<String, Object> map);// 닉네임, 제목으로 검색

	// 하루마다 질문 출력

	public QuestionAdayCommand questionselect(int num);

	public int getSequence();

	public int currentSequence();

	// 좋아요 기능 관련
	public void insertBoardLike(BoardHeartVo vo);

	public void deleteBoardLike(BoardHeartVo vo);

	public int getBoardLike(BoardHeartVo vo);

	// 댓글 기능 관련
	public List<ReplyVo> replySelect(Long boardSeq); // 게시글에 맞춰서 댓글 리스트 띄우기

	public void replyInsert(ReplyVo replyVo); // 댓글 쓰기

	public void replyUpdate(ReplyVo replyVo); // 댓글 수정

	public void replyDelete(Long replySeq); // 댓글 삭제

}
