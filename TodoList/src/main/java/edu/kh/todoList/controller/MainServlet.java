package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// '/main' 요청을 매핑하여 처리하는 서블릿
// index.jsp에서 메인 페이지 코드를 작성하지 않고 /main 요청을 처리하는 서블릿을 만드는 이유
// -> Servlet(Java 코드 <-> DB)에서 추가한 데이터를 메인 페이지에서부터 사용할 수 있게 하기 위해
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DB에 접근
		// 요청이 오면 > Controller(Servlet)에 매핑되고 > Service > DAO > DB
		// 응답		  <- views(jsp)			     		<-		 <-		<-	
		// 최종적으로 Exceptinon을 받아주는 Servlet에 try-catch문 작성
		try {
			// TodoListService();는 인터페이스이기 때문에 new 연산자를 통해 객체를 생성할 수 없음
			// > TodoListService()를 상속받아 구현된 TodoListServiceImpl을 작성
			TodoListService service = new TodoListServiceImpl();
			
			// 전체 할 일 목록 + 완료된 Todo 개수
			Map<String, Object> map = service.todoListFullView();
			
			// map 형태로 JSP에 전송할 시 > 사용이 어려움 > List/int 각각을 request scope에 추가
			// Map에 저장된 값 풀어내기
			List<Todo> todoList = (List<Todo>)map.get("todoList");
			int completeCount = (int)map.get("completeCount");
			
			// request scope에 객체 값 추가하기
			req.setAttribute("todoList", todoList);
			req.setAttribute("completeCount", completeCount);
			
			// 메인 페이지 응답을 담당하는 JSP에 요청 위임
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}