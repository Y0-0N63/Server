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
	
	/* 요청 주소가 같지만 데이터 제출 방식(GET/POST)가 다르다면
	 * 하나의 서블릿 클래스에서 각각의 메서드(doGet(), doPost())를 만들어 처리할 수 있음 */
	
	// 할 일 제목, 내용 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 전달받은 파라미터 얻어오기 (제목, 상세 내용, todoNo)
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			int result = service.todoUpdate(todoNo, title, detail);
			
			String url = null;
			String message = null;
			
			// 수정 성공 시 > 상세 조회 페이지로 redirect, message "수정되었습니다"
			if(result > 0) {
				url = "/todo/detail?todoNo=" + todoNo;
				message = "수정되었습니다.";
			} else {
				// 수정 실패 시 > 수정 화면으로 redirect, message "수정 실패"
				url = "/todo/update?todoNo=" + todoNo;
				message = "수정 실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
