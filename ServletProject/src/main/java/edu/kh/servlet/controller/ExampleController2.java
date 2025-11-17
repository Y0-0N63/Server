package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet 관련 코드를 작성하기 위해 HttpServlet 클래스 상속받기
// 그러나 바로 Servlet 등록이 되는 것은 아니므로 > web.xml 작성 or @WebServlet() 어노테이션 사용

/* 어노테이션 : 컴파일러가 읽는 주석
 * @WebServlet() > 해당 클래스를 Servlet으로 등록하고 () 안에 작성된 주소와의 연결을 지시하는 어노테이션
 * 서버 실행 시 자동으로 web.xml의 <servlet><servlet-mapping>을 작성하는 것과 동일
 * */ 
@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet {
	// Post 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 시 제출받은 데이터 얻어오기
		String userId = req.getParameter("inputId");
		String userPw = req.getParameter("inputPw");
		String userName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		System.out.println(intro);
		
		// JSP를 사용하여 응답 화면 만들기 : Servlet이 JSP에게 요청/응답을 위임
		// > JSP가 대신 응답 화면을 만들어주기 위해 Servlet이 어떤 요청을 받았는지 알아야 함
		// RequestDispatcher 객체를 만들 때 작성해야 하는 경로는 webapp 폴더를 기준으로 작성
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		// 메인페이지 : 사용자가 주소로 직접 접근할 서 있어야 하기 때문에 파일명 재사용
		// webapp 폴더 : 웹 애플리케이션으 루트(root) 디렉토리로 브라우저를 통해 접근 가능한 정적/동적 리소스가 위치
		// webapp 폴더가 컨텍스트 경로(/)로 설정되기 때문에 해당 경로가 webapp 내부 경로로 해석됨
		// web-inf 폴더에 있는 파일은 클라이언트가 url로 직접 접근할 수 없는 영역으로 ,서블릿을 통해서만 접근 가능

		// Request Dispatcher객체를 사용해 현재 요청(req)과 응답(resp)을 지정한 JSP페이지 (result.jsp)로 전달하는 작업
		// 즉, 현재 서블릿(ExampleController2)에서 처리하던 요청을 result.jsp로 전달하고 제어권을 그곳으로 넘김(위임)
		dispatcher.forward(req, resp);
	}
}