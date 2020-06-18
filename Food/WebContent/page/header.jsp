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
						<li><a href="./mainPage.gu">홈</a></li>
						<li><a href="./koreafood.gu">한식</a></li>
						<li><a href="./chinafood.gu">중식</a></li>
						<li><a href="./westfood.gu">양식</a></li>
						<li><a href="./snackfood.gu">분식</a></li>
						<li><a href="./qnalist.qn">QnA</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<li><input type="button" value="로그인" onclick="window.location='./loginpage.gu'"></li>
					</ul>													
				</nav>
		</header>
	</div>
</body>
</html>