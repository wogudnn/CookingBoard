package com.psy.cookingBoard.user.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.psy.cookingBoard.constants.Session;
import com.psy.cookingBoard.user.dao.UserDao;
import com.psy.cookingBoard.user.dao.UserDaoImpl;
import com.psy.cookingBoard.user.vo.UserVO;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean checkEmail(String email) {

		return userDao.checkEmail(email)>0;
	}
	@Override
	public boolean addUser(UserVO userVO) {
		
		return userDao.addUser(userVO) > 0 ;
	}
	@Override
	public boolean signIn(HttpServletRequest request, UserVO userVO) {
		
		UserVO userInfo = userDao.signIn(userVO);
		if( userInfo != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute(Session.USER_INFO, userInfo);
			return true;
		}
		
		return false;
	}
}
