<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<style type="text/css">
	table{
		margin-top:50px;
		margin-bottom:50px;
		width:1000px;	
		height:700px;
	}
	td{
		font-size:5ex;
		text-align: center;
		border: 1px dashed  #e6aabb;
	}
	a{
		text-decoration: none;
		color:black;
	}		
	#oh {
		font-size:5ex;
		text-align: center;
		border: 1px dashed  #e6aabb;
	}
	#han{border: 1px dashed  #e6aabb;}
	#jung{border: 1px dashed  #e6aabb;}
	#yang{border: 1px dashed  #e6aabb;}
	#bun{border: 1px dashed  #e6aabb;}	
	#cafe{border: 1px dashed  #e6aabb;}
	#my{border: 1px dashed  #e6aabb;}	
</style>
<script type="text/javascript">

function cafeclick(){
	alert('추후 서비스 제공 예정')
}


</script>
</head>
<body>

	<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>
	<table align="center">
		<tr>
			<td rowspan="3" width="350px" id="oh"><a href="./DetailView.ag?num=<%=(int)(Math.random()*5+1)%>">오늘의 추천</a></td>
			 <td width="200px" height="200px" id="han"><a href="./MemberKoreaFood.me"><img src="./images/han.jpg"/></a></td>
			<td width="200px"  height="200px" id="jung"><a href="./MemberChinaFood.me"><img src="./images/jung.jpg"/></a></td>
		</tr>
		<tr>
			<td width="200px" height="200px" id="yang"><a href="./MemberWestFood.me"><img src="./images/yang.jpg"/></a></td>
			<td width="200px" height="200px" id="bun"><a href="./MemberSnackFood.me"><img src="./images/bun.jpg"/></a></td>
		<tr>
			<td width="200px" height="200px" id="cafe"><a href="javascript:cafeclick()"><img src="./images/cafe.jpg"/></a></td>
			<td width="200px" height="200px" id="my"><a href="./MemberMyPageList.me">mypage</a></td>
		</tr>
	</table>
	<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>