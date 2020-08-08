<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Process</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String realfolder = "";
	String savefolder = "/images";
	String encType = "utf-8";
	
	int maxSize = 1024*1024*10;
	
	ServletContext context = getServletContext();
	realfolder = context.getRealPath(savefolder);
	
	try{
		MultipartRequest multi = new MultipartRequest(request,realfolder,maxSize,encType,new DefaultFileRenamePolicy());
%>
	당신의 이름은 <%=multi.getParameter("name") %>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>