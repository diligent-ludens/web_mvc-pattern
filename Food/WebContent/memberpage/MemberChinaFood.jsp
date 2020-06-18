<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.detail.db.DetailBean" %>
<%@ page import="java.util.*" %>

<%
	List foodList = (List)request.getAttribute("foodlist");
	int listcount = ((Integer)request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer)request.getAttribute("page")).intValue();
	int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer)request.getAttribute("startpage")).intValue();
	int endpage = ((Integer)request.getAttribute("endpage")).intValue();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중식 카테고리</title>
<style type="text/css">
	
	#top{
		width:500px;
		clear:both;
		padding:5px;
	}
	
	#main{
		width:500px;
		clear:both;
		padding:5px;
		margin-left:auto; 
		margin-right:auto;
	}
	
	#sub{
		border:1px solid gray;
		border-collapse:collapse;
		height:200px;
		width:500px;
	}
	
	.photo{
		height:200px;
		width:200px;
	}
</style>

</head>
<body>
	
	<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>

	<h1 align="center">중식</h1>
	
	<table id="top" style="margin-left:auto; margin-right:auto;">
	
		<tr>
			<td>음식점 <b>${ listcount }</b>곳을 찾았습니다.</td>
			<!-- member 전용 -->
			<td><a href="./Detail/detail_write.jsp">맛집 등록</a></td>
		</tr>
	</table>
	
	<hr>
	<%
	if(listcount > 0){
	%>
	<%
		for(int i = 0; i < foodList.size(); i++){
			DetailBean fl = (DetailBean)foodList.get(i);
	%>

	<table id ="main">
		<tr>
			<td>
				<table id = "sub" border = "1">
					<tr>
						<td rowspan="2" class="photo">식당 사진</td>
						<td colspan="2"><a href="./DetailView.ag?num=<%=fl.getDETAIL_NUM()%>"><%= fl.getDETAIL_NAME() %></a></td>
					</tr>
					<tr>
						<td><img src="./images/like.png" width="50" height="50"></td>
						<td><%= fl.getDETAIL_ADDTER() %></td>
					</tr>
				</table>
			</td>
		</tr>
	
	<%
		}
	%>
	</table>
	
	<table style="margin-left:auto; margin-right:auto;">
		<tr align=center height=20>
			<td style=font-family:Tahoma;font-size:10pt;>
				<%if(nowpage<=1){ %>
				[이전]&nbsp;
				<%}else{ %>
				<a href="./MemberChinaFood.me?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int a=startpage;a<=endpage;a++){
					if(a==nowpage){%>
					[<%=a %>]
					<%}else{ %>
					<a href="./MemberChinaFood.me?page=<%=a %>">[<%=a %>]</a>&nbsp;
					<%} %>
				<%} %>
				
				<%if(nowpage>=maxpage){ %>
				[다음]
				<%}else{ %>
				<a href="./MemberChinaFood.me?page=<%=nowpage+1 %>">[다음]</a>
				<%} %>
			</td>
		</tr>
		<%
	    }
		else
		{
		%>
		<tr align="center" valign="middle">
			<td align=right>
				<font size=2>등록된 글이 없습니다.</font>
			</td>
		</tr>
		<%
		}
		%>
	</table>
		
	<jsp:include page="/page/footer.jsp"></jsp:include>

</body>
</html>