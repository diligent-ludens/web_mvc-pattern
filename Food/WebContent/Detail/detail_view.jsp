<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*"%>
<%-- <%@ page import="java.text.SimpleDateFormat" %> --%>
<%@ page import="net.detail.db.DetailBean"%>

<% 
	DetailBean detailBean = (DetailBean)request.getAttribute("detailBean");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식점 이름 메인 페이지</title>


<style type="text/css">	
	table, td, tr{
		border:1px solid black;
		border-collapse: 0;
		border-spacing: 0;
	}
	nav{
		margin-bottom:50px;
	}
	
</style>
</head>
<body>

<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>

	<table>
		<tr>
			<h1 align="center"><%=detailBean.getDETAIL_NAME() %></h1>
		</tr>
	</table>
	<nav>
	<table width = "600px" height = "500px" align="center" >
		<tr>
		<td style="font-family:돋음; font-size:12" height="16" width="200px">
			<div align="center">카테고리</div>
		</td>
		<td>
			<div align="center"><%= detailBean.getDETAIL_CATEGORY() %></div>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">설명</div>
		</td>
		<td>
			<div align="center"><%=detailBean.getDETAIL_CONTENT() %></div>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">에디터의 한마디</div>
		</td>
		<td>
			<div align="center"><%=detailBean.getDETAIL_ADDTER() %></div>
		</td>
	</tr>
	
		<!-- <tr align="center">
			<div>
				<td align="center"  >지도</td>
					<td colspan="2" style="height:1px;" style ="wight:100px;">가게 정보</td>
				</div>	
			</tr>
				<tr>
					<td id="map" style="width:500px;height:1080px;">
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce46efa64f17ade739b71d185e1ae0e3"></script>
					<script>
					var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
					var options = { //지도를 생성할 때 필요한 기본 옵션
						center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
						level: 3 //지도의 레벨(확대, 축소 정도)
					};

					var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
					</script>
					</td>			
				<div id="information">
					<td align="center" colspan="2" style="height:1080px;" style ="wight:100px;">가게 정보 링크 들어감</td>
				</div>
			</tr> -->
		
		<tr align="center" valign="middle" height="50px">
		<td colspan="5">
			<input type="button" value="수정" onclick="window.location='./DetailModify.ag?num=<%=detailBean.getDETAIL_NUM() %>'">&nbsp&nbsp&nbsp
			<input type="button" value="삭제" onclick="window.location='./DetailDelete.ag?num=<%=detailBean.getDETAIL_NUM() %>'">&nbsp&nbsp&nbsp
			<input type="button" value="뒤로가기" onclick="history.back(-1);">
		</td>
	</tr>
		
		</table>	
</nav>
		<jsp:include page="/page/footer.jsp"></jsp:include>
	

</body>
</html>