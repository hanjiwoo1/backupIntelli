package kr.board.mapper;

import java.util.List;

import kr.board.entity.SearchBoardVO;
import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Board;

@Mapper //- Mybatis API
public interface BoardMapper {	 
      List<Board> getLists();

      List<Board> getListPaging(SearchBoardVO vo);
      void boardInsert(Board vo);
      Board boardContent(int idx);

      void boardDelete(int idx);
     
      void boardUpdate(Board vo);
     
    // @Update("update myboard set count=count+1 where idx=#{idx}")
      int boardCount(int idx);

      int getTotal();
}
