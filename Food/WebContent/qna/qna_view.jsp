<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.food.qna.db.QnaDTO" %>
<%
	QnaDTO qna = (QnaDTO)request.getAttribute("qnadata");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td{
		border:1px solid black;
	}
	table{
		margin-top:50px;
		margin-bottom:50px;
	}
</style>
<script type="text/javascript">
	function deleteAction(){
		
		var url = "./QnaDelete.qn?num=<%=qna.getQNA_NUM() %>";
		
		open(url, "", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=400,height=200");
		
	}
</script>
</head>
<body>

<jsp:include page="/page/header.jsp"></jsp:include>

<table  align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">Q&A</td>
	</tr>
	<tr>
		<td>
			<div align="center">제 목&nbsp;&nbsp;</div>
		</td>
		<td width="520">
		<%=qna.getQNA_SUBJECT()%>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12" >
			<table border=0 width=490 height=250 style="table-layout:fixed" align="center">
				<tr>
					<td valign=top style="font-family:돋음; font-size:12">
					<%=qna.getQNA_CONTENT() %>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle" height="50px">
		<td colspan="5">
			
			<input type="button" value="답변" onclick="window.location='./QnaReplyView.qn?num=<%=qna.getQNA_NUM() %>'">&nbsp&nbsp
			<input type="button" value="수정" onclick="window.location='./QnaModify.qn?num=<%=qna.getQNA_NUM() %>'">&nbsp&nbsp
			<input type="button" value="삭제" onclick="deleteAction()">&nbsp&nbsp
			<input type="button" value="목록" onclick="window.location='./qnalist.qn'">&nbsp&nbsp
			
		</td>
	</tr>




</table>

<jsp:include page="/page/footer.jsp"></jsp:include>

</body>
</html>