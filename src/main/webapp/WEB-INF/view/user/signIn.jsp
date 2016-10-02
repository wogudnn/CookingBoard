<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signIn</title>
<link rel="stylesheet" type="text/css" href="/CookingBoard/css/layout.css">
<script type="text/javascript" src="/CookingBoard/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		moveTocenter()
		isVisibleSignInuButton()
		
		$("#cancelBtn").click(function(){
			location.href="/CookingBoard/signIn"
		});
		
		$("#signInBtn").click(function(){
			$("#signInForm").attr({
				"method": "post",
				"action": "/CookingBoard/doSignIn"
			}).submit();
		});
		
		$("#email").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleSignInuButton()
		});
		
		$("#password").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleSignInuButton()
		});
		
		
	});
	
	function moveTocenter(){
		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight)/2)
								-(parseInt(wrapperHeight)/2);
		$("#wrapper").css({
			"position": "relative",
			"top": middlePosition+"px"
		});
	}
	function isVisibleSignInuButton(){
		if($(".pass").length==2){
			$("#signInBtn").show(500);
		}
		else{
			$("#signInBtn").hide();
		}
	}

</script>
</head>
<body>
	<div id="wrapper">
		<form id="signInForm" name="signInForm">
			<div>
				<input type="text" id="email" name="email" placeholder="이메일을 입력하세요"><br/>
				<input type="password" id="password" name="password" placeholder="패스워드를입력하세요"><br/>
			</div>
			<div style="margin-top:5px;" >
				<div class="left">
					<input type="button" id="signInBtn" value="Sign In">
				</div>
				<div class="right">
					<input type="button" id="cancelBtn" value="Cancel">
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>

</body>
</html>