<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div>  
    请输入用户：  
    </div>  
    <div>  
        <form id="subUserForm">  
        <input type="text" name="userInfo.id" id="id"/>  
        <input type="text" name="userInfo.name" id="name"/>  
        </form>  
    </div>  
    <div>  
        <input id="addUser" type="button" value="添加"/>  
         <input id="users" type="button" value="所有用户"/>  
         <a href="/test/load_allUser_jump.action">所有用户：非异步方式</a>  
         <input id="msg" type="button" value="hello"/>  
         <input id="msgUserInfo" type="button" value="userInfo"/>  
         <input id="msgUserInfoList" type="button" value="userInfoList"/>  
    </div>  
<div id="allUser">  
input_user:  
</div>  
</body>
</html>