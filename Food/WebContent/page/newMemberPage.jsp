<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입양식</title>
<script src="./js/jquery-3.4.1.js"type="text/javascript"></script>
<script type="text/javascript">
function check(){
	
	var id=join.MEMBER_ID.value;
	var password1=join.MEMBER_PW.value;
	var password2=join.MEMBER_PWCK.value;	
	var phone=join.MEMBER_TEL.value;
	
	var forms = document.getElementById("join");

	if ((forms.MEMBER_NAME.value=="")||(forms.MEMBER_NAME.value.length<=1)){
		alert("이름을 제대로 입력해 주세요.");
		forms.MEMBER_NAME.focus();
         		return false;
	}
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		join.MEMBER_ID.focus();
		return false;
	}
	if(password1.length == 0){
		alert("비밀번호를 입력하세요.");
		join.MEMBER_PW.focus();
		return false;
	} 
	if(password1 != password2){
		alert("비밀번호가 일치하지 않습니다.");
		join.MEMBER_PW.value="";
		join.MEMBER_PWCK.value="";
		join.MEMBER_PW.focus();
		return false;
	}
	
	if(phone.length == 0){
		alert("전화번호를 입력하세요.");
		join.MEMBER_TEL.focus();
		return false;
	} 
	
}

function openConfirmId(join){			
	var id=join.MEMBER_ID.value;
	var url="./MemberIDCheckAction.me?MEMBER_ID="+join.MEMBER_ID.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		join.MEMBER_ID.focus();
		return false;
	}
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=400,height=200");
}

function checkPwd(){
	var inputed = $('#pw').val();
	var repeated = $('#pwck').val();
	
	if(inputed != repeated){
		$('#pwck').css("background-color", "#FFCECE");
	} else if (inputed == repeated) {
        $('#pwck').css("background-color", "#B0F6AC");
	}
	
function goback(){
	window.location='history.go(-1)';
}	
}
</script>
<style type="text/css">
fieldset{
	margin-left:auto;
	margin-right:auto;
	margin-top:30px;
	margin-bottom:30px;
	width:500px;
	hegiht:700px;
	
}


</style>
</head>
<body>
<jsp:include page="/page/header.jsp"></jsp:include>

	<form action="./MemberAddAction.me" method="post" id="join" name="join" onsubmit="return check()" >
		<fieldset>
			<legend align="center">회원가입 양식</legend>
				<label>이   름 :</label>
				<input type="text" name="MEMBER_NAME" id="name"  size="10" /><br><br>
				
		
				<label>아 이 디 :</label>
				<input type="text" name="MEMBER_ID" id="id" size="10" />
				<input type="button" name="idck" value="중복체크" onclick="openConfirmId(this.form)"><br><br>
				
				<label>비밀번호 :</label>
				<input type="password" name="MEMBER_PW" id="pw" size="20" /><br><br>
			
				<label>비밀번호 확인 :<label>
				<input type="password" name="MEMBER_PWCK" id="pwck" size="20" oninput="checkPwd()" />
				<br><br>
				
				<label>이 메 일 : <label>
				<input type="email" name="MEMBER_EMAIL" id="email" /><br><br>
				
				<label>전화번호 : <label>
				<input type="tel" name="MEMBER_TEL" id="tel" size="15" /><br><br>
				
				<span>
				<input type="submit" value="회원가입" name ="join" >
				<input type="button"  id="cancel" value="취소하기" name="cancel" onclick="javascript:history.go(-1)">
				</span>
			</fieldset>	
		



	</form>
	<jsp:include page="/page/footer.jsp"></jsp:include>
</body>
</html>