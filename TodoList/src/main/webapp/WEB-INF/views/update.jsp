<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>

	<h1></h1>
	
	<h4>할 일 수정</h4>
	
	
	<form action="/todo/update" method="post" id="updateForm">
		<div>
			제목 : <input type="text" name="title" value="">
		</div>
		<div>
			<textarea name="detail" rows="3" cols="50" placeholder="상세 내용.."></textarea>
		</div>
		
		
		<input type="hidden" name="todoNo" value="">
		
		<button>수정 완료</button>
	</form>
	
	
	
</body>
</html>