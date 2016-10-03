package com.psy.cookingBoard.cookingArticle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psy.cookingBoard.cookingArticle.vo.CookingArticlesVO;
import com.psy.cookingBoard.support.DaoSupport;
import com.psy.cookingBoard.support.Query;
import com.psy.cookingBoard.support.QueryAndResult;
import com.psy.cookingBoard.user.vo.UserVO;

public class CookingArticlesDaoImpl extends DaoSupport implements CookingArticlesDao {

	@Override
	public List<CookingArticlesVO> getArticlesOf() {

		return selectList(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	C.COOK_ATCL_ID, ");
				query.append(" C.COOK_ATCL_SBJ, C.COOK_ATCL_CNNT, ");
				query.append(" TO_CHAR(C.CRT_DT,'YYYY-MM-DD') CRT_DT, C.HIT_CNT, ");
				query.append(" C.RCMD_CNT, C.USR_ID, C.FILE_NM, U.USR_NM, U.POINT  ");
				query.append(" FROM 	COOK_ATCL C, USR U ");
				query.append(" WHERE 	C.USR_ID = U.USR_ID ");
				query.append(" ORDER	BY COOK_ATCL_ID DESC ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<CookingArticlesVO> articles = new ArrayList<CookingArticlesVO>();
				CookingArticlesVO articlesVO = null;
				UserVO userVO = null;

				while (rs.next()) {
					articlesVO = new CookingArticlesVO();
					userVO = articlesVO.getUserVO();
					articlesVO.setCookingArticleId(rs.getString("COOK_ATCL_ID"));
					articlesVO.setCookingArticleSubject(rs.getString("COOK_ATCL_SBJ"));
					articlesVO.setCookingArticleContent(rs.getString("COOK_ATCL_CNNT"));
					articlesVO.setCreateDate(rs.getString("CRT_DT"));
					articlesVO.setHitCount(rs.getInt("HIT_CNT"));
					articlesVO.setRecommedCount(rs.getInt("RCMD_CNT"));
					articlesVO.setUserId(rs.getString("USR_ID"));
					articlesVO.setFileName(rs.getString("FILE_NM"));
					userVO.setNickName(rs.getString("USR_NM"));
					userVO.setPoint(rs.getInt("POINT"));
					
					articles.add(articlesVO);
				}

				return articles;
			}
		});
	}

	@Override
	public int writeArticles(CookingArticlesVO articlesVO) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO COOK_ATCL ( ");
				query.append(" COOK_ATCL_ID, COOK_ATCL_SBJ, COOK_ATCL_CNNT, ");
				query.append(" CRT_DT, HIT_CNT, RCMD_CNT, USR_ID, FILE_NM ) ");
				query.append(" VALUES ( ");
				query.append(" 'AR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(COOK_ATCL_ID_SEQ.NEXTVAL,6,0), ");
				query.append(" ?, ?, SYSDATE, 0, 0, ?, ? ) ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesVO.getCookingArticleSubject());
				pstmt.setString(2, articlesVO.getCookingArticleContent());
				pstmt.setString(3, articlesVO.getUserId());
				pstmt.setString(4, articlesVO.getFileName());

				return pstmt;
			}
		});
	}

	@Override
	public CookingArticlesVO getArticleBy(String articleId) {
		return (CookingArticlesVO) selectOne(new QueryAndResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	C.COOK_ATCL_ID, ");
				query.append(" C.COOK_ATCL_SBJ, C.COOK_ATCL_CNNT, ");
				query.append(" TO_CHAR(C.CRT_DT,'YYYY-MM-DD') CRT_DT, C.HIT_CNT, ");
				query.append(" C.RCMD_CNT, C.USR_ID, C.FILE_NM, U.USR_NM, U.POINT ");
				query.append(" FROM 	COOK_ATCL C, USR U ");
				query.append(" WHERE 	C.USR_ID = U.USR_ID ");
				query.append(" AND	 	COOK_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);

				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				CookingArticlesVO articlesVO = null;
				UserVO userVO = null;

				while (rs.next()) {
					articlesVO = new CookingArticlesVO();
					userVO = articlesVO.getUserVO();
					articlesVO.setCookingArticleId(rs.getString("COOK_ATCL_ID"));
					articlesVO.setCookingArticleSubject(rs.getString("COOK_ATCL_SBJ"));
					articlesVO.setCookingArticleContent(rs.getString("COOK_ATCL_CNNT"));
					articlesVO.setCreateDate(rs.getString("CRT_DT"));
					articlesVO.setHitCount(rs.getInt("HIT_CNT"));
					articlesVO.setRecommedCount(rs.getInt("RCMD_CNT"));
					articlesVO.setUserId(rs.getString("USR_ID"));
					articlesVO.setFileName(rs.getString("FILE_NM"));
					userVO.setNickName(rs.getString("USR_NM"));
					userVO.setPoint(rs.getInt("POINT"));

				}

				return articlesVO;
			}
		});
	}

	@Override
	public int deleteArticle(String articleId) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM		COOK_ATCL ");
				query.append(" WHERE	COOK_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);

				return pstmt;
			}
		});
	}

	public int updateHitCount(String articleId) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE COOK_ATCL ");
				query.append(" SET HIT_CNT = HIT_CNT + 1 ");
				query.append(" WHERE COOK_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);

				return pstmt;
			}
		});
	}

	@Override
	public int updateRecommend(String articleId) {

		return insert(new Query() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE COOK_ATCL ");
				query.append(" SET RCMD_CNT = RCMD_CNT + 1, ");
				query.append(" 		HIT_CNT = HIT_CNT - 1 ");
				query.append(" WHERE COOK_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);

				return pstmt;

			}
		});
	}
	
	@Override
	public int modifyArticle(CookingArticlesVO articlesVO) {

		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE COOK_ATCL ");
				query.append(" SET	COOK_ATCL_SBJ = ?, ");
				query.append(" 		COOK_ATCL_CNNT = ?, ");
				query.append(" 		HIT_CNT = HIT_CNT - 2  ");
				query.append(" WHERE COOK_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesVO.getCookingArticleSubject());
				pstmt.setString(2, articlesVO.getCookingArticleContent());
				pstmt.setString(3, articlesVO.getCookingArticleId());

				return pstmt;
			}
		});
	}

}
