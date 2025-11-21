package edu.kh.todoList.model.dao;

import static edu.kh.todoList.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
	public TodoListDAOImpl() {
	// TodoListDAOImpl 객체가 생성 될 때( Service 단에서 new 연산자를 통해 객체화 될 때)
	// sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
		
		try {
			String filePath = TodoListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {
		// 결과 저장용 변수 선언
		List<Todo> todoList = new ArrayList();
		
		// 문자열로 작성하지 않고 sql.xml을 사용해 SQL 작성 > TodoListDAOImpl() 생성
		try {
			// SQL 작성
			String sql = prop.getProperty("todoListFullView");
			stmt = conn.createStatement();
			
			// executeQuery : SELECT 구문 수행 후 ResultSet 반환
			// executeUpdate : DML(INSERT, UPDATE, DELETE) 수행 후 결과 행의 개수 반환
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// Builder 패턴 : 특정값으로 초기화된 객체를 쉽게 만드는 방법
				// -> Lombok에서 제공하는 @Builder 어노테이션을 DTO에 작성해 준비
				boolean complete = rs.getInt("TODO_COMPLETE") == 1;
				Todo todo = Todo.builder().todoNo(rs.getInt("TODO_NO")).todoTitle(rs.getString("TODO_TITLE")).todoComplete(complete)
						.regDate(rs.getString("REG_DATE")).build();
				todoList.add(todo);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return todoList;
	}

	@Override
	public int getCompleteCount(Connection conn) throws Exception {
		// 결과 저장용 변수 선언
		int completeCount = 0;
		
		try {
			String sql = prop.getProperty("getCompleteCount");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				completeCount = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return completeCount;
	}

	@Override
	public int todoAdd(Connection conn, String title, String detail) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("todoAdd");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public Todo todoDetail(Connection conn, int todoNo) throws Exception {
		// 결과 저장용 변수 선언
		Todo todo = null;
		
		try {
			String sql = prop.getProperty("todoDetail");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boolean complete = rs.getInt("TODO_COMPLETE") == 1;
				todo = Todo.builder()
						.todoNo(todoNo)
						.todoTitle(rs.getString("TODO_TITLE"))
						.todoDetail(rs.getString("TODO_DETAIL"))
						.todoComplete(complete)
						.regDate(rs.getString("REG_DATE"))
						.build();
				}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return todo;
	}

	@Override
	public int todoComplete(Connection conn, int todoNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("todoComplete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int deleteTodo(Connection conn, int todoNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteTodo");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int todoUpdate(Connection conn, int todoNo, String title, String detail) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("todoUpdate");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			pstmt.setInt(3, todoNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
}