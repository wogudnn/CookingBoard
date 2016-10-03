package com.psy.cookingBoard.user.dao;

import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.user.vo.UserVO;

public interface UserDao {

	public int checkEmail(String email);

	public int addUser(UserVO userVO);

	public UserVO signIn(UserVO userVO);

	public int updatePoint(CookingArticlesVO articlesVO);

}
