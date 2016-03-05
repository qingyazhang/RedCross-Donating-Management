<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<p href="/final/log_out">登出系统</p>
<p href="index_user.jsp">首页</p>
<p href="/final/queryDonate">捐款查询</p>
<p href="/final/queryAccept">捐赠查询</p>
<p href="/final/queryProvince">省份统计</p><br>
<h1>当前余额<% out.println(request.getSession().getAttribute("sum")); %></h1>
<div class="page-container">
    <h1>捐款查询</h1>
    <form action="/final/queryDonate.do" method="post">
             请输入姓名<input type="text" name="donateName" class="donateName" value="姓名" placeholder="请输入姓名">
   	 请输入起始日期<input type="date" name="donateBeginDate" class=donateBeginDate" placeholder="请输入起始日期">
             请输入截止日期<input type="date" class="donateEndDate" name="donateEndDate" placeholder="请输入截止日期">
    <button type="submit" class="submit_button">查询</button>
    </form>
</div>
<div class="page-container">
    <h1>捐赠查询</h1>
    <form action="/final/queryAccept.do" method="post">
             请输入姓名<input type="text" name="acceptName" class="acceptName" value="姓名" placeholder="请输入姓名">
   	 请输入起始日期<input type="date" name="acceptBeginDate" class="acceptBeginDate" placeholder="请输入起始日期">
             请输入截止日期<input type="date" class="acceptEndDate" name="acceptEndDate" placeholder="请输入截止日期">
    <button type="submit" class="submit_button">查询</button>
    </form>
</div>

<!-- Javascript -->

		
        <script src="assets/js/jquery-1.8.2.min.js" ></script>
        <script src="assets/js/supersized.3.2.7.min.js" ></script>
        <script src="assets/js/supersized-init.js" ></script>
        <script src="assets/js/scripts.js" ></script>
</body>
</html>