package com.psy.cookingBoard.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.cookingBoard.support.Param;
import com.psy.cookingBoard.user.biz.UserBiz;
import com.psy.cookingBoard.user.biz.UserBizImpl;
import com.psy.cookingBoard.user.vo.UserVO;

public class DoSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	public DoSignInServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = Param.getStringParam(request, "email");
		String password = Param.getStringParam(request, "password");
		

		if(email.length()==0){
			response.sendRedirect("/CookingBoard/signIn?errorCode=2");;
		}
		if(password.length()==0){
			response.sendRedirect("/CookingBoard/signIn?errorCode=2");
		}
		
		
		UserVO userVO = new UserVO();
		
		userVO.setEmail(email);
		userVO.setPassword(password);
		
		boolean isSuccess = userBiz.signIn(request,userVO);
		if(isSuccess){
			response.sendRedirect("/CookingBoard/board/list");
		}
		else{
			response.sendRedirect("/CookingBoard/signIn?errorCode=1");
		}
		
		
		
	}

}
