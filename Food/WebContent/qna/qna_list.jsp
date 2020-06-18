<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.food.qna.db.QnaDTO" %>

<%
	List<QnaDTO> qnaList=(List<QnaDTO>)request.getAttribute("qnalist");
	int listcount= ((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
<style type="text/css">
	nav{height:700px;}
	table{
		width:1000px;
		border-collapse:0;
		margin-top:30px;
		margin-bottom:30px;
	}
	table, tr, th, td{
		border:1px solid #e6aabb;
		border-collapse:0;
		border-spacing: 0;
	}
</style>
</head>
<body>
	<jsp:include page="../page/header.jsp"></jsp:include>
	
	<nav>
	<h3 align="center">Q&A</h3>
	<table align="center">
		<tr align="right">
			<td colspan="5">
	   			<font size=2>글 개수 : ${listcount }</font>
			</td>
		</tr>
	
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

<%
if(listcount > 0){
%>
	
	<%
		for(int i=0; i < qnaList.size();i++){
			QnaDTO bl=(QnaDTO)qnaList.get(i);
	%>	
		<tr>
			<td>
				<%=bl.getQNA_NUM()%>
			</td>
			<td>
			<div align="left">
			<%if(bl.getQNA_RE_LEV()!=0){ %>
				<%for(int a=0;a<=bl.getQNA_RE_LEV()*2;a++){ %>
				&nbsp;
				<%} %>
				▶
			<%}else{ %>
				▶
			<%} %>
			<a href="./QnaDetailAction.qn?num=<%=bl.getQNA_NUM()%>">
				<%=bl.getQNA_SUBJECT()%>
			</a>
			</div>
			</td>
			<td>
			<div align="center"><%=bl.getQNA_NAME() %></div>
			</td>
			<td>
			<div align="center"><%=bl.getQNA_DATE() %></div>
			</td>
			<td>
			<div align="center"><%=bl.getQNA_READCOUNT() %></div>
			</td>
		</tr>
	<%} %>
		<tr>
			<td colspan="5" align="center">
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./MemberQnaList.me?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./MemberQnaList.me?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %>
			<a href="./MemberQnaList.me?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	
<% }else{%>

	<tr>
			<td colspan="5" align="center">등록된 글이 없습니다.</td>
			
		</tr>
		
<%
	}
%>
	<tr align="right">
		<td colspan="5">
	   		<a href="./qnawrite.qn">[글쓰기]</a>
		</td>
	</tr>
	
	</table>
	</nav>

	<jsp:include page="../page/footer.jsp"></jsp:include>
</body>
</html>