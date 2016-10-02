package com.psy.cookingBoard.cookingArticle.biz;

import java.util.List;

import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;

public interface CookingArticlesBiz {

	public List<CookingArticlesVO> getArticlesOf();

	public boolean writeArticles(CookingArticlesVO articlesVO);

	public CookingArticlesVO getArticleBy(String articleId);

	public boolean deleteArticle(String articleId);

}
