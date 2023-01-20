package kr.board.entity;

import kr.board.entity.Criteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchBoardVO {

    private Criteria cri;

    private String sortByidx;

    private String sortBycount;

    @Override
    public String toString() {
        return "SearchBoardVO{" +
                "cri=" + cri +
                ", sortByidx=" + sortByidx +
                ", sortBycount='" + sortBycount + '\'' +
                '}';
    }
}
