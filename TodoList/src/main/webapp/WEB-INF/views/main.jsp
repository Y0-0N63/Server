<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Todo List</title>
	
</head>
<body>
	

	<h1>Todo List</h1>
	
	<h3>전체 Todo 개수 : 개 / 
		완료된 Todo 개수 : 개</h3>

	<hr>
	
	<h4>할 일 추가</h4>
	<form action="/todo/add" method="post" id="addForm">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			<textarea rows="3" cols="50" name="detail"
			placeholder="상세 내용 입력..."></textarea>
		</div>
	
		<button>추가하기</button>
	</form>
	
	
	<hr>
	
	<%-- 할 일 목록 출력 --%>
	<table id="todoList" border="1">
		<thead>
			<tr>
				<th>출력 번호</th><%-- 페이지에서 보이는 용도의 단순 출력 번호 --%>
				<th>todo 번호</th><%-- 실제 DB에 저장된 todoNo 고유 번호 --%>
				<th>할 일 제목</th>
				<th>완료 여부</th>
				<th>등록 날짜</th>
			</tr>
		</thead>
		
		<tbody>
			
		
		</tbody>
	</table>
	
	
	
</body>
</html>