<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.food.member.db.MemberBean" %>    
<%
	List<MemberBean> memberList=(List<MemberBean>)request.getAttribute("memberlist");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">  
   
   
   fieldset{
   margin-left:auto;
   margin-right:auto;
   margin-top:30px;
   margin-bottom:30px;
   width:500px;
   hegiht:700px;
   border:5px solid ;
   }
   
   legend{
   font-size: 20pt ;
   font-weight: bold; 
   }
   

</style>




</head>
<body>

	<jsp:include page="/memberpage/MemberHeader.jsp"></jsp:include>
	<%
		
	MemberBean me =(MemberBean)memberList.get(0);
	%>	
	
	
	<fieldset>   
   <legend align="center" >&nbsp&nbsp&nbsp&nbspMYPAGE&nbsp&nbsp&nbsp&nbsp</legend>   
      <table align="center" width="300px" height="300px">
         <tr>
            <th>이름</th>
            <td><input type="text"  id="name" name="name" size ="20"  value="<%= me.getMEMBER_NAME()%>"/></td>
            
         </tr>
         <tr>
            <th >아이디</th>
            <td><input type="text"  id="id" name="id" value="<%= me.getMEMBER_ID()%>"/></td>
         </tr>
         <tr>
            <th >이메일   </th>
            <td><input type="text"  id="email" name="email" value="<%= me.getMEMBER_EMAIL()%>"/></td>
         </tr>      
         <tr>
            <th >전화번호 </th>
            <td><input type="text"  id="phonenum" name="phonenum" value="<%= me.getMEMBER_TEL()%>"/></td>
         </tr>   
         <tr>
            <td colspan="2" align="center"><input type="submit"  id="submit" value="수정하기" name="submit"/>&nbsp&nbsp&nbsp&nbsp
            <input type="button"  id="reset" value="뒤로가기" name="submit" onclick="javascript:history.go(-1)"/>
            
         </tr>	
      </table>
</fieldset>     
		
		<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>