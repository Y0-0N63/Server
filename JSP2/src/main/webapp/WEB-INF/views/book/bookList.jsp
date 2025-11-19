<%-- c : 자주 사용하는 Java 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fn : 컬렉션/문자열 관련 기능 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>
<%-- JSP에서 css 파일 연결하는 방법

<link rel = "stylesheet" href = "경로">

*CSS/JS 파일은 브라우저에서 직접 요청하는 정적 파일
> 이러한 정적 콘텐츠는 브라우저에서 직접 접근이 가능해야 하므로 webapp 폴더의 하위에 존재해야 함
  > 경로는 webapp 폴더를 기준으로 작성 (ex_/resources/css/book.css)
+ WEB-INF 폴더는 보안이 적용되어 Servlet에만 접근 가능하기 때문에 WEB-INF 폴더 내부에 존재할 시 인식 불가!
--%>
<link rel = "stylesheet" href = "/resources/css/book.css">
</head>
<body>
	<h1>책 목록 조회</h1>
	<hr>
	<h3>전체 책 수량 : ${fn:length(bookList)}</h3>
	<hr>
	
	<table style = "border : 1px solid black;">
		<tr>	
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격(원)</th>
		</tr>
		
		<%-- 방법1
		<c:forEach var = "book" items = ${bookList} varStatus = "vs">
			<tr>
				<th>${vs.count}</th>
				<td>${book.title}</td>
				<td>${book.writer}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
		 --%>
		
		<%-- 방법2 --%>
		<c:forEach var = "i" begin = "0" end="${fn:length(bookList)-1}" step="1">
			<%-- 조건 : 3배수 반복 시 > 회색 블록 삽입
			방법 1
			<c:if test= "${vs.count % 3 == 0"> --%>
			<c:if test="${i > 0 && i % 3 == 0}">
				<tr>
					<%-- 회색 블록이 제대로 보이지 않는다면 > 공백(&nbsp) 삽입 --%>
					<td colspan = "4" class = "blank">&nbsp;</td>
				</tr>
			</c:if>
			<tr>
				<td>${i + 1}</td>
				<td>${bookList[i].title}</td>
				<td>${bookList[i].writer}</td>
				<td>${bookList[i].price}</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>