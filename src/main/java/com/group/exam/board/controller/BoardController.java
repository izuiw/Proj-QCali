package com.group.exam.board.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.exam.board.command.ListAdayCommand;
import com.group.exam.board.service.BoardService;
import com.group.exam.board.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardController() {}
	

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping(value="/write")
	public String insertBoard (@ModelAttribute("boardData") BoardVo boardVo) {

		return "board/writeForm";
	}
	
	
	@PostMapping(value="/write")
	public String insertBoard (@Valid @ModelAttribute("boardData") BoardVo boardVo, BindingResult bindingResult) {
		
		//not null 체크
		if(bindingResult.hasErrors()) {
		
			
			return "board/writeForm";
		}
		System.out.println(boardVo);
		
		boardService.insertBoard(boardVo);
		System.out.println("컨트롤러 - 입력 성공");
		
		return "board/list";
	}
	
	
	//list
	@GetMapping(value = "/listAday")
	public String boardListAday( Model model) {
		String bRegday = "2022-03-31";  
		List<ListAdayCommand> list = boardService.boardListAday(bRegday);
		System.out.println("리스트 : " + list);
		int listCount = list.size();
		
		System.out.println("카운트" + listCount);
		model.addAttribute("listCount", listCount);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	
	

}
