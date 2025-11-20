package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
	// todo 번호
	private int todoNo;

	// todo 제목
	private String todoTitle;
	
	// todo 상세 내용
	private String todoDetail;

	// todo 완료 여부
	private boolean todoComplete;
	
	// todo 등록일
	private String regDate;

}