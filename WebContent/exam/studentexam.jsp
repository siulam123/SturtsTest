<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生考试页面</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
body{
	background: #ddd;
}
ul{
	list-style: none;
}
a{
	text-decoration: none;
}
.nav{
	background: #fff;
	width: 100%;
	height: 100px;
	font-size: 20px;
	line-height: 100px;
	text-align: center;
	border-bottom: 1px solid #f60;
}
.box{
	margin: 15px 15px;
	width: 1200px;
}
.fl_l{
	width: 200px;
	float: left;
	border: 1px solid #f4f4f4;
	background: #fff;
}
.fl_l li a{
	border-bottom: 1px solid #eee;
	text-align: center;
	display: block;
	color: #333;
	font-size: 14px;
	line-height: 60px;
}
.fl_l li.active a{
	background: #f60;
	color: #fff;
}

.fl_r li{
	margin-bottom: 30px;
	background: #fff;
	font-size: 50px;
	line-height: 300px;
	display: block;
	text-align: center;
}
</style>

</head>
<body>
<div class="nav">nav</div>
<div class="box">
	<ul class="fl_r">
		<li style="height: 600px;">菜单1内容</li>
		<li style="height: 600px;">菜单2内容</li>

	</ul>
	<div style="clear: both;"></div>
</div>

</html>

