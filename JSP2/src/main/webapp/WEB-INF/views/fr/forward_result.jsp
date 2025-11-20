<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request scope 객체를 이용해서 전달받은 값</h3>
	<p>str : ${str}</p>
	
	<h3>파라미터로 전달된 데이터 출력하기</h3>
	<p>첫 번째 : ${param.forwardInput1}</p>
	<p>두 번째 : ${param.forwardInput2}</p>
</body>
</html>