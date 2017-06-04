<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生考试编号</title>
<style type="text/css">
body{
	background:#e7e7e7;
}
#number{
	padding:15% 30% 30%  32%;
}
</style>
</head>
<body>
<form action="ExamById">
	<div id="number">
		<font size="5px">请输入考试编号:</font><br>
		<input type="text" name="examId" style="height:40px;width:250px;">
		<input type="submit" value="GO" style="color:blue;height:40px;width:100px;"> 
	</div>
</form>

</body>
</html>