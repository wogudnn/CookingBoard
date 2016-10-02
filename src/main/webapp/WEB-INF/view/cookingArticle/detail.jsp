<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/CookingBoard/css/layout.css" />
<script type="text/javascript" src="/CookingBoard/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if(confirm("\"${articlesVO.cookingArticleSubject}.\"를 삭제하시겠습니까?")) {

				location.href="/CookingBoard/board/doDelete?articleId=${articlesVO.cookingArticleId}"
			}
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="article">
			<div id="articleHeader">
				<p>${articlesVO.cookingArticleSubject}</p>
				<div id="articleInfo">
					<span>작성자 : ${articlesVO.userVO.nickName}</span>
					<span>작성시간: ${articlesVO.createDate}</span>
					<span>조회수 : ${articlesVO.hitCount}</span>
					<span>추천수 : ${articlesVO.recommedCount}</span>
				</div>
			</div>
			<hr/>
			<div id="articleBody">
				${articlesVO.cookingArticleContent}
			</div>
		</div>
		<div id="articleFooter">
			<a href="javascript:void(0);" id="deleteBtn">삭제</a>
			<a href="/CookingBoard/board/list">목록보기</a>
		</div>
	</div>
</body>
</html>