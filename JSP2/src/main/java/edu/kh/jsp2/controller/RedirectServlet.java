package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// request scope 속성 추가
		req.setAttribute("str2", "request scope에 세팅된 값");
		
		// session scope 속성 추가
		HttpSession session = req.getSession();
		session.setAttribute("sessionNum", 10000);
		
		// 재요청 (redirect)
		// resp.sendRedirect("재요청할 Servlet의 매핑 주소");
		// *파일 경로가 아닌, 다시 요청할 Servlet의 @WebServlet("주소")에 작성된 주소를 작성해야
		// *재요청(redirect)는 무조건 Get 방식
		resp.sendRedirect("/fr/result");
		
		
	}
}
