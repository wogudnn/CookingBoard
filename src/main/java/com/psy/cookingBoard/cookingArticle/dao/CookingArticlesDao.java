package com.psy.cookingBoard.cookingArticle.dao;

import java.util.List;

import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;

public interface CookingArticlesDao {

	public List<CookingArticlesVO> getArticlesOf();

	public int writeArticles(CookingArticlesVO articlesVO);

	public CookingArticlesVO getArticleBy(String articleId);

	public int deleteArticle(String articleId);
	
	public int updateHitCount(String articleId);

	public int updateRecommend(String articleId);

	public int modifyArticle(CookingArticlesVO articlesVO);

}
