package com.psy.cookingBoard.user.biz;

import javax.servlet.http.HttpServletRequest;

import com.psy.cookingBoard.user.vo.UserVO;

public interface UserBiz {

	public boolean checkEmail(String email);

	public boolean addUser(UserVO userVO);

	public boolean signIn(HttpServletRequest request, UserVO userVO);


}
