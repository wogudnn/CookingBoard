package com.psy.cookingBoard.cookingArticle.biz;

import java.util.List;

import com.psy.cookingBoard.cookingArticle.dao.CookingArticlesDao;
import com.psy.cookingBoard.cookingArticle.dao.CookingArticlesDaoImpl;
import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.user.dao.UserDao;
import com.psy.cookingBoard.user.dao.UserDaoImpl;

public class CookingArticlesBizImpl implements CookingArticlesBiz {

	private CookingArticlesDao articlesDao;
	private UserDao userDao;
	
	public CookingArticlesBizImpl() {
		articlesDao = new CookingArticlesDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	@Override
	public List<CookingArticlesVO> getArticlesOf() {
		
		return articlesDao.getArticlesOf();
	}
	@Override
	public boolean writeArticles(CookingArticlesVO articlesVO) {
		
		userDao.updatePoint(articlesVO);
		
		return articlesDao.writeArticles(articlesVO) > 0;
	}
	@Override
	public CookingArticlesVO getArticleBy(String articleId) {
		
		articlesDao.updateHitCount(articleId);
		
		return articlesDao.getArticleBy(articleId);
	}
	
	@Override
	public boolean deleteArticle(String articleId) {
		
		return articlesDao.deleteArticle(articleId) > 0;
	}
	
	@Override
	public boolean updateRecommend(String articleId) {

		return articlesDao.updateRecommend(articleId) > 0;
	}
	
	@Override
	public boolean modifyArticle(CookingArticlesVO articlesVO) {

		return articlesDao.modifyArticle(articlesVO) > 0 ;
	}
	
}
