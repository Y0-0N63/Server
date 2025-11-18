<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP 범위별 내장 객체</title>
</head>
<body>
	<h1>Servlet/JSP 범위별 내장 객체</h1>
	<pre>
Servlet/JSP에는 4종류 범위를 나타낸 내장 객체가 존재 > 각 종류마다 영향을 끼치는 범위가 달라짐
<h3>1. page : 현재 페이지</h3>
-> 현재 JSP에서만 사용 가능한 객체 (Servlet에서는 사용 불가)

<h3>2. request == HttpServletRequest</h3>
-> 요청받은 Servlet과 위임받은 페이지(JSP)에서 유지되는 객체

<h3>3. session (입회, 접속)</h3>
-> 서버에 접속한 클라이언트를 나타내거나, 관련 정보를 get/set할 수 있는 객체 (session 객체는 서버에서 관리)
-> *session은 브라우저마다 하나씩 생성됨*
-> 사이트 접속~브라우저 종료 | 세션 기간 만료
-> session이 유지되는 상태에서는 아무곳에서나 session에 세팅된 값을 가져다가 사용할 수 있다 (ex_로그인 정보)

<h3>4. application (ServletContext)</h3>
-> 하나의 웹 애플리케이션마다 1개만 생성되는 객체 (Server를 켰을 때 한 개 생성)
-> 서버 실행~서버 종료
-> application에 세팅된 값 어디서든 사용 가능
	</pre>
	
	<hr><hr>
	
	<h3>범위별 객체에 세팅된 값(속성) 얻어오기</h3>
	<pre>
- 범위별 객체에 세팅된 값을 얻어오는 EL
1) \${000Scope.key} -> ex) \${requestScopekey}
2) \${key} -> 좁은 범위 객체부터 탐색해, 일치하는 key가 존재하면 얻어옴
	</pre>
	
	<%
		// page scope에 값 세팅하기
		pageContext.setAttribute("pageValue", "page scope 객체에 세팅한 값");
		// pageValue = page scope 객체에 세팅한 값
	%>
	
	<p>page scope : ${pageScope.pageValue}</p>
	<p>request scope : ${requestScope.requestValue}</p>
	<p>session scope : ${sessionScope.sessionValue}</p>
	<p>application scope : ${applicationScope.applicationValue}</p>
	
	<a href = "/el/check">객체 범위 확인 페이지로 이동</a>
	
	<hr>
	
	<h1>범위별 객체 우선순위 확인</h1>
	<% pageContext.setAttribute("menu", "짬짜면(page)"); %>
	
	<h4>우선순위 menu 출력 : ${menu}</h4>
	
	<h3>원하는 scope의 menu로 세팅된 값 출력</h3>
	<p>${pageScope.menu}</p>
	<p>${requestScope.menu}</p>
	<p>${sessionScope.menu}</p>
	<p>${applicationScope.menu}</p>
</body>
</html>