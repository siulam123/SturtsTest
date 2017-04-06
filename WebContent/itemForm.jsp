<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Form</title>
</head>
<body>
	<form action="ItemAdd" method="post" id="usrform">
	<table>
		<caption><h3>User Login</h3></caption>
		<tr>
			<td>题目:<textarea name="Content" form="usrform">请在此处输入文本...</textarea> </td>
		</tr>
		<tr>
			<td>类型:<input type="text" name = "Type"/></td>
		</tr>
		<tr>
			<td>问题:<input type="text" name = "answer"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Login"/></td>
		</tr>
	</table>
	</form>
</body>
</html>