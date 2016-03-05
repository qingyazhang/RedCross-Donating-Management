<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>请登录</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- CSS -->
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>


<div class="page-container">
            <h1>登录(Login)</h1>
            <form action="/final/confirm" method="post">
            <input type="text" name="userID" class="userID" placeholder="请输入您的注册邮箱！">
            <input type="password" name="password" class="password" placeholder="请输入您的用户密码！">
            <input type="text" class="test" name="test" placeholder="请输入验证码！">
            <img id="testImage" name="testImage" src="/final/test"/>
    			  <a href="javascript: reload();">看不清楚</a><br>
            <button type="submit" class="submit_button">登录</button>
            </form>
 </div>

 <!-- Javascript -->
		 <script type="text/javascript">
		  		function reload(){
		  			var time = new Date().getTime();
		  			document.getElementById("testImage").src="/final/test?a="+time;
		  		}
		</script>
        <script src="assets/js/jquery-1.8.2.min.js" ></script>
        <script src="assets/js/supersized.3.2.7.min.js" ></script>
        <script src="assets/js/supersized-init.js" ></script>
        <script src="assets/js/scripts.js" ></script>

</body>
</html>