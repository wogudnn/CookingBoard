package com.psy.cookingBoard.cookingArticle.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBiz;
import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBizImpl;
import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.support.Param;

public class ViewDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CookingArticlesBiz articlesBiz;

	public ViewDetailPageServlet() {
		super();
		articlesBiz = new CookingArticlesBizImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleId = Param.getStringParam(request, "articleId");
		
		if(articleId.length()==0){
			response.sendRedirect("/CookingBoard/board/list?errorCode=1");
		}
		
		CookingArticlesVO articlesVO = articlesBiz.getArticleBy(articleId);
		
		String viewPath = "/WEB-INF/view/cookingArticle/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("articlesVO", articlesVO);
		
		rd.forward(request, response);
	}

}
