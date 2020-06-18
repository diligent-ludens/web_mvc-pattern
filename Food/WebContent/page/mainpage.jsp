<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		height:600px;
	}
	
	a{
		text-decoration: none;
		color:black;
	}	
	#oh{
		font-size:5ex;
		text-align: center;
		border: 1px dashed  #e6aabb;
	}
	#han{border: 1px dashed  #e6aabb;}
	#jung{border: 1px dashed  #e6aabb;}
	#yang{border: 1px dashed  #e6aabb;}
	#bun{border: 1px dashed  #e6aabb;}	
	#cafe{border: 1px dashed  #e6aabb;}	
</style>
<script type="text/javascript">
	
	function cafeclick(){
		alert('추후 서비스 제공 예정')
	}


</script>
</head>
<body>

	<jsp:include page="/page/header.jsp"></jsp:include>
	<table align="center">
		<tr>
			<td rowspan="3" width="350px" id="oh"><a href="./DetailView.ag?num=<%=(int)(Math.random()*5+1)%>">오늘의 추천</a></td>
			<td width="100px" height="100px" id="han"><a href="./koreafood.gu"><img src="./images/han.jpg"/></a></td>
			<td width="100px"  height="100px" id="jung"><a href="./chinafood.gu"><img src="./images/jung.jpg"/></a></td>
		</tr>
		<tr>
			<td width="200px" height="200px" ><a href="./westfood.gu"><img src="./images/yang.jpg"/></a></td>
			<td width="200px" height="200px" id="bun"><a href="./snackfood.gu"><img src="./images/bun.jpg"/></a></td>
		</tr>
		<tr>
			<td height="200px" id="cafe"><a href="javascript:cafeclick()	"><img src="./images/cafe.jpg"/></a></td>
			<td><a href="#"></a></td>
		</tr>
	</table>
	<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>