package com.psy.cookingBoard.cookingArticle.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBiz;
import com.psy.cookingBoard.cookingArticle.biz.CookingArticlesBizImpl;
import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.support.Param;

public class DoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CookingArticlesBiz articlesBiz;
	
	public DoModifyServlet() {
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
		String subJect = Param.getStringParam(request, "subJect");
		String content = Param.getStringParam(request, "content");
		
		CookingArticlesVO articlesVO = new CookingArticlesVO();
		articlesVO.setCookingArticleId(articleId);
		articlesVO.setCookingArticleSubject(subJect);
		articlesVO.setCookingArticleContent(content);
		
		boolean isSuccess = articlesBiz.modifyArticle(articlesVO);
		if(isSuccess){
			response.sendRedirect("/CookingBoard/board/detail?articleId="+articleId);
		}
		else{
			response.sendRedirect("/CookingBoard/board/detail?errorCode=1&&articleId="+articleId);
		}
	}

}
