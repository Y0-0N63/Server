<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인 1</title>
</head>
<body>
	<h3>전달받은 파라미터 출력하기</h3>
	<pre>
- \${param.key} : key 일치하는 파라미터 얻어오기
- \${paramValues.key} : key 일치하는 파라미터 모두 얻어오기 > 배열 형태로 반환
	</pre>
	
	<ul>
		<%-- EL은 문자열 비교 == (비교 연산자) 사용 가능 --%>
		<li>${param.str == "abc"}</li>
		<%-- HTML에서 얻어온 데이터는 모두 String > 그러나 EL에서 연산되는 자료형이 다를 경우, 자동으로 자료 형변환 진행 > true 반환 --%>
		<li>${param.intNum == 100}</li>
		<li>${param.doubleNum == 3.14}</li>
	</ul>
	
	<hr>
	
	<h3>같은 key 값을 지닌 파라미터 얻어오기</h3>
	<ul>
		<%-- check가 여러 개 전달된 경우 > 첫 번째 파라미터 값만 출력 param.check : A--%>
		<li>param.check : ${param.check}</li>

		<%-- check가 여러 개 전달된 경우 > String[]로 반환 paramValues.check : [Ljava.lang.String;@1e6521ad --%>
		<li>paramValues.check : ${paramValues.check}</li>
		
		<li>paramValues.check[0] : ${paramValues.check[0]}</li>
		<li>paramValues.check[1] : ${paramValues.check[1]}</li>
		<li>paramValues.check[2] : ${paramValues.check[2]}</li>
	</ul>
</body>
</html>