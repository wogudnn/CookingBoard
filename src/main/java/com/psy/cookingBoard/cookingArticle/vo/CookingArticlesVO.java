package com.psy.cookingBoard.cookingArticle.vo;

import com.psy.cookingBoard.user.vo.UserVO;

public class CookingArticlesVO {
	private	 String cookingArticleId;
	private	 String cookingArticleSubject;
	private	 String cookingArticleContent;
	private	 String createDate;
	private	 int hitCount;
	private int recommedCount;
	private String userId;
	private String fileName;
	private UserVO userVO;
	
	public CookingArticlesVO() {
		userVO = new UserVO();
	}

	public String getCookingArticleId() {
		return cookingArticleId;
	}

	public void setCookingArticleId(String cookingArticleId) {
		this.cookingArticleId = cookingArticleId;
	}

	public String getCookingArticleSubject() {
		return cookingArticleSubject;
	}

	public void setCookingArticleSubject(String cookingArticleSubject) {
		this.cookingArticleSubject = cookingArticleSubject;
	}

	public String getCookingArticleContent() {
		return cookingArticleContent;
	}

	public void setCookingArticleContent(String cookingArticleContent) {
		this.cookingArticleContent = cookingArticleContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getRecommedCount() {
		return recommedCount;
	}

	public void setRecommedCount(int recommedCount) {
		this.recommedCount = recommedCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	
}
