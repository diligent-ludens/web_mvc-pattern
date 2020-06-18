<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>

<script language="javascript">
		function addqna(){
			qnaform.submit();
		}
</script>

<style type="text/css">

	table, tr, td{border:1px solid #e6aabb;}
	
	table{
		width:750px; 
		height: 600px;
		margin-top:50px;
		margin-bottom:50px;
	}
	
	
	input{margin-left:2px;}
	
	#topbox{ height: 50px;}
	
	#mibox
	div{width:100px;}
</style>

</head>
<body>

<form action="./qnaaddaction.qn" method="post" name="qnaform">
	
	<jsp:include page="/page/header.jsp"></jsp:include>
		
		<table cellpadding="0" cellspacing="0" align="center">
			<tr align="center"  id="topbox">
				<td  colspan="2" >Q&A</td>
			</tr>
			<tr>
				<td width="200px" height="16px" align="center">글쓴이</td>
				<td>
					<input name="QNA_NAME" type="text" size="10" maxlength="10" value=""/>
				</td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12" height="16">
					<div align="center">비밀번호</div>
				</td>
				<td>
					<input name="QNA_PASS" type="password" size="10" maxlength="10" value=""/>
				</td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12" height="16">
					<div align="center">제 목</div>
				</td>
				<td>
					<input name="QNA_SUBJECT" type="text" size="50" maxlength="100" value=""/>
				</td>
			</tr>
			<tr id="midbox" style="height: 200px">
				<td style="font-family:돋음; font-size:12">
					<div align="center">내 용</div>
				</td>
				<td>
					<textarea name="QNA_CONTENT" cols="60" rows="15"></textarea>
				</td>
			</tr>
			
			<tr align="center" valign="middle">
				<td colspan="5" height="50px">
					<input type="button" value="등록" onclick="javascript:addqna()">&nbsp&nbsp
					<input type="button" value="뒤로" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
</form>
<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>