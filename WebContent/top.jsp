<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.top {
	width : 1200px;
	height : 170px;
	position : relative;
}
table.nav {
	width : 1200px;
	height : 25px;
	font-weight : bold;
	font-size : 20px;
	margin-top : 20px;	
}
.nav td {
	text-align : center;
	height : 25px;
	padding : 4px 0px;
	border-left : 1px solid white;
}


.nav td:hover {
 	background : white;
 }
.nav a {
	text-decoration : none;
	color : blue;
	font-weight : bold;
}
.log {
	text-decoration : none;
	color : indigo;
}
.log:hover{
	color : olivedrab;
}
table.index {
	margin-top : 50px;
	text-align : center;
	margin-bottom : 50px;
	font-size : 2.5em;
}
.index td {
	text-align : center;
	height : 25px;
	padding : 4px 0px;
	border-left : 1px solid white;
}
.index td:hover {
 	background : white;
 }
 .index a {
	text-decoration : none;
	color : blue;
	font-weight : bold;
}
</style>
</head>
<body>
<%
  //세션을 이용한 로그인 처리
  String id = (String)session.getAttribute("user_name");
  //로그인이 되어있지 않다면,...
  if (id==null) {
	  id ="GUEST";
  }
%>
<table class="index">
 <tr><td><a href="index.jsp" id="topIcon">YSM Rent-A-Car</a></td></tr></table>
<div class="top">
 <div style="text-align:right; margin-right : 15px;">
 <span style="color:red;"><%=id %>님! 반갑습니다! </span>&nbsp;&nbsp;
 <%
 	if (id.equals("GUEST")) { %>
 		<button onclick="location.href='index.jsp?Center=loginForm.jsp'">로그인 </button>
 		| <button onclick="location.href='index.jsp?Center=memberRegistration.jsp'">회원가입 </button>
 <% }
	 else { %>
  		<button onclick="location.href='logout.jsp'">로그아웃 </button> |
		<button onclick="location.href='index.jsp?Center=modifyMemberInfo.jsp'">회원정보수정 </button>
	<% } %>
</div>	
 <table class="nav">
 <tr><td><a href="index.jsp?Center=carReserveMain.jsp">예 약 하 기</a></td>
 <td><a href="index.jsp?Center=carReserveCheck.jsp">예 약 확 인</a></td>
 <td>
 	<a href="index.jsp?Center=carUploadForm.jsp">차량등록하기</a>
 </td>
 <td>
 <a href="#">고객센터</a></td></tr>
 </table>

</div>
</body>
</html>