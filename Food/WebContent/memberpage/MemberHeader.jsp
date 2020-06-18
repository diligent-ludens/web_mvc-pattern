<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<style type="text/css">
	header{
		display:auto;
		width:auto;
		height:100px;					
	}
	a{
		text-decoration: none;
		color:black;
	}
	ul{
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	li{
		float:left;
		overflow:hidden;
		margin-left:90px;
		margin-top:30px;
		font-size:20px;
	}
	
</style>
</head>
<body>
	<div style="background-image: url(./images/header.jpg); background-repeat: no-repeat;">
		<header>
			<nav>
				<ul>
					<li><a href="./MemberMainPage.me">홈</a></li>
					<li><a href="./MemberKoreaFood.me">한식</a></li>
					<li><a href="./MemberChinaFood.me">중식</a></li>
					<li><a href="./MemberWestFood.me">양식</a></li>
					<li><a href="./MemberSnackFood.me">분식</a></li>
					<li><a href="./MemberQnaLoginList.me">QnA</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<li><input type="button" value="로그아웃" onclick="window.location='./mainPage.gu'"></li>
				</ul>						
			</nav>
		</header>
	</div>
</body>
</html>