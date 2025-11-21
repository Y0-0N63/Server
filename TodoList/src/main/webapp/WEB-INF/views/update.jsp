<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${todo.todoTitle} 수정 페이지</title>
</head>
<body>
	<h4>할 일 수정</h4>
	
	
	<form action="/todo/update" method="post" id="updateForm">
		<div>
			제목 : <input type="text" name="title" value="${todo.todoTitle}">
		</div>
		<div>
			<textarea name="detail" rows="3" cols="50" placeholder="상세 내용..">${todo.todoDetail}</textarea>
		</div>
		
		<%-- todoNo도 수정 요청 시 파라미터로 제출해야 함
		> 어떤 todoNo를 가진 행을 수정하고자 하는 것인지 SQL의 WHERE(조건식)에서 이용해야 하기 때문
		> 화면에 노출할 필요가 없는 데이터 > hidden 처리
		
		param : up에서(/todo/update?todoNo = 1)에 있는 todoNo 값
		EL 표현식에서 ${param.key} -> ${param.todoNo} -> 값 반환(여기서는 1 등...)  --%>
		<%-- <input type="hidden" name="todoNo" value="${todo.todoNo }">; --%>
		<input type="hidden" name="todoNo" value="${param.todoNo }">
		
		<button>수정 완료</button>
	</form>
	
		
	<%-- session 범위에 message가 있는 경우에만 script 태그 생성하기 --%>
	<c:if test = "${not empty sessionScope.message}">
	 <script>
		// JSP의 해석 순위
		// 1. Java (EL/JSTL)
		// 2. Front (HTML/CSS/JS)
		alert("${message}");
	</script>
	
	<%-- message를 한 번만 사용하고 제거 --%>
	<c:remove var="message" scope = "session"/>
	</c:if>
	
</body>
</html>