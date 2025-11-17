package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		// getParameter : 같은 name 속성을 가진 여러 개 값들 중, 첫 번째 값 하나만 반환
		String option = req.getParameter("opt");
		
		// getParameterValues : 같은 name 속성을 가진 모든 값을 String 배열 형태로 반환
		String[] optionArr = req.getParameterValues("opt");
		
		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(option);
		System.out.println(optionArr); // 주소값
		
		// opt 미선택 > optionArr == null
		if(optionArr != null) {
			for(String opt : optionArr) {
				System.out.println(opt);
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		dispatcher.forward(req, resp);
	}
}