package com.group.exam.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.command.BoardupdateCommand;
import com.group.exam.board.command.QuestionAdayCommand;
import com.group.exam.board.dao.BoardDao;
import com.group.exam.board.vo.BoardHeartVo;
import com.group.exam.board.vo.BoardVo;
import com.group.exam.board.vo.ReplyVo;
import com.group.exam.utils.Criteria;
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
	public List<BoardlistCommand> boardList(Criteria cri) {
		// TODO Auto-generated method stub
		
		return boardDao.boardList(cri);
	}


	@Override
	public List<BoardlistCommand> boardMyList(Criteria cri, Long memberSeq) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		map.put("memberSeq", memberSeq);
		map.put("rowStart", cri.getRowStart());
		map.put("rowEnd", cri.getRowEnd());
		return boardDao.boardMyList(map);
	}
	

	@Override
	public BoardlistCommand boardListDetail(Long boardSeq) {
		// TODO Auto-generated method stub
		return boardDao.boardListDetail(boardSeq);
	}
	


	@Override
	public void deleteBoardOne(Long boardSeq) {
		// TODO Auto-generated method stub
		
		
		boardDao.deleteBoardOne(boardSeq);
		
		
		
	}


	//게시물 조횟수 up
	@Override
	public void boardCountup(Long boardSeq) {
		// TODO Auto-generated method stub

		boardDao.boardCountup(boardSeq);
		
	}


	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return boardDao.listCount();
	}


	@Override
	public void updateBoard(BoardupdateCommand command) {
		// TODO Auto-generated method stub
		
		boardDao.updateBoard(command);
		
	}


	@Override
	public int mylistCount(Long memberSeq) {
		// TODO Auto-generated method stub
		return boardDao.boardMylistCount(memberSeq);
	}


	@Override
	public void insertBoardLike(BoardHeartVo vo) {
		// TODO Auto-generated method stub
		boardDao.insertBoardLike(vo);
		boardDao.updateBoardLike(vo.getBoardSeq());
		
	}


	@Override
	public void deleteBoardLike(BoardHeartVo vo) {
		// TODO Auto-generated method stub
		boardDao.deleteBoardLike(vo);
		boardDao.updateBoardLike(vo.getBoardSeq());
		
	}


	@Override
	public int getBoardLike(BoardHeartVo vo) {
		// TODO Auto-generated method stub
		return boardDao.getBoardLike(vo);
	}


	@Override
	public String memberAuth(Long memberSeq) {
		// TODO Auto-generated method stub
		return boardDao.memberAuth(memberSeq);
	}


	@Override
	public int memberLevelup(Long memberSeq, int mytotal, int memberLevel) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberSeq", memberSeq);
		map.put("mytotal", mytotal);
		map.put("memberLevel", memberLevel);
		
		return boardDao.memberLevelup(map);
		
	}


	@Override
	public QuestionAdayCommand questionselect(int num) {
		// TODO Auto-generated method stub
		return boardDao.questionselect(num);
	}


	@Override
	public int getSequence() {
		// TODO Auto-generated method stub
		return boardDao.getSequence();
	}


	@Override
	public int currentSequence() {
		// TODO Auto-generated method stub
		return boardDao.currentSequence();
	}


	@Override
	public List<BoardlistCommand> boardSearch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.boardSearch(map);
	}

	
	//댓글 기능 관련
	@Override
	public List<ReplyVo> replySelect(Long boardSeq) {
		// TODO Auto-generated method stub
		return boardDao.replySelect(boardSeq);
	}


	@Override
	public void replyInsert(ReplyVo replyVo) {
		// TODO Auto-generated method stub
		ReplyVo newreply = new ReplyVo();
		//newreply.setReplySeq(replywriteCommand.getReplySeq());
		newreply.setBoardSeq(replyVo.getBoardSeq());
		newreply.setMemberSeq(replyVo.getMemberSeq());
		newreply.setReplyContent(replyVo.getReplyContent());
		
		boardDao.replyInsert(newreply);
	}


	@Override
	public void replyUpdate(ReplyVo replyVo) {
		// TODO Auto-generated method stub
		ReplyVo updatereply = new ReplyVo();
		//updatereply.setReplySeq(replyVo.getReplySeq());
		//updatereply.setBoardSeq(replyVo.getBoardSeq());
		//updatereply.setMemberSeq(replyVo.getMemberSeq());
		updatereply.setReplyContent(replyVo.getReplyContent());
		
		boardDao.replyUpdate(updatereply);
		
	}


	@Override
	public void replyDelete(Long replySeq) {
		// TODO Auto-generated method stub
		boardDao.replyDelete(replySeq);
		
	}


	@Override
	public int boardSearchCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.boardSearchCount(map);
	}

	

	
	
	
	

}
