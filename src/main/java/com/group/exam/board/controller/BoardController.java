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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.exam.board.command.BoardPageCommand;
import com.group.exam.board.command.BoardlistCommand;
import com.group.exam.board.command.BoardupdateCommand;
import com.group.exam.board.command.BoardLikeCommand;
import com.group.exam.board.service.BoardService;
import com.group.exam.board.utils.Criteria;
import com.group.exam.board.vo.BoardLikeVo;
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
			 Criteria cri, HttpSession session, Model model) {
		// not null 체크
		if (bindingResult.hasErrors()) {

			return "board/writeForm";
		}
		LoginCommand loginMember = (LoginCommand) session.getAttribute("memberLogin");
		

		
		boolean memberAuth = boardService.memberAuth(loginMember.getmSeq()).equals("F");
		if(memberAuth == true) {
			return "redirect: /exam/"; //이메일 인증 x -> 예외 페이지
			
		}

		// 세션에서 멤버의 mSeq 를 boardVo에 셋팅
		boardVo.setmSeq(loginMember.getmSeq());

		boardService.insertBoard(boardVo);


		return "redirect:/board/list";
	}

	// 리스트 전체
	@GetMapping(value = "/list")
	public String boardListAll(@RequestParam (value="currentPage",defaultValue="0") int currentPage, Criteria cri, Model model, HttpSession session) {
		
		/*
		 * @RequestParam null 허용 방법
		 *  - (required = false) == true 가 기본 설정임
		 *  - @Nullable 어노테이션 추가
		 *  
		 *  - int 형의 경우 (defaultValue="0")
		 * 
		 */


		if (currentPage == 0) {
			currentPage = 1;
		}

		int total = boardService.listCount();
		/*
		 * 1 1,10 2 11, 20
		 */

		cri.setPageNum(currentPage);
	

		List<BoardlistCommand> list = boardService.boardList(cri);
		model.addAttribute("list", list);
		

		model.addAttribute("currentPage", currentPage);
		BoardPageCommand pageCommand = new BoardPageCommand(cri, total);
		model.addAttribute("pageMaker", pageCommand);
		return "board/list";
	}



	// 해당list 내 글 모아보기
	@GetMapping(value = "/mylist")
	public String boardListMy(@RequestParam("mSeq") int mSeq, @RequestParam (value="currentPage",defaultValue="0") int currentPage,
			Model model,Criteria cri,HttpSession session) {
		

		
		if (currentPage == 0) {
			currentPage = 1;
		}

		int total = boardService.mylistCount(mSeq);
	

		cri.setPageNum(currentPage);
		
		
		List<BoardlistCommand> list = boardService.boardMyList(cri,mSeq);
		model.addAttribute("list", list);

		
		model.addAttribute("currentPage", currentPage);
		BoardPageCommand pageCommand = new BoardPageCommand(cri, total);
		model.addAttribute("pageMaker", pageCommand);
		
		return "board/mylist";
	}

	// 게시글 디테일
	@GetMapping(value = "/detail")
	public String boardListDetail(@RequestParam int bSeq, Model model, HttpSession session) {
		

		boardService.boardCountup(bSeq);

		List<BoardlistCommand> list = boardService.boardListDetail(bSeq);

		// 세션 값 loginMember에 저장

		LoginCommand loginMember = (LoginCommand) session.getAttribute("memberLogin");

		if (loginMember != null) {
			// 세션에서 멤버의 mSeq 를 boardVo에 셋팅
			int mSeq = loginMember.getmSeq();
			// 세션에 저장된 mSeq와 게시글의 mSeq를 비교하여 내 글이면 수정 삭제 버튼이 뜨게
			if (mSeq == list.get(0).getmSeq()) {
				boolean my = true;
				model.addAttribute("my", my);
			}
		}

		model.addAttribute("list", list);
		model.addAttribute("bSeq", bSeq);

		BoardLikeVo likeVo = new BoardLikeVo();
		
		likeVo.setbSeq(bSeq);
		likeVo.setmSeq(loginMember.getmSeq());
		
		int boardlike = boardService.getBoardLike(likeVo);


		model.addAttribute("heart", boardlike);
		
		return "board/listDetail";
	}
	

	@PostMapping(value = "/heart", produces = "application/json")
	@ResponseBody
	public int boardLike ( @RequestBody BoardLikeCommand command ,HttpSession session) {
		
		
		LoginCommand loginMember = (LoginCommand) session.getAttribute("memberLogin");
		
		BoardLikeVo likeVo = new BoardLikeVo();
		
		likeVo.setbSeq(command.getbSeq());
		likeVo.setmSeq(loginMember.getmSeq());
		
		
		if ( command.getHeart() >= 1) {
			boardService.deleteBoardLike(likeVo);
			command.setHeart(0);
		} else {
			
			boardService.insertBoardLike(likeVo);
			command.setHeart(1);
		}
		
		//String result = Integer.toString(heart);
		
		return command.getHeart() ;
		
	}
	
	
	// 게시글 수정
	@GetMapping(value = "/edit")
	public String boardEdit(@ModelAttribute("boardEditData") BoardVo boardVo,   HttpSession session, Model model) {
		
		return "board/editForm";
	}

	// 게시글 수정
	@PostMapping(value = "/edit")
	public String boardEdit(@Valid @ModelAttribute("boardEditData") BoardupdateCommand updateCommand, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {

			return "board/editForm";
		}
	
		
		// 세션 값 loginMember에 저장
		LoginCommand loginMember = (LoginCommand) session.getAttribute("memberLogin");

		if (loginMember != null) {
			// 세션에서 멤버의 mSeq 를 boardVo에 셋팅
			int mSeq = loginMember.getmSeq();
			int bSeq = updateCommand.getbSeq();
			
			List<BoardlistCommand> list = boardService.boardListDetail(bSeq);
			
			model.addAttribute("list", list);
			boardService.updateBoard(updateCommand.getbTitle(), updateCommand.getbContent(), bSeq);
			System.out.println(" 수정 성공");
		} else {
			System.out.println("수정 실패");
			// return errors - 삭제 실패
		}

		return "redirect:/board/list";
	}

	// 게시글 삭제
	@GetMapping(value = "/delete")
	public String boardDelect(@RequestParam int bSeq, Model model, HttpSession session, Criteria cri) {

		// 세션 값 loginMember에 저장
		LoginCommand loginMember = (LoginCommand) session.getAttribute("memberLogin");

		if (loginMember != null) {
			// 세션에서 멤버의 mSeq 를 boardVo에 셋팅
			int mSeq = loginMember.getmSeq();
			boardService.deleteBoardOne(bSeq, mSeq);
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
			// return errors - 삭제 실패
		}

		return "redirect:/board/list";
	}

}
