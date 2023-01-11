package kr.board.controller;

import kr.board.entity.Board;
import kr.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {    // new BoardController();

    @Autowired
    private BoardService boardService;

    // HandlerMapping
    @RequestMapping("/boardList.do")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.getlists());
        return "boardList"; // /WEB-INF/views/boardList.jsp -> forward
    }

    @GetMapping("/boardForm.do")
    public String boardForm() {
        return "boardForm"; // /WEB-INF/views/boardForm.jsp -> forward
    }

    @PostMapping("/boardInsert.do")
    public String boardInsert(Board vo) { // title, content, writer => 파라메터수집(Board)
        boardService.boardInsert(vo);
        return "redirect:/boardList.do"; // redirect
    }

    @GetMapping("/boardContent.do")
    public String boardContent(int idx, Model model) { // ?idx=6

        Board content = boardService.boardContent(idx);
        model.addAttribute("vo", content);
        // 조회수 증가
        //mapper.boardCount(idx);
        //model.addAttribute("vo", vo); // ${vo.idx}...
        return "boardContent"; // boardContent.jsp
    }

    @GetMapping("/boardDelete.do")
    public String boardDelete(@RequestParam("idx") int idx) { // ?idx=6
        boardService.boardDelete(idx);
        return "redirect:/boardList.do";
    }

    @GetMapping("/boardUpdateForm.do/{idx}")
    public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {

        Board vo = boardService.boardContent(idx);
        model.addAttribute("vo", vo);
        return "boardUpdate"; // boardUpdate.jsp
    }

    @PostMapping("/boardUpdate.do")
    public String boardUpdate(Board vo) { // idx, title, content
        boardService.boardUpdate(vo);
        return "redirect:/boardList.do";
    }

}
