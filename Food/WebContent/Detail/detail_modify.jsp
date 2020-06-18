<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="net.detail.db.*"%>
<%
	DetailBean agb=(DetailBean)request.getAttribute("agb");
%>

<!DOCTYPE html>
<html>
<head>
<title>맛집 수정 페이지</title>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
</script>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	bordercolor="gray" align="center">
<tr>
	<td colspan=2>
	<table border="0" width="80%">
	<form name="modifyform" action="./DetailModifyAction.ag">
	<input type="hidden" name="DETAIL_NUM" value=<%=agb.getDETAIL_NUM() %>>
	<tr>
		<td>
		<p align="center"><span style="font-size: 26pt;">맛 집 수 정</span></p>
		</td>
	</tr>
		
	<tr>
		<td height="331">
		<table border="1" align="center" width="558">
		<tr>
			<td width="196" height="30">
			<p align="center"><font size=2>카테고리</font></p>
			</td>
			
			<td width="346" height="30">
			<select name="DETAIL_CATEGORY" size="1" 
					value=<%=agb.getDETAIL_CATEGORY() %>>
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="양식">양식</option>
				<option value="분식">분식</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>
			<p align="center"><font size=2>가게 이름</font></p>
			</td>
			<td><input type="text" name="DETAIL_NAME" 
					value=<%=agb.getDETAIL_NAME() %>></td>
		</tr>
		<%-- <tr>
			<td>
			<p align="center"><font size=2>위치</font></p>
			</td>
			<td><input type="text" name="dti_location" 
					value=<%=agb.getDETAIL_LOCATION() %>></td>
		</tr> --%>
		<tr>
			<td width="196">
			<p align="center"><font size=2>가게 정보</font></p>
			</td>
			<td width="346">
				<textarea name="DETAIL_CONTENT" cols=50 rows=15><%=agb.getDETAIL_CONTENT() %></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<p align="center"><font size=2>에디터 소감</font></p>
			</td>
			<td><input type="text" name="DETAIL_ADDTER" 
					value=<%=agb.getDETAIL_ADDTER() %>></td>
		</tr>
			</table>
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td height="75">
			<a href="javascript:modifyboard()">[수정]</a>&nbsp; &nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
	</form>
	</table>
	</td>
</tr>
</table>
</body>
</html>
