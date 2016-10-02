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

public class DoSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DoSignUp() {
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
		String nickname = Param.getStringParam(request, "nickname");
		String password1 = Param.getStringParam(request, "password1");
		String password2 = Param.getStringParam(request, "password2");
		
		if(email.length()==0){
			response.sendRedirect("/CookingBoard/signUp?errorCode=2");
			return;
		}
		if(nickname.length()==0){
			response.sendRedirect("/CookingBoard/signUp?errorCode=3");
			return;
		}
		if(password1.length()==0){
			response.sendRedirect("/CookingBoard/signUp?errorCode=4");
			return;
		}
		if(password2.length()==0){
			response.sendRedirect("/CookingBoard/signUp?errorCode=5");
			return;
		}
		
		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		userVO.setNickName(nickname);
		userVO.setPassword(password1);
		
		boolean isSuccess = userBiz.addUser(userVO);
		if(isSuccess){
			response.sendRedirect("/CookingBoard/signIn");
		}
		else{
			response.sendRedirect("/CookingBoard/signUp?errorCode=1");
		}
		
	}

}
