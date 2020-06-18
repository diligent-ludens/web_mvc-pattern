<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="net.detail.db.DetailBean"%>

<%
	List<DetailBean> list = (List<DetailBean>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<title>상품 리스트 페이지</title>
<style type="text/css">
	table{
		width:80%;
		margin-top:50px;
		margin-bottom:50px;
		text-align: center;
	}
	table, tr, td{
		border:1px solid black;
		border-collapse: 0;
		border-spacing:0;
	}
	nav{height:700px;}
</style>
</head>
<body>
	<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>
	
	<nav>
		<table align="center">
			<tr >
				<td align="center"colspan="5">가게목록</td>
			</tr>
			<tr >
				<td align="right"colspan="5"><a href="./DetailAdd.ag">가게 등록</a></td>
			</tr>			
			<tr>
				<td width="50">번호</td>
				<td width="141">카테고리</td>
				<td width="50">사진</td>
				<td width="100">가게명</td>
				<td width="141">정보</td>			
			</tr>
			<%
				for(int i = 0; i < list.size(); i++) {
					DetailBean agb = (DetailBean)list.get(i);
			%>
			<tr height = "100px">
				<td>	<%=agb.getDETAIL_NUM()%></td>
				<td><%=agb.getDETAIL_CATEGORY()%></td>
				<td>사진</td>
				<td><%=agb.getDETAIL_NAME()%></td>
				<td><%=agb.getDETAIL_ADDTER()%></td>
			</tr>
			<%}%>
			<tr>
			<td colspan="5" align="center">
				<a href="#">수정</a>&nbsp&nbsp
				<a href="#">삭제</a>
			</td>
			</tr>
			
			
		</table>
	</nav>
		<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>
