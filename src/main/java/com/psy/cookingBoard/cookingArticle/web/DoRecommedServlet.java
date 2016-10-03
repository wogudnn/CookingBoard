package com.psy.cookingBoard.cookingArticle.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBiz;
import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBizImpl;
import com.psy.cookingBoard.support.Param;

public class DoRecommedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CookingArticlesBiz articlesBiz;
	
	public DoRecommedServlet() {
		super();
		articlesBiz = new CookingArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleId = Param.getStringParam(request, "articleId");
		
		if(articleId.length()==0) {
			response.sendRedirect("/CookingBoard/board/list?errorCode=2&&articleId="+articleId);
		}
		
		boolean isSuccess = articlesBiz.updateRecommend(articleId);
		if(isSuccess){
			response.sendRedirect("/CookingBoard/board/detail?articleId="+articleId);
		}
		else{
			response.sendRedirect("/CookingBoard/board/list?errorCode=1&&articleId="+articleId);
		}
		
	}

}
