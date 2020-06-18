<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.food.qna.db.*" %>
<%
	QnaDTO qna = (QnaDTO)request.getAttribute("qnadata");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 수정페이지</title>
<script type="text/javascript">
	function modifyqna(){
		modifyform.submit();
	}
</script>
<style type="text/css">
	table, td, tr{
		border: 1px solid black;
		border-collapse: 0;
		border-spacing: 0;
	}
	table{
		margin-top:50px;
		margin-bottom:50px;
	}
</style>
</head>
<body>

<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>

<form action="QnaModifyAction.qn" method="post" name="modifyform">
<input type="hidden" name="QNA_NUM" value=<%=qna.getQNA_NUM() %>>
<table align = "center" cellpadding="0" cellspacing="0">
	<tr valign="middle">
		<td colspan="5">Q&A</td>
	</tr>
	<tr>
		<td>
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="QNA_SUBJECT" size="50" maxlength="100" 
				value="<%=qna.getQNA_SUBJECT()%>">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="QNA_CONTENT" cols="67" rows="15"><%=qna.getQNA_CONTENT() %></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="QNA_PASS" type="password">
		</td>
	</tr>
	<tr>
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<tr align="center" valign="middle">
		<td colspan="5" height="50px">
			<input type="button" value="수정" name="modifyform" onclick="javascript:modifyqna()">&nbsp;&nbsp;
			<input type="button" value="뒤로" name="modifyform" onclick="javascript:history.go(-1)">	
		</td>
	</tr>
	</tr>

</table>
</form>
<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>