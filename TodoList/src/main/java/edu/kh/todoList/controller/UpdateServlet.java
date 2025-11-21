package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet {
	// 수정 버튼 클릭 시 요청한 수명 화면 전환 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 수정 화면에서 기존 제목(input), 상세 내용(textarea)이 조회 가능해야
			// > 수정 전 제목/내용 조회해서 가져오기 (= todoDetail 재호출(재사용))
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			Todo todo = service.todoDetail(todoNo);
			
			// 해당 번호의 todo가 존재하지 않는다면> 메인 페이지로 redirect
			if(todo == null) {
				resp.sendRedirect("/");
				return;
			}
			
			// request scope에 조회한 todo 객체를 세팅하여 > 요청 발송자를 통해 forward
			req.setAttribute("todo", todo);
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
