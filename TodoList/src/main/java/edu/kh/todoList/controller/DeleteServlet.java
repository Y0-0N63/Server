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

@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoListService service = new TodoListServiceImpl();
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));

			// 할 일을 삭제하는 서비스 호출 후 결과 반환받기
			int result = service.deleteTodo(todoNo);
			
			HttpSession session = req.getSession();
			String message = null;
			
			// 성공 + 실패 시 모두 > 메인 페이지로 리다이렉트 	
			if(result > 0) {
				// 삭제 성공 시 > message "할 일이 삭제되었습니다"
				message = "할 일이 삭제되었습니다.";
			} else {
				// 삭제 실패 시 > message "todo가 존재하지 않습니다"
				message = "todo가 존재하지 않습니다.";
			}
			session.setAttribute("message", message);;
			resp.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
