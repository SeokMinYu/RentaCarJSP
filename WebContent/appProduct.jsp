<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품등록</title>
<style>
.header{
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 100px;
	font-size: 20px;
	background-color: #363679;
	color: white;	
}
.nav{
	padding-top: 40px;
	padding-bottom: 40px;
	padding-left: 100px;
	background-color: #DDDDE5;
	color: #363679;
	font-size: 50px;
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
<div class="header">Home</div>
<div class="nav">상품 등록</div>
<table align="center">
<tr>
<td class="td1">상품코드</td><td><input type="text" name="codeNum" size="40"></td>
</tr>
<tr>
<td class="td1">상품명</td><td><input type="text" name="productName" size="40"></td>
</tr>
<tr>
<td class="td1">가격</td><td><input type="text" name="price" size="40"></td>
</tr>
<tr>
<td class="td1">상세정보</td><td><textarea class="tdscroll" name="explain"></textarea></td>
</tr>
<tr>
<td class="td1">제조사</td><td><input type="text" name="manufacturer" size="40"></td>
</tr>
<tr>
<td class="td1">분류</td><td><input type="text" name="classified " size="40"></td>
</tr>
<tr>
<td class="td1">재고 수</td><td><input type="text" name="stockNum" size="40"></td>
</tr>
<tr>
<td class="td1">상태</td><td>새상품<input type="radio" name="condition" value="newProduct">
			&nbsp;&nbsp;전시상품<input type="radio" name="condition" value="dispalyProduct">
			&nbsp;&nbsp;중고상품<input type="radio" name="condition" value="usedProduct"></td>
</tr>
<tr>
<td class="td1">등록 날짜</td><td><input type="date" name="codeNum" value=""></td>
</tr>
<tr>
<td class="td1">상품이미지</td><td><input type="file" name="productImages"></td>
</tr>
<tr>
	<td></td><td><br><input class="buttonSize" type="submit" value="등록"></td>
</tr>
</table>
</body>
</html>