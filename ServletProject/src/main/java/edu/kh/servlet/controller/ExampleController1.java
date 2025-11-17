package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
/* jakarta.servlet.http.HttpServlet
	 - http 프로토콜 서비스를 지원하는 추상 클래스 > 상속받아 나만의 서블릿 클래스 구현 
	 [Servlet을 등록하는 두 가지 방법]
	 1. web.xml에 직접 작성하기
	 2. @WebServlet() 어노테이션 이용하기 */
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	클라이언트로부터 "/example1"이라는 요청을 받아서 처리한 후 응답을 해줄 서블릿 클래스 ExampleController1을 만들기
//	Controller : 요청(Request)에 따라 어떤 Service를 호출할지 "제어"하고, 어떻게 응답(Response)할지 "제어"하는 역할

// doGet() 메서드 : GET 방식 요청을 처리하는 메서드 > HttpServlet을 상속받으면 사용할 수 있는 메서드로, 오버라이딩하여 사용
public class ExampleController1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest : 클라이언트 요청 시 생성되는 객체
		// - 요청 시 전달된 데이터, 요청한 클라이언트 정보, 유연한 요청 처리를 하기 위한 객체 제공
		
		// HttpServletResponse : 클라이언트 요청 시 생성되는 객체
		// - 서버가 클라이언트에게 응답하기 위한 방법을 제공
		// - 서버 -> 클라이언트 쪽으로 만들어진 페이지를 제공하기 위해 출력용 스트림 제공(PrintWriter)
		System.out.println("--- 이름과 나이를 입력받아 처리하는 서블릿 코드 ---");
		
		// 요청 시 입력된 이름, 나이 전달받아오기
		// Parameter : 매개변수, 다른 곳의 값을 전달받아올 때 사용
		// req.getParameter("name속성값"); : 요청 시 전달된 데이터 중 name 속성값이 일치하는 데이터의 vlaue를 얻어와 String 형태로 반환
		// **HTML에서 얻어오는 모든 값은 String형**
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");
		
		System.out.println("입력받은 이름 : " + name);
		System.out.println("입력받은 나이 : " + age);
		
		// ========== 서버 -> 클라이언트 응답 처리 ==========
		// 1) 서버에서 HTML 코드를 만들어 클라이언트에게 전달 = 응답 (response)
		// 2) 응답받은 내용을 클라이언트의 브라우저가 해석하여 화면에 출력해줌
		
		// HttpServletResponse 객체 이용
		// 응답처리 1. 응답하는 문서의 형식과 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 응답처리 2. 서버 -> 클라이언트로 연결되는 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 응답처리 3. 출력할 HTML 코드 만들기 > Servlet의 단점 : 응답 페이지 생성의 비효율성
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>서버 응답 페이지</title>");		
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append("<h1>응답페이지입니다</h1>");
		sb.append("<p>입력 받은 이름 : " + name + "</p>");
		sb.append("<p>입력 받은 나이 : " + age + "</p>");
		sb.append("</body>");
		
		sb.append("</html>");
		
		// 응답처리 4. 출력스트림을 이용해 클라이언트에게 HTML 코드를 제공하기(응답해주기)
		out.write(sb.toString());
	}
}