<%@page import="model.carBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.carDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div align="center" style="width:1200px;">
<%
	request.setCharacterEncoding("utf-8"); 
	String category1 = request.getParameter("category");
%>
<h2 style="color : indigo; ">렌트중인 <%=category1 %> 차량 살펴보기</h2>
<table style="width:1200px">
<%
	carDAO cdao = new carDAO();
	//DB로부터 읽어와 넘겨받음.
	Vector<carBean> vec = cdao.getCarCategory(category1);
	
	//한 행당 4개씩 출력하도록 테이블 코딩
	int j=0;
	for (int i=0; i < vec.size(); i++) {
		carBean bean = vec.get(i); 
		if (j%4 == 0) {
%>
	<tr height="300">
<% } %>	
	<td width="250" align="center">
	<a href="index.jsp?Center=carReserveInfo.jsp&no=<%= bean.getNo()%>">
	<img src="images/<%=bean.getImgfile() %>" width="240" height="240">
	</a>
	<p>차량명 : <%=bean.getName() %> <br>차량가격 : <%=bean.getPrice() %>만원</p>  
	</td>
	
<% 
	j = j+1;
	} %>

</table>
<hr color="skyblue" size="3" >
<h2>차량 검색하기</h2>
<!-- Center 파라미터를 hidden 타입으로 선언하여 전송시 보냄.  -->
<form action="index.jsp" method="post">
	<b>차량검색하기 </b>&nbsp;&nbsp;
	<input type="hidden" name="Center" value="carCategoryList.jsp">
	<select name="category">
		<option value="소형">소형</option>
		<option value="준중형">준중형</option>
		<option value="중형">중형</option>
		<option value="준대형">준대형</option>
		<option value="suv">SUV</option>	
	</select>&nbsp;&nbsp;
	<input type="submit" value="유형별 검색" style="background : red; color:white; font-weight:bold;"> 
</form>
<br>
<button onclick="location.href='index.jsp?Center=allCarList.jsp'" style="background : red; color:white; font-weight:bold;">모든차량보기</button>
</div>
</body>
</html>