<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>맛집 등록</title>

<style type="text/css">
	table, tr, td{
		border:1px solid black;
		border-collapse: 0;
		border-spacing: 0;
	}
	table{
		margin-top:20px;
		margin-bottom:50px;
	}
</style>	
	
</head>
<body>
<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>
	<form  action="./DetailAddAction.ag" name="detailform" method="post" enctype="multipart/form-data">
		<input type="hidden" name="DETAIL_BEST" value="0">
				<h1 align="center">맛 집 등 록</h1>
		<table align="center" width="558">
			<tr>
			<td width="200" height="30" align="center">카테고리</td>
			<td width="350" height="30">
				<select name="DETAIL_CATEGORY" size="1" >
					<option value="한식" selected>한 식</option>
					<option value="중식">중 식</option>
					<option value="양식">양 식</option>
					<option value="분식">분 식</option>
				</select>
			</td>
			</tr>
			<tr>
			<td align="center" height="30">가게 이름</td>
			<td><input type="text" name="DETAIL_NAME"></td>
		</tr>
		<!-- <tr>
			<td>
				<p align="center"><font size=2>위치</font></p>
			</td>
			<td><input type="text" name="DETAIL_LOCATION"></td>
		</tr>-->
		<tr> 
			<td width="196" align="center">가게 정보</td>
			<td width="346">
				<textarea 
				name="DETAIL_CONTENT" cols=50 rows=15></textarea>
			</td>
		</tr>
		<!-- <tr>
			<td>
			<p align="center"><font size=2>메인 음식이미지</font></p>
			</td>
			<td><input type="file" name="DETAIL_IMAGE"></td></tr>
			<tr>
			<td>
			<p align="center"><font size=2>음식이미지1</font></p>
			</td>
			<td><input type="file" name="DETAIL_IMAGE2"></td></tr>
			<tr>
			<td>
			<p align="center"><font size=2>음식이미지2</font></p>
			</td>
			<td><input type="file" name="DETAIL_IMAGE3"></td></tr> -->
		<tr>
			<td width="200" align="center">에디터 소감</td>
			<td width="350">
				<textarea 
				name="DETAIL_ADDTER" cols=50 rows=15></textarea>
			</td>
		</tr>
		<tr>
			<td height="75" align="center" colspan="2">
				<input type="submit" value="등록" name="detailform">
				<input type="reset" value="취소하기" onclick="javascript:history.go(-1)">
			</td>
		</tr>		
</table>
</form>		
</body>
</html>
	<jsp:include page="/page/footer.jsp"></jsp:include>