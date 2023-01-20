package kr.board.controller;

import kr.board.entity.Board;
import kr.board.entity.Criteria;
import kr.board.entity.PageMakerDTO;
import kr.board.entity.SearchBoardVO;
import kr.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class BoardController {    // new BoardController();

    @Autowired
    private BoardService boardService;

    // HandlerMapping
    /*@RequestMapping("/boardList.do")
    public String boardList(Model model, Criteria cri) {
        List<Board> list = boardService.getlists();
        model.addAttribute("list", list);
        return "boardList"; // /WEB-INF/views/boardList.jsp -> forward
    }*/

    @RequestMapping("/boardList.do")
    public void boardListGET(HttpServletRequest request, Model model) {
        log.info("sortByidx :::::::::::::"+request.getParameter("sortByidx"));
        log.info("sortBycount :::::::::::::"+request.getParameter("sortBycount"));
        try {
            log.info("request {}", request);
            String sortBycount = "";
            String sortByidx = "";
            boolean flag = false;
            int pageNum = 0;
            if (request.getParameter("pageNum") != null) flag = true;
            Criteria cri = null;
            if (flag) {
                if(request.getParameter("pageNum") == null || request.getParameter("pageNum") == "" ){
                    pageNum = 1;
                } else{
                    pageNum = Integer.parseInt(request.getParameter("pageNum"));
                }
                sortBycount = request.getParameter("sortBycount");
                sortByidx = request.getParameter("sortByidx");
                log.info("REALSORTBYIDX:::::::::::" + sortByidx);
                cri = new Criteria(pageNum, 10);

            } else {
                cri = new Criteria();
            }
//            log.info("cri:::::::::" + cri.toString());

            SearchBoardVO vo = new SearchBoardVO();
            vo.setCri(cri);
            vo.setSortBycount(sortBycount);
            vo.setSortByidx(sortByidx);
            log.info("vo:::::::::::::::::" + vo.toString());


            model.addAttribute("list", boardService.getListPaging(vo));

            int total = boardService.getTotal();

            PageMakerDTO pageMake = new PageMakerDTO(cri, total);

            log.info(pageMake.toString());

            model.addAttribute("pageMaker", pageMake);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

        Board vo = boardService.boardContent(idx);
        model.addAttribute("vo", vo);


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
