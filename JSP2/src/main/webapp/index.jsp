<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>index.html과 index.jsp의 차이</h3>
	<pre>
HTML : html, css, js 코드 작성 가능 + 정적 페이지 (미리 만들어둔 형태 그대로)
jsp : html, css, js, java, el, jstl 작성 가능 + 동적 페이지 (요청에 따라 응답 화면이 변함)
	</pre>
	
	<hr>
	
	<%-- form 태그 method 속성 생략 시 기본값 GET --%>
	<form action="el/test1">
		문자열 입력 : <input type = "text" name = "str"><br>
		정수 입력 : <input type = "number" name = "intNum"><br>
		실수 입력 : <input type = "text" name = "doubleNum"><br>
		
		<div>
			A <input type="checkbox" name = "check" value = "A">
			B <input type="checkbox" name = "check" value = "B">
			C <input type="checkbox" name = "check" value = "C">
		</div>
		
		<button>제출하기</button>
	</form>
	
	<hr>
	
	<h1>
		<%-- a 태그 클릭시 /el/scope 주소로 GET 방식 요청 --%>
		<a href = "el/scope">Servlet/JSP 범위(scope)별 내장 객체 + EL 사용법</a>
	</h1>
	
	<hr>
	
	<h1>
		<a href = "/jstl/test">JSTL 다뤄보기</a>
	</h1>
	
	<hr>
	
	<h1>
		<a href = "/book/list">책 목록 조회하기</a>
	</h1>
</body>
</html>