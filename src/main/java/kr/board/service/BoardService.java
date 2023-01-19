package kr.board.service;

import kr.board.entity.Board;

import java.util.List;

public interface BoardService {

     List<Board> getlists();

     void boardInsert(Board vo);

     Board boardContent(int idx);

     void boardDelete(int idx);

     void boardUpdate(Board vo);

}
