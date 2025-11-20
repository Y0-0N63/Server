package edu.kh.todoList.model.service;

// JDBCTemplate의 모든 static 키워드로 선언된 메서드 > JDBCTemplate.getConnection();에서 getConnection()만 작성해도 가능하도록
import static edu.kh.todoList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {
	// 필드
	private TodoListDAO dao = new TodoListDAOImpl();

	@Override
	public Map<String, Object> todoListFullView() throws Exception {
		// 커넥션 생성
		Connection conn = getConnection();
		
		// dao 호출 및 결과 반환 받기
		// 1) 할 일 목록 전체를 얻어오기
		List<Todo> todoList = dao.todoListFullView(conn);
		
		// 2) 완료된 할 일의 개수 얻어오기
		int completeCount = dao.getCompleteCount(conn);
				
		// Map에 1, 2번으로 얻어온 데이터 세팅해서 리턴
		// > 메서드에서 반환 : 하나의 값 or 객체만 리턴 가능 > Map을 이용해 여러 형태의 값 한 번에 묶어서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		close(conn);
		
		return map;
	}

	@Override
	public int todoAdd(String title, String detail) throws Exception {
		Connection conn = getConnection();	
		int result = dao.todoAdd(conn, title, detail);
	
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		return result;
	}

}