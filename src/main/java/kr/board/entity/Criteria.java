package kr.board.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {


    /* 현재 페이지 */
    private int pageNum;

    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;

    /* 스킵 할 게시물 수( (pageNum-1) * amount ) */
    private int skip = 0;


    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10
    파라미터 없이 Criteria 클래스를 호출하였을 때는 기본적으로
    pageNum은 1, amount는 10을 가지도록 생성자를 작성하였습니다

    파라미터와 함께 Criterial를 호출하게 되면 파라미터의 값이
    각각 pageNum과 amount 값에 저장되도록 생성자를 작성하였습니다.
    */


    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
    public Criteria() {
        this(1,10);
        this.skip = 0;
    }

    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1)*amount;
    }


    @Override
    public String toString() {
        return "Criteria{" +
                "pageNum=" + pageNum +
                ", amount=" + amount +
                ", skip=" + skip +
                '}';
    }
}
