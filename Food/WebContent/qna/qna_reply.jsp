<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.food.qna.db.QnaDTO" %>
<%
	QnaDTO qna=(QnaDTO)request.getAttribute("qnadata");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="javascript">
	function replyqna(){
		qnaform.submit();
	}
</script>
<style type="text/css">
	table, td, tr{
		border:1px solid black;
	}
	table{
		margin-top:50px;
		margin-bottom:50px;
	}
</style>

</head>
<body>
<jsp:include page="../page/header.jsp"></jsp:include>

<form action="./QnaReplyAction.qn" method="post" name="qnaform">
<input type="hidden" name="QNA_NUM" value="<%=qna.getQNA_NUM() %>"> <!-- 타입의 히든:화면상에는 보이지 않지만 전달하고 싶은 값이 있을때 히든을 사용. -->
<input type="hidden" name="QNA_RE_REF" value="<%=qna.getQNA_RE_REF() %>">
<input type="hidden" name="QNA_RE_LEV" value="<%=qna.getQNA_RE_LEV() %>">
<input type="hidden" name="QNA_RE_SEQ" value="<%=qna.getQNA_RE_SEQ() %>">

	<table align="center" cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">Q&A</td>
		</tr>
		<tr>
			<td>
				<div align="center">글쓴이</div>
			</td>
			<td>
				<input name="QNA_NAME" type="text"/>
			</td>
		</tr>
		<tr>
			<td style="font-family:돋음; font-size:12" height="16">
				<div align="center">제 목</div>
			</td>
			<td>
				<input name="QNA_SUBJECT" type="text" size="50" maxlength="100" value="Re: <%=qna.getQNA_SUBJECT() %>"/>
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">내 용</div>
			</td>
			<td>
				<textarea name="QNA_CONTENT" cols="67" rows="15"></textarea>
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
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr bgcolor="cccccc">
			<td colspan="2" style="height:1px;">
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr align="center" valign="middle">
			<td colspan="5" height="50px">
				<input type="button" value="등록" onclick="javascript:replyqna()">&nbsp&nbsp
				<input type="button" value="뒤로" onclick="javascript:history.go(-1)">
			</td>
		</tr>


	</table>
</form>
<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>