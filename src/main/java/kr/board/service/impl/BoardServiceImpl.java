package kr.board.service.impl;

import kr.board.entity.SearchBoardVO;
import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
import kr.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> getlists(){

        List<Board> list = boardMapper.getLists();

        return list;
    }

    @Override
    public List<Board> getListPaging(SearchBoardVO vo) {
        return boardMapper.getListPaging(vo);
    }

    @Override
    public void boardInsert(Board vo) {

        boardMapper.boardInsert(vo);
    }

    @Override
    public Board boardContent(int idx) {

        Board content = boardMapper.boardContent(idx);

        boardMapper.boardCount(idx);

        return  content;
    }

    @Override
    public void boardDelete(int idx) {

        boardMapper.boardDelete(idx);
    }

    @Override
    public void boardUpdate(Board vo) {

        boardMapper.boardUpdate(vo);
    }

    @Override
    public int getTotal() {
        return boardMapper.getTotal();
    }

}
