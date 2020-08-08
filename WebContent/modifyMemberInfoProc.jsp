<%@page import="model.MemberDAO1"%>
<%@page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정 </title>
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

input[type=button], input[type=submit] {
	background : red;
	color : white;
	font-weight : bold;
	font-size : 20px;
	padding : 3px 10px;
}
td{
	padding : 10px;
}

</style>
</head>
<body>
<%
	String user_id = request.getParameter("user_id");
	String user_password = request.getParameter("user_password");
	
	MemberDAO1 dao = new MemberDAO1();
	
	//bean = loginQuery(String id);
	MemberBean bean = dao.loginQuery(user_id);
	
	//패스워드의 일치 여부 확인(아이디나 패스워드가 일치하지 않으면 다시 시작하도록 함.)
	if (!user_id.equals(bean.getUser_id())) { %>
		<script>
		alert('아이디가 일치하지 않습니다.');
		location.href = "index.jsp?Center=modifyMemberInfo.jsp";
		</script>
	<% }
	else if (!user_password.equals(bean.getUser_password())){%>
		<script>
		alert('패스워드가 일치하지 않습니다.');
		location.href = "index.jsp?Center=modifyMemberInfo.jsp";
		</script>
	<%}
%>
<!-- 정보 수정을 위한 내용을 디스플레이하기 -->

<div id="container" align="center">
<h1>회원정보 수정</h1>
<br>
<!-- 편의상 일부 field만을 변경한다고 가정하자.  -->
<!-- 패스워드(널을입력하지 않는다 가정), 이메일, 전화번호 및 취미의 재설정만 가능하다고 하자. -->
<!-- 유효성 체크를 생략하기 위해 널을 입력하지 않는다고 가정하자.  -->
<form name="regForm" action="index.jsp?Center=modifyMemberInfoProcExec.jsp" method="post">
<table>  <!-- 7행 2열의 가단한 로그인 폼 -->
<tr><td style="text-align:center">아 이 디 :</td><td>&nbsp; <%=bean.getUser_id() %> </td></tr>
<tr><td style="text-align:center">패스 워드:</td><td><input type="password" name="user_password" size="30"  value="<%=bean.getUser_password() %>"></td></tr>
<tr><td style="text-align:center">이&nbsp;&nbsp;&nbsp;름 :</td><td>&nbsp; <%=bean.getUser_name() %> </td></tr>
<tr><td style="text-align:center">성&nbsp;&nbsp;&nbsp;별 :</td><td>&nbsp; <%=bean.getUser_gender() %></td></tr>
<tr><td style="text-align:center">E-mail:</td><td><input type="email" name="user_email" size="30" maxlength="30" value="<%=bean.getUser_email() %>"></td></tr>
<tr><td style="text-align:center">전화번호:</td><td><input type="tel" name="user_phone" size="11" maxlength="11" value="<%=bean.getUser_phone() %>">
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
	<span style="color:red; font-size:small;"> 주) 재설정</span></td>
	</tr>
</table>
<input type="hidden" name="user_id" value="<%=bean.getUser_id() %>"><!-- DB 접속을 위해 변경하지 않는 고정값을 사용할 필요가 있음.  -->
<p id="submit1"><input type="submit" value="수정하기"> &nbsp;&nbsp;&nbsp;<input type="button" onclick="cancleModify()" value="수정 취소하기"></p>
</form>
</div>

<script>
	function cancleModify() {
		alert("정보 수정을 취소하고, 메인 홈으로 이동합니다.");
		location.href = "index.jsp";
		
	}

</script>
</body>
</html>