<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">
	h1{
		text-align: center;
		margin-top: 30px;
	}
	th{
		width:70px;
	}
	
	td{
		width:200px;
	}
	table{margin-bottom:30px;}
</style>


</head>
<body>

	<jsp:include page="/page/header.jsp"></jsp:include>
	
	<h1>MYPAGE</h1>
	<table align="center" width="300px" height="300px">
			<tr>
				<th>이름</th>
				<td><input type="text"  id="name" name="name" size ="20"/></td>
				
			</tr>
			<tr>
				<th >아이디</th>
				<td><input type="text"  id="id" name="id"/></td>
			</tr>
			<tr>
				<th >비밀번호</th>
				<td><input type="text"  id="pw" name="pw"/></td>
			</tr>	
			<tr>
				<th >이메일	</th>
				<td><input type="text"  id="email" name="email"/></td>
			</tr>		
			<tr>
				<th >전화번호 </th>
				<td><input type="text"  id="phonenum" name="phonenum"/></td>
			</tr>	
			<tr>
				<td colspan="2" align="center"><input type="submit"  id="submit" value="수정하기" name="submit"/>&nbsp&nbsp&nbsp&nbsp
				<input type="reset"  id="reset" value="취소하기" name="submit"/>
				
			</tr>
		</table>
		
		<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>