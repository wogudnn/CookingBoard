package com.psy.cookingBoard.user.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.cookingBoard.support.Param;
import com.psy.cookingBoard.user.biz.UserBiz;
import com.psy.cookingBoard.user.biz.UserBizImpl;

public class DuplicateCheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DuplicateCheckEmail() {
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
		
		boolean isSuccess = userBiz.checkEmail(email);
		PrintWriter out = response.getWriter();
		out.print(isSuccess+"");
		out.flush();
		out.close();
		
		
	}

}
