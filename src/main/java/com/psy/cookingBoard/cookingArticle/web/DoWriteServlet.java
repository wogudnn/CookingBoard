package com.psy.cookingBoard.cookingArticle.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psy.cookingBoard.constants.Session;
import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBiz;
import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBizImpl;
import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.support.Param;
import com.psy.cookingBoard.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CookingArticlesBiz articlesBiz;
	
	public DoWriteServlet() {
		super();
		articlesBiz = new CookingArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String subJect = Param.getStringParam(request, "subJect");
		String content = Param.getStringParam(request, "content");
		
		if(subJect.length()==0){
			response.sendRedirect("/CookingBoard/board/list?errorCode=2");
		}
		if(content.length()==0){
			response.sendRedirect("/CookingBoard/board/list?errorCode=2");
		}
		
		CookingArticlesVO articlesVO = new CookingArticlesVO();
		articlesVO.setCookingArticleSubject(subJect);
		articlesVO.setCookingArticleContent(content);
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);
		articlesVO.setUserId(userInfo.getUserId());
		
		boolean isSuccess = articlesBiz.writeArticles(articlesVO);
		
		if(isSuccess){
			response.sendRedirect("/CookingBoard/board/list");
		}
		else{
			response.sendRedirect("/CookingBoard/board/list?errorCode=1");
		}
		
	}

}
