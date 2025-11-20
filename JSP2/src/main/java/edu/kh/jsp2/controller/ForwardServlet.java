package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fr/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("str", "안녕하세요");
		
		// 요청발송자를 이용해 req, resp를 forward_result.jsp로 위임
		req.getRequestDispatcher("/WEB-INF/views/fr/forward_result.jsp").forward(req, resp);
	}
}