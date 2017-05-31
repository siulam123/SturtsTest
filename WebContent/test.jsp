<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/JZExamSystem/test.action" method="post">
	  <input class="common login-btn" type="submit" value="Login"/>
</form>

<form action="/JZExamSystem/marking.action" method="post">
    <input class="common login-btn" type="submit" value="Login2"/>
    <input type="hidden" name="itemId" 	value="1" />
    <input type="hidden" name="Type"	value="blankfiling" />
    <input type="hidden" name="answer" 	value="运行中" />
    </form>
</body>
</html>