package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet {
	// a 태그 요청은 GET 방식 > doGet() 오버라이딩
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 처리
		// 1. page scope -> JSP에서만 확인 가능 (= 한 페이지만 유효)
		
		// 2. request scope -> 요청받은 Servlet과 요청이 위임된 JSP까지 유지되는 객체
		// 1) 객체에 값(속성) 추가하는 방법 : 범위객체.setAttribute("key", value);
		// 2) 객체에서 값(속성) 얻어오는 방법 : 범위객체.getAttribute("key");
		// 범위 객체에 세팅한 값(속성) 형태 : K=V
		// requestValue = request scope 객체에 세팅한 값
		req.setAttribute("requestValue", "request scope 객체에 세팅한 값");
		
		// 3. session scope -> 클라이언트가 서버에 첫 요청 시, 서버 측에 생성되는 객체
		// - 클라이언트가 브라우저를 종료하거나 지정된 세션 만료 시간이 지나면 사라짐 > 해당 상황이 아니라면 게속 유지됨
		// 1) session scope 객체 얻어오기 (더 작은 범위에서 얻어올 수 있음)
		HttpSession session = req.getSession();	
		
		// 2) session scope 값 세팅해보기
		// sessionValue = session scope 객체에 세팅한 값
		session.setAttribute("sessionValue", "session scope 객체에 세팅한 값");
		
		// 4. application scope -> 서버 전체에 한 개만 존재하는 객체
		// - 모든 클라이언트가 공유, 서버 시작 시 생성되어 서버 종료 시 제거(소멸)
		// 1) application scope 객체 얻어오기
		ServletContext application = req.getServletContext();
		// 2) application scope에 값 세팅
		application.setAttribute("applicationValue", "application scope 객체에 세팅한 값");
		
		// 범위별 우선순위 확인 : 범위가 좁을수록 우선순위가 높음
		// page > request > session > application
		
		// key값을 동일하게 하여 범위별 객체에 값 추가
		req.setAttribute("menu", "짬뽕(request)");
		session.setAttribute("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		
		// 응답 처리
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		dispatcher.forward(req, resp);
	}
}	
