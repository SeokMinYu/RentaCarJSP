<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드 실습</title>
<style>
body{
	text-align: center;
	background-color: wirte;
}
.tdscroll{
	width: 300px;
	height: 80px;
	overflow-y: scroll;
}
.buttonSize{
	background-color: #0171F9;
	font-size: 20px;
	color: white;
}
table{
	margin-top: 50px;
	border-collapse: collapse;
}
td{
	height: 20px;
	padding: 10px;
	padding-right: 50px;
	font-size: 20px;
	background-color: #F4F1CF;
}
.td1{
	padding-left: 80px;
	font-weight: 800;
}

</style>
</head>
<body>
<h1>파일 업로드</h1>
<form action="fileUploadProc.jsp" method="post" enctype="multipart/form-data">
<table>
<tr>
	<td class="td1">자동차명</td><td><input type="text" name="name" size="40"></td>
</tr>
<tr>
<td class="td1">회사</td><td><input type="text" name="company" size="40"></td>
</tr>
<tr>
<td class="td1">차종</td><td><input type="text" name="category" size="40"></td>
</tr>
<tr>
<tr>
<td class="td1">탑승인원</td><td><input type="text" name="passengers" size="40"></td>
</tr>
<tr>
<td class="td1">연료</td><td><input class="text" name="fuel" size="40"></td>
</tr>
<tr>
<td class="td1">배기량</td><td><input type="text" name="cc" size="40"></td>
</tr>
<tr>
<td class="td1">가격</td><td><input type="text" name="price " size="40"></td>
</tr>
<tr>
<td class="td1">상품이미지</td><td><input type="file" name="imgfile"></td>
</tr>
<tr>
<td class="td1">설명서</td><td><textarea class="tdscroll" name="info"></textarea></td>
</tr>
<tr>
	<td></td><td><br><input class="buttonSize" type="submit" value="등록"></td>
</tr>
</table>
</form>
</body>
</html>