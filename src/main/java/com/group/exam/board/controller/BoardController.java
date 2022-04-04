package com.group.exam.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.group.exam.board.command.ListCommand;
import com.group.exam.board.dao.BoardDao;
import com.group.exam.board.service.BoardService;
import com.group.exam.board.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	public BoardController() {
	}

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping(value = "/write")
	public String insertBoard(@ModelAttribute("boardData") BoardVo boardVo) {

		return "board/writeForm";
	}

	@PostMapping(value = "/write")
	public String insertBoard(@Valid @ModelAttribute("boardData") BoardVo boardVo, BindingResult bindingResult, Model model) {

		// not null 체크
		if (bindingResult.hasErrors()) {

			return "board/writeForm";
		}
		System.out.println(boardVo);

		boardService.insertBoard(boardVo);

		List<ListCommand> list = boardService.boardList();
		model.addAttribute("list", list);
	
		return "board/list";
	}

	// 리스트 전체
	@GetMapping(value = "/listAday")
	public String boardListAll(Model model) {

		List<ListCommand> list = boardService.boardList();
		model.addAttribute("list", list);

		return "board/list";
	}

	// 해당날짜 list
	@GetMapping(value = "/listAday/{bRegday}")
	public String boardListAday(@PathVariable String bRegday, Model model) {

		List<ListCommand> list = boardService.boardListAday(bRegday);

		model.addAttribute("list", list);
		return "board/list";
	}
	
	// 해당list 내 글 모아보기
	@GetMapping(value = "/listMy/{mSeq}")
	public String boardListMy(@PathVariable int mSeq, Model model) {
		
		List<ListCommand> list = boardService.boardListMy(mSeq);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	//게시글 디테일
	@GetMapping(value = "/detail/{bSeq}")
	public String boardListDetail(@PathVariable int bSeq, Model model) {
		
		
		List<ListCommand> list = boardService.boardListDetail(bSeq);
		model.addAttribute("list", list);
			
		return "board/listDetail";
	}
	
	// 게시글 수정
	@GetMapping(value = "/edit")
	public String boardEdit(@ModelAttribute("boardEditData") BoardVo boardVo) {
		
		return "board/editForm";
	}
	// 게시글 수정
	@PostMapping(value = "/edit")
	public String boardEdit(@Valid @ModelAttribute("boardEditData") BoardVo boardVo, BindingResult bindingResult, Model model) {
		
		return "board/list";
	}
	
	// 게시글 삭제 
	@GetMapping(value = "/delete")
	public String boardDelect(@RequestParam int bSeq, Model model, HttpSession session) {
		int mSeq = 5; //임의 값
		boardService.deleteBoardOne(bSeq, mSeq);
		
		List<ListCommand> list = boardService.boardList();
		model.addAttribute("list", list);
		return "board/list";
	}
	

}
