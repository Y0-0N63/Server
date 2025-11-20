package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/add")
public class TodoAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 1. TodoListServiceImpl 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 2. 요청 시 전달받은 파라미터 데이터 얻어오기
			String title = req.getParameter("title"); // 제목
			String detail = req.getParameter("detail"); // 상세내용
			
			// 3. 서비스 호출 후 결과 반환받기
			int result = service.todoAdd(title, detail);
			
			// 4. 성공/실패 메시지 세팅
			String message = null;
			if(result > 0) message = "추가 성공";
			else			message = "추가 실패";
			
			// 5. 기존 req를 사용할 수 없음 > session을 이용해 message 세팅
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			// 6. 메인페이지 redirect (재요청)
			// "/" : 최상위 경로(메인 페이지)로 재요청을 보냄 = "/"(index->/main)를 처리하는 Servlet/JSP 재요청
			// redirect : 무조건 GET 방식
			// 기존 req를 사용할 수 없음 > 5번으로
			resp.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
