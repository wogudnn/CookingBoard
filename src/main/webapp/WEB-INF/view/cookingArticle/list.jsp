<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
<link rel="stylesheet" type="text/css"
	href="/CookingBoard/css/layout.css">
<link rel="stylesheet" type="text/css" href="/CookingBoard/css/grid.css">
<script type="text/javascript" src="/CookingBoard/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>요리게시판</h2>
	<hr />
	<div id="wrapper">
		<table class="grid">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>작성일</th>
			</tr>
			
			<c:if test="${empty articles}">
				<tr>
					<td colspan="7">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach items="${articles}" var="article">
				<tr>
					<c:set var="number"
						value="${fn: split(article.cookingArticleId, '-')[2]}"></c:set>
					<fmt:parseNumber var="number" type="number" value="${number}"></fmt:parseNumber>
					<td>${number}</td>
					<td><a
						href="/CookingBoard/board/detail?articleId=${article.cookingArticleId}">${article.cookingArticleSubject}</a></td>
					<td><c:choose>
							<c:when test="${fn:length(article.cookingArticleContent)>10}">
							${fn:substring(article.cookingArticleContent,0,10)}...
						</c:when>
							<c:otherwise>
							${article.cookingArticleContent}
						</c:otherwise>
						</c:choose></td>
					<td>${article.userVO.nickName}</td>
					<td>${article.hitCount}</td>
					<td>${article.recommedCount}</td>
					<td>${article.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div style="margin-top: 5px;">
			<div class="right">
				<a href="/CookingBoard/board/write">글쓰기</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>

</body>
</html>