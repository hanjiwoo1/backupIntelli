package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import kr.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController{	// new BoardController();
	// /boardList.do
	//Autowired
	//private BoardMapper mapper;

	@Autowired
	private BoardService boardService;
	// HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {

		//List<Board> list=mapper.getLists();
		model.addAttribute("list", boardService.getlists());
		return "boardList"; // /WEB-INF/views/boardList.jsp -> forward
	}
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm"; // /WEB-INF/views/boardForm.jsp -> forward
	}

	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) { // title, content, writer => 파라메터수집(Board)
		//mapper.boardInsert(vo); // 등록
		boardService.boardInsert(vo);
		return "redirect:/boardList.do"; // redirect
	}

	@GetMapping("/boardContent.do")
	public String boardContent(int idx, Model model) { // ?idx=6

		Board content = boardService.boardContent(idx);
		model.addAttribute("vo", content);
		//Board vo=mapper.boardContent(idx);
		// 조회수 증가
		//mapper.boardCount(idx);
		//model.addAttribute("vo", vo); // ${vo.idx}...
		return "boardContent"; // boardContent.jsp
	}

	@GetMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) { // ?idx=6

		boardService.boardDelete(idx);
		//mapper.boardDelete(idx); //삭제
		return "redirect:/boardList.do";
	}

	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {

		Board vo=boardService.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdate"; // boardUpdate.jsp
	}

	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) { // idx, title, content

		boardService.boardUpdate(vo);


		return "redirect:/boardList.do";
	}

}
