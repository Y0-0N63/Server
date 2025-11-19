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
<style>
	table {
		border-collapse : collapse;
	}
	
	th, td {
		border : 1px solid black;
		padding : 5px;
	}
</style>
</head>
<body>
	<h1>책 목록 조회</h1>
	<hr>
	<h3>전체 책 수량 : ${fn:length(bookList)}</h3>
	<hr>
	
	<table style = "border : 1px solid black;">
		<tr>	
			<th>제목</th>
			<th>저자</th>
			<th>가격(원)</th>
		</tr>
		<c:forEach var = "i" begin = "0" end="${fn:length(bookList)-1}" step="1">
			<c:if test="${i > 0 && i % 3 == 0}">
				<tr>
					<td colspan = "3" style = "background-color : lightgray; height : 20px;"></td>
				</tr>
			</c:if>
			<tr>
				<td>${bookList[i].title}</td>
				<td>${bookList[i].writer}</td>
				<td>${bookList[i].price}</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>