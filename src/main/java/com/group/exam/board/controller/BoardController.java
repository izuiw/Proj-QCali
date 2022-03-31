package com.group.exam.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.exam.board.service.BoardService;
import com.group.exam.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String insertBoard (@ModelAttribute("boardData") BoardVo boardVo) {
		return "boardwriteForm";
	}
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard (@Valid @ModelAttribute("boardData") BoardVo boardVo, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "boardwriteForm";
		}
		return "list";
	}
	
	
	

}
