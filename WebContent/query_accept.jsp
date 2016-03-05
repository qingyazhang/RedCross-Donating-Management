<%@ page language="java" import="java.util.*,com.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>捐赠查询</title>
</head>
<body>
<%
	ArrayList<accept> arr = (ArrayList<accept>) request.getAttribute("acceptDetail");
	out.print(arr.size());
%>
</body>
</html>