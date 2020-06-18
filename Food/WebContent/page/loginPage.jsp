<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>

<style type="text/css">
fieldset{
	border:5px solid ; width:400px; height:200px; margin-left:auto; margin-right:auto;	margin-top:100px; margin-bottom:100px;
}
div{
	margin-top:30px;
}
</style>

<script type="text/javascript">
	function openConfirmId(login){	
	var url="./MemberFind.gu";
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450px,height=300");
}

</script>
</head>
<body align ="center">

<jsp:include page="/page/header.jsp"></jsp:include>
	
	<form action="./MemberLoginAction.me" method="post" name="login">
		<fieldset >
			<legend  align="center" font-size="20pt">&nbsp&nbsp&nbsp&nbsp로그인&nbsp&nbsp&nbsp&nbsp</legend> 
				<div align="center">
					<label>아 이 디 : </label><input type="text" name="MEMBER_ID" /><br><br>
					<label>비밀번호 : </label><input type="password" name="MEMBER_PW" /><br><br>
					
					<input type="submit" value="로그인" name="login">
					<input type="button" value="회원가입" name ="join" onclick="javascript:window.location='./newmemberpage.gu'" >
					<input type="button" value="아이디/비밀번호 찾기" onclick="openConfirmId(this.form)">
				</div>		
		</fieldset>
			</form>
		 
	<jsp:include page="/page/footer.jsp"></jsp:include>

	</body>
</html>