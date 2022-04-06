package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;
@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public BoardDaoImpl (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public void insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insertBoard", boardVo);
		
	}

	@Override
	public void updateBoard(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// 게시글 제목과 내용 수정 
		sqlSessionTemplate.update("updateBoard", map);
		
	}

	@Override
	public void deleteBoardOne(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
	
		sqlSessionTemplate.delete("deleteBoardOne", map);
		
	}

	@Override
	public List<BoardlistCommand> boardListAday(String bRegday) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardlistAday", bRegday);
	}

	@Override
	public List<BoardlistCommand> boardListMy(int mSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardlistMy", mSeq);
	}

	@Override
	public List<BoardlistCommand> boardListDetail(int bSeq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardlistDetail", bSeq);
	}

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("boardlistCount");
	}

	@Override
	public String pwdCheck(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BoardlistCommand> boardList(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardlist", cri);
	}


	@Override
	public void boardCountup(int bSeq) {
		// TODO Auto-generated method stub
		
		sqlSessionTemplate.update("boardCountup", bSeq);
		
	}

}
