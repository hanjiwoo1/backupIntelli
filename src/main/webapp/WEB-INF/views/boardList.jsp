<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC01</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Spring MVC01</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
       <table class="table table-bordered table-hover">
          <tr>
            <td name="idx">번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td id="viewCnt">조회수</td>
          </tr>
          <c:forEach var="vo" items="${list}">
           <tr>
            <td>${vo.idx}</td>
            <td><a href="boardContent.do?idx=${vo.idx}">${vo.title}</a></td>
            <td>${vo.writer}</td>
            <td>${fn:split(vo.indate," ")[0]}</td>
            <td>${vo.count}</td>
           </tr>
          </c:forEach>
       </table>    
       <a href="boardForm.do" class="btn btn-primary btn-sm">글쓰기</a>
        <div class="pageInfo_wrap" >
            <div class="pageInfo_area">
                <!-- 각 번호 페이지 버튼 -->
                <c:forEach var="vo" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <li class="pageInfo_btn"><a href="${vo}">${vo}</a></li>
                </c:forEach>
            </div>
        </div>

<%--        <form id="moveForm" method="get">--%>
<%--            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">--%>
<%--            <input type="hidden" name="amount" value="${pageMaker.cri.amount }">--%>
<%--        </form>--%>
        <form id="searchForm" action="/boardList.do" method="get">
            <input type="hidden" name="sortByidx" value="${sortBycount}">
            <input type="hidden" name="sortBycount" value="${param.sortBycount}">
            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
            <input type="hidden" name="amount" value="${pageMaker.cri.amount }">
        </form>
    </div>
    <div class="panel-footer">한지우</div>
  </div>
</div>
<script>

    $(function () {
        console.log("start","${pageMaker.startPage}");
        console.log("end","${pageMaker.endPage}");

        $(".pageInfo_wrap a").on("click", function(e){
            e.preventDefault();
            $("#searchForm").find("input[name='pageNum']").val($(this).attr("href"));
            $("#searchForm").attr("action", "/boardList.do");
            $("#searchForm").submit();
        });

        $("#viewCnt").on("click", function(e){
            e.preventDefault();
           let val = $("input[name='sortBycount']").val();
           if (val=="" || val == "0") {
               $("input[name='sortBycount']").val("1");
           }else if (val=="1"){
               $("input[name='sortBycount']").val("0");
           }

            $("#searchForm").attr("action", "/boardList.do");

            $("#searchForm").submit();
        })

        // $("input[name='idx']").on("click", function(){
        //     let event;
        //     if(this.id == "viewCnt"){
        //         event = "cnt";
        //     }else if (this.id == "idx"){
        //         event = "idx";
        //     }
        //     $("#searchEvent").val(event);
        //     $("#searchForm").submit();
        // })

    });
</script>

</body>
</html>