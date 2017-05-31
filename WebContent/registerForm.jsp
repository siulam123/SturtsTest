<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<form action="register" method="post">
	<table>
		<caption><h3>User Register</h3></caption>
		<tr>
			<td>user_id:<br>
				<textarea name="user_id" rows="9" cols="70" style="max-width: 500px;"></textarea><br>
			</td>
		</tr>
		<tr>
			<td>user_name:<br>
			<textarea name="user_name" rows="9" cols="70" style="max-width: 500px;"></textarea><br>
			</td>
		</tr>
		<tr>
			<td>
				<select name="user_type">
		            <option selected="student" value="student">student</option>
		            <option value="teacher">teacher</option>
		            <option value="administrator">administrator</option>
	         	</select>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Login"/></td>
		</tr>
	</table>
	</form>
</body>
</html>