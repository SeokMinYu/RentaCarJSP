<%@page import="model.MemberDAO1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리...</title>
</head>
<body>


<%
	//한글 깨짐 방지
	request.setCharacterEncoding("utf-8");
	String [] user_area = request.getParameterValues("user_area");
	String area=""; //체크박스 내용을 문자열로 저장
	for (int i=0; i < user_area.length; i++){
		area += user_area[i] + " ";
	}
	
%>

<!-- 파라미터의 갯수가 다를 경우에는 동일한 이름의 bean 객체 변수에 전달됨.  나머지는 버려짐-->
<!-- 여기서는 MemberBean 객체명으로 bean을 사용함. -->
<jsp:useBean id="bean" class="model.MemberBean"  />
<jsp:setProperty property="*" name="bean"/>

<%
	bean.setUser_area(area);
	//회원 가입 정보를 DB에 저장
	MemberDAO1 dao = new MemberDAO1();
	dao.insertOneMember(bean);

%>

<h2>회원 가입을 완료하였습니다.</h2>
<p><a href="index.jsp" style="font-size:20px;">메인 홈페이지로 가기</a><br>
<a href="index.jsp?Center=loginForm.jsp" style="font-size:20px;">로그인페이지로 가기</a><br>
</p>

</body>
</html>