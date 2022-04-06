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

import com.group.exam.board.command.BoardPageCommand;
import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.service.BoardService;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardVo;
import com.group.exam.member.command.LoginCommand;

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
	public String insertBoard(@ModelAttribute("boardData") BoardVo boardVo, HttpSession session) {

		return "board/writeForm";
	}

	@PostMapping(value = "/write")
	public String insertBoard(@Valid @ModelAttribute("boardData") BoardVo boardVo, BindingResult bindingResult,
			Model model, Criteria cri, HttpSession session) {

		// not null 체크
		if (bindingResult.hasErrors()) {

			return "board/writeForm";
		}
		
		//세션 값 loginMember에 저장
		LoginCommand loginMember = (LoginCommand) session.getAttribute("member");
		
		
		//세션에서 멤버의 mSeq 를 boardVo에 셋팅 
		boardVo.setmSeq(loginMember.getmSeq());
	
		boardService.insertBoard(boardVo);

//		List<BoardlistCommand> list = boardService.boardList(cri);
//		model.addAttribute("list", list);

		return "redirect:/board/list";
	}

	
	
	// 리스트 전체
	
	@GetMapping(value = "/list")
	public String boardListAll(Criteria cri, Model model) {
		 int num = 0;
		if(num == 0) {
			num = 1; 
		}
		
		
		int total = boardService.listCount();
		/*
		 * 1 1,10 2 11, 20
		 */
	
		cri.setPageNum(num);

		List<BoardlistCommand> list = boardService.boardList(cri);
		model.addAttribute("list", list);

		model.addAttribute("num", num);
		BoardPageCommand pageCommand = new BoardPageCommand(cri, total);
		model.addAttribute("pageMaker", pageCommand);
		return "board/list";
	}
	
	@GetMapping(value = "/list/{num}")
	public String boardListAll(@PathVariable int num, Criteria cri, Model model) {

		if(num == 0) {
			num = 1; 
		}
		
		
		int total = boardService.listCount();
		System.out.println("토탈  "+total);
		cri.setPageNum(num);
	
		List<BoardlistCommand> list = boardService.boardList(cri);
		model.addAttribute("list", list);

		model.addAttribute("num", num);
		BoardPageCommand pageCommand = new BoardPageCommand(cri, total);
		model.addAttribute("pageMaker", pageCommand);

		return "board/list";
	}

	// 해당날짜 list
	@GetMapping(value = "/listAday/{bRegday}")
	public String boardListAday(@PathVariable String bRegday, Model model) {

		List<BoardlistCommand> list = boardService.boardListAday(bRegday);

		model.addAttribute("list", list);
		return "board/list";
	}

	// 해당list 내 글 모아보기
	@GetMapping(value = "/listMy/{mSeq}")
	public String boardListMy(@PathVariable("mSeq") int mSeq, Model model) {

		List<BoardlistCommand> list = boardService.boardListMy(mSeq);
		model.addAttribute("list", list);
		return "board/list";
	}

	// 게시글 디테일
	@GetMapping(value = "/detail/{bSeq}")
	public String boardListDetail(@PathVariable int bSeq, Model model, HttpSession session) {
		
		
		boardService.boardCountup(bSeq);

		List<BoardlistCommand> list = boardService.boardListDetail(bSeq);
		
		//세션 값 loginMember에 저장
		LoginCommand loginMember = (LoginCommand) session.getAttribute("member");
		
		if (loginMember != null) {
			//세션에서 멤버의 mSeq 를 boardVo에 셋팅 
			int mSeq = loginMember.getmSeq();
			//세션에 저장된 mSeq와 게시글의 mSeq를 비교하여 내 글이면 수정 삭제 버튼이 뜨게
			if (mSeq == list.get(0).getmSeq()) {
				boolean my = true;
				model.addAttribute("my", my);
			}
		}
		
		model.addAttribute("list", list);
		

		return "board/listDetail";
	}

	// 게시글 수정
	@GetMapping(value = "/edit")
	public String boardEdit(@ModelAttribute("boardEditData") BoardVo boardVo, HttpSession session) {
		return "board/editForm";
	}

	// 게시글 수정
	@PostMapping(value = "/edit")
	public String boardEdit(@Valid @ModelAttribute("boardEditData") BoardVo boardVo, BindingResult bindingResult,
			Model model, HttpSession session) {

		return "redirect:/board/list";
	}

	// 게시글 삭제
	@GetMapping(value = "/delete")
	public String boardDelect(@RequestParam int bSeq, Model model, HttpSession session, Criteria cri) {
		
		
		//세션 값 loginMember에 저장
		LoginCommand loginMember = (LoginCommand) session.getAttribute("member");
		
		if (loginMember != null) {
			//세션에서 멤버의 mSeq 를 boardVo에 셋팅 
			int mSeq = loginMember.getmSeq();
			boardService.deleteBoardOne(bSeq, mSeq);
			System.out.println("삭제 성공");
		}
		
		System.out.println("삭제 실패");
		

		return "redirect:/board/list";
	}

}
