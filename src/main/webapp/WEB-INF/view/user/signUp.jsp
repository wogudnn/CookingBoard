<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="/CookingBoard/css/layout.css">
<script type="text/javascript" src="/CookingBoard/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		moveToCenter();
		isVisibleSignUpButton();
		
		$("#cancelBtn").click(function(){
			location.href="/CookingBoard/signUp"
		});
		
		$("#signUpBtn").click(function(){
			$("#signUpForm").attr({
				"method": "post",
				"action": "/CookingBoard/doSignUp"
			}).submit();
		});
		
		$("#email").keyup(function(){
			
			$.post("/CookingBoard/checkEmail",{"email": $("#email").val()},function(data){
				if(data =="false"){
					$("#email").addClass("pass");
					$("#email").removeClass("warning");
				}
				else{
					$("#email").removeClass("pass");
					$("#email").addClass("warning");
				}
				isVisibleSignUpButton();
			});
			
		});
		
		
		$("#nickname").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			isVisibleSignUpButton();
		});
		
		$("#password1").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else if($(this).val() != $("#password2").val()){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password2").addClass("warning");
				$("#password2").removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password2").addClass("pass");
				$("#password2").removeClass("warning");
			}
			isVisibleSignUpButton();
		});
		
		$("#password2").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else if($(this).val() != $("#password1").val()){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password1").addClass("warning");
				$("#password1").removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password1").addClass("pass");
				$("#password1").removeClass("warning");
			}
			isVisibleSignUpButton();
		});
		
		
		
		
		
	});
	
	$(window).resize(function(){
		moveToCenter();
	});
	
	function moveToCenter(){
		var windowHeight = $(window).height();
		var wrapprHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight)/2)
								-(parseInt(wrapprHeight)/2);
		$("#wrapper").css({
			"position": "relative"
			, "top": middlePosition +"px"
		});
	}
	
	function isVisibleSignUpButton(){
		if($(".pass").length==4){
			$("#signUpBtn").show(500);
		}
		else{
			$("#signUpBtn").hide();
		}
	}
	

</script>
</head>
<body>
	<div id="wrapper">
		<form id="signUpForm" name="signUpForm">
			<div>
				<input type="text" id="email" name="email" placeholder="이메일을 입력하세요"><br/>
				<input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력하세요"><br/>
				<input type="password" id="password1" name="password1" placeholder="패스워드를입력하세요"><br/>
				<input type="password" id="password2" name="password2" placeholder="패스워드를 다시 입력하세요"><br/>
			</div>
			<div style="margin-top:5px;" >
				<div class="left">
					<input type="button" id="signUpBtn" value="Sign Up">
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