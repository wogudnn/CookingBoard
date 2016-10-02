package com.psy.cookingBoard.cookingArticle.biz;

import java.util.List;

import com.psy.cookingBoard.cookingArticle.dao.CookingArticlesDao;
import com.psy.cookingBoard.cookingArticle.dao.CookingArticlesDaoImpl;
import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;

public class CookingArticlesBizImpl implements CookingArticlesBiz {

	private CookingArticlesDao articlesDao;
	
	public CookingArticlesBizImpl() {
		articlesDao = new CookingArticlesDaoImpl();
	}
	
	@Override
	public List<CookingArticlesVO> getArticlesOf() {
		
		return articlesDao.getArticlesOf();
	}
	@Override
	public boolean writeArticles(CookingArticlesVO articlesVO) {
		
		return articlesDao.writeArticles(articlesVO) > 0;
	}
	@Override
	public CookingArticlesVO getArticleBy(String articleId) {
		
		return articlesDao.getArticleBy(articleId);
	}
	
	@Override
	public boolean deleteArticle(String articleId) {
		
		return articlesDao.deleteArticle(articleId) > 0;
	}
	
}
