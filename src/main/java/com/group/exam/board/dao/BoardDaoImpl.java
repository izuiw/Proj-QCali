package com.group.exam.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.exam.board.command.ListAdayCommand;
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
	public void deleteBoardOne(int bSeq) {
		// TODO Auto-generated method stub
	
		sqlSessionTemplate.delete("deleteBoardOne", bSeq);
		
	}

	@Override
	public List<ListAdayCommand> boardListAday(String bRegday) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardlistAday", bRegday);
	}

	@Override
	public List<BoardVo> boardListMy(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo boardListDetail(int bSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCount(int bSeq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pwdCheck(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
