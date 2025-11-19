package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data // Getter, Setter, ToString 하나로 제공됨
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화용 생성자
public class Book {
	// 필드
	private String title;
	private String writer;
	private int price;
	
	// 메서드 (생성자, getter, setter, toString)
}
