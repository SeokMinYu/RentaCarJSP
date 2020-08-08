<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>
<link rel="stylesheet" href="css/style.css" />
<style>
#container {
   margin : 0 auto;
   width : 600px;
   font-weight : bold;
   padding : 10px;
}
#submit1 {
   text-align : center;
   font-size : 25px;
}
h1 { text-align : center;}

input[type=button] {
	background : red;
	color : white;
	font-weight : bold;
	font-size : 20px;
	padding : 3px 10px;
}

</style>
<script>
	function validationCheck() {
		var commonForm = document.regForm;
		
		if (commonForm.user_id.value == "") {
			alert("아이디를 입력해 주세요.");
			commonForm.user_id.focus();
			return false;
		}else if (commonForm.user_password.value == "") {
			alert("비밀번호를 입력해 주세요.");
			commonForm.user_password.focus();
			return false;
		}else if (commonForm.user_password1.value == "") {
			alert("비밀번호를 입력해 주세요.");
			commonForm.user_password1.focus();
			return false;
		} else if (commonForm.user_password.value != commonForm.user_password1.value) {
			alert("패스워드가 맞지 않으니, 다시 확인바랍니다.");
			commonForm.user_password.select();
			return false;
		}
		
		commonForm.submit();
		
		
	}

</script>
</head>
<body>
<div id="container">
<h1>회원가입</h1>
<br>
<form name="regForm" action="memberRegistrationProc.jsp" method="post">
<table>  <!-- 7행 2열의 가단한 로그인 폼 -->
<tr><td style="text-align:center">아 이 디 :</td><td><input type="text" name="user_id" size="45" autofocus autocomplete="off"></td></tr>
<tr><td style="text-align:center">패스 워드:</td><td><input type="password" name="user_password" size="45"  autocomplete="off"></td></tr>
<tr><td style="text-align:center">패스워드 재입력:</td><td><input type="password" name="user_password1" size="45"  autocomplete="off"></td></tr>
<tr><td style="text-align:center">이&nbsp;&nbsp;&nbsp;름 :</td><td><input type="text" name="user_name" size="45"  autocomplete="off"></td></tr>
<tr><td style="text-align:center">성&nbsp;&nbsp;&nbsp;별 :</td><td><input name="user_gender" type="radio" value="male">남성
         &nbsp;&nbsp;<input name="user_gender" type="radio" value="female">남성</td></tr>
<tr><td style="text-align:center">E-mail:</td><td><input type="email" name="user_email" size="45" maxlength="30" placeholder="ooo@ooo.ooo형식으로 입력"></td></tr>
<tr><td style="text-align:center">전화번호:</td><td><input type="tel" name="user_phone" size="45" maxlength="11">
                         <span style="color:red; font-size:small;">주) - 없이 입력</span></td></tr>
<tr><td style="text-align:center">지&nbsp;&nbsp;&nbsp;역 :</td>
        <td><input type="radio" name="user_area" value="서울">서울
	    <input type="radio" name="user_area" value="경기">경기
		<input type="radio" name="user_area" value="강원">강원
		<input type="radio" name="user_area" value="충북">충북
		</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>
		<input type="radio" name="user_area" value="충남">충남
		<input type="radio" name="user_area" value="전북">전북
		<input type="radio" name="user_area" value="전남">전남
		<input type="radio" name="user_area" value="경북">경북
		</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>
		<input type="radio" name="user_area" value="경남">경남
		<input type="radio" name="user_area" value="제주">제주
		<input type="radio" name="user_area" value="그외">그외
		</td>
<tr><td style="text-align:center">비&nbsp;&nbsp;&nbsp;고:</td><td><textarea name="user_impress" cols="50" rows="4" maxlength="100" placeholder="100자 이내만 입력 가능함."></textarea></td></tr>
</table>

<p id="submit1"><input onclick="validationCheck()" type="button" value="가입하기"></p>
</form>
</div>

</body>
</html>