<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인회원정보수정사이트</title>
<style>
#loginform {
     width : 360px;
	 margin : 0 auto;
	 font-weight : bold;
	 font-size : 20px;
	 padding : 10px;
	 margin-top : 100px;
	 }
h1 {color : Blue;	 
input{
    font-size : 18px;
	line-height : 25px;
}
button {
    font-size : 18px;
}
</style>
</head>
<body>
<div id="loginform">
<h1 style="text-align : center">로그인 확인</h1>
<br/>
<form action="modifyMemberInfoProc.jsp" method="post" >
  <fieldset >  <!-- style="border-color:red"  : 이것은 둘레 선의 색을 지정함-->
    <legend align="center" style="font-size:20px">login</legend>
	<br/>
    <label>- 아이디(ID): <input type="text" name="user_id" size="20" autocomplete="off" required></label><br><br/>
    <label>- 비밀 번호 : <input type="password" name="user_password" size="20"  autocomplete="off" required><label>
    <br><br>
    <center><button type="submit" ><strong>확인</strong></button>
	<button type="reset" ><strong>초기화</strong></button>
	</center>
  </fieldset>
</form>
</div>
</body>
</html>