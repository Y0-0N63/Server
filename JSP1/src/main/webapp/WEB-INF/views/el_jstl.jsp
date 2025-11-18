<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/function" %>  --%>
<%-- prefix : 접두사(앞에 붙는 단어), prefix="c" --> <c:if></c:if> : core에서 가져온 if문을 의미
	prefix="fn" --> <fn:..></fn:..> : function --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL 사용법</title>
</head>
<body>
	<h1>a 태그의 Get 요청으로 응답받은 페이지</h1>
	
	<h2>EL(Expression Language) : 표현 언어</h2>
	<pre>
	- JSP에서 표현식을 간단하고 효율적으로 작성할 수 있도록 고안된 언어 (JSP 내부에 기본 내장되어 있음)
	- 기본 작성법 : \${key}
	*백슬래시(\) : 화면 출력용 기호
	</pre>
	
	<h3>전달 받은 파라미터를 출력하는 방법</h3>
	<p>주소 뒤 쿼리스트링(?name=홍길동&age=20)을 직접 작성해 테스트</p>
	
	<h4>1. JSP 표현식</h4>
	<div>
		name : <%= request.getParameter("name") %>
		<br>
		age : <%= request.getParameter("age") %>
	</div>
	<p style = "color : red;">
		JSP 표현식에서 없는 파라미터(데이터)를 얻어오면 null로 출력됨
	</p>
	
	<h4>2. EL</h4>
	<div>
		<%-- EL에서 파라미터의 값을 얻어오는 방법 : {$param.key값}
			- null을 빈칸으로 처리, get이라는 단어를 사용하지 않음 --%>
		name : ${param.name}
		<br>
		age : ${param.age}
	</div>
	
	<hr><hr>
	
	<h1>JSTL(Jsp Standard Tag Library)</h1>
	<pre>
		JSP에서 자주 사용하는 Java 코드(if, for, 변수 선언...)를 스크립틀릿이 아닌 HTML 태그 모양으로 작성할 수 있도록 태그를 제공하는 라이브러리

		[라이브러리 추가 방법]
		1. 필요한 라이브러리(.jar) 파일 다운받기
		2. 프로젝트의 webapp/WEB-INF/lib 폴더에 다운로드 받은 라이브러리 추가
		3. JSTL을 사용할 JSP 파일의 최상단에 지시자 태그(%@)를 통해 taglib 추가 작성
	</pre>
	
	<h3>JSTL c:if 태그 사용해보기</h3>
	<%-- ?age=20 (파라미터로 얻어온 age의 value)--%>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
		if(age > 20) {
	%>
			<h3>성인입니다 (JSP 스크립틀릿으로 출력하기)</h3>
	<% } %>
	
	<c:if test = "${param.age > 20}">
		<h3>성인입니다(JSTL 사용)</h3>
	</c:if>
	
	<c:if test="${param.age <= 20}">
		<h3>성인이 아닙니다(JSTL 사용)</h3>
	</c:if>
</body>
</html>