package edu.kh.todoList.model.service;

import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

// 유지보수성과 확장성, 테스트 시 용이성을 위해 Service/DAO 단은 interface와 상속받는 구현체 class로 작성
// -> Controlelr는 ServiceImpl을 직접 사용하지 않고, Service 인터페이스를 의존 > 나중에 구현체가 바뀌어도 Controller에 미치는 영향 감소
// -> ex) ServiceImpl 대신 NewServiceImpl 만들어 새로운 로직을 적용하고자 할 때 손쉽게 교체 가능
public interface TodoListService {

	Map<String, Object> todoListFullView() throws Exception;

	int todoAdd(String title, String detail) throws Exception;

	Todo todoDetail(int todoNo) throws Exception;

	int todoComplete(int todoNo) throws Exception;

	int deleteTodo(int todoNo) throws Exception;

}