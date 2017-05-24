<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>老师</title>
<link href="css/reachergrade.css" rel="stylesheet" type="text/css" />
<link href="css/ks.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
            showUnreadSysMsgCount();

            $("#my").show();
    		$("#grade").hide();
    		$("#password").hide();
            $("#manageexam").hide();
    		$("#manageitemsearch").hide();
    		$("#searchgrade").hide();
        });
	
        //我的信息头部选项卡
        function setStudMsgHeadTabCheck() {
            var currentUrl = window.location.href;
            currentUrl = currentUrl.toLowerCase();
            var asmhm = "";
            $("#ulStudMsgHeadTab li").each(function () {
                asmhm = $(this).find('a').attr("href").toLowerCase();
                if (currentUrl.indexOf(asmhm) > 0) {
                    $(this).find('a').attr("class", "tab1");
                    return;
                }
            });
        }

        //显示未读系统信息
        function showUnreadSysMsgCount() {
            var unreadSysMsgCount = "0";
            if (Number(unreadSysMsgCount) > 0) {
                $("#unreadSysMsgCount").html("(" + unreadSysMsgCount + ")");
            }
        }

        //退出
        function loginOut() {
            if (confirm("确定退出吗？")) {
            	/*
                StudentLogin.loginOut(function (data) {
                    if (data == "true") {
                        window.location = "/Login.aspx";
                    }
                    else {
                        jBox.alert("退出失败！", "提示", new { buttons: { "确定": true} });
                    }
                });
            	*/
            	$.ajax({  
        		    url: 'loginOut',
        		    type: 'POST',  	//请求类型
        		    error: function(xml) {  
        		    	alert("请求数据出错!");  
        		    },
        		    success: function(){
        		    	self.location = "index.jsp";
        		    }
        	    });
            }
        }
        
function change(data){
	if(data == 1){
		
	}
	else if(data == 2){
		
	}
	else{
		
	}
}  
function changeSrc(data){
	if(data == 1){
		$("#changeSrc").attr('src','teacher/manageexam.jsp');//管理试卷
        $("#my").hide();
		$("#grade").hide();
		$("#password").hide();
		$("#manageexam").show();
		$("#manageitemsearch").hide();
		$("#searchgrade").hide();
	}
	else if(data == 2){
		$("#changeSrc").attr('src','teacher/manageitemsearch.jsp');//管理题库
        $("#my").hide();
		$("#grade").hide();
		$("#password").hide();
		$("#manageexam").hide();
		$("#manageitemsearch").show();
		$("#searchgrade").hide();
	}
	else if(data == 3){
		$("#changeSrc").attr('src','teacher/teacherinformation.jsp');//我的基本信息
        $("#my").show();
		$("#grade").hide();
		$("#password").hide();
		$("#manageexam").hide();
		$("#manageitemsearch").hide();
		$("#searchgrade").hide();
	}
	else if(data == 4){
		$("#changeSrc").attr('src','teacher/searchgrade.jsp');//查看成绩
        $("#my").hide();
		$("#grade").hide();
		$("#password").hide();
		$("#manageexam").hide();
		$("#manageitemsearch").hide();
		$("#searchgrade").show();
	}
	else{
		$("#changeSrc").attr('src','teacher/teacherpswalter.jsp');//老师修改密码
        $("#my").hide();
		$("#grade").hide();
		$("#password").show();
		$("#manageexam").hide();
		$("#manageitemsearch").hide();
		$("#searchgrade").hide();
	}
}	
</script>
</head>
<body>
    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="**">
                        <img src="images/logo.jpg" alt="" width="62" height="56" />
                    </a>
                </div>
                <div class="topxx">
                    	老师：${sessionScope.teacher.teacherName}，欢迎您！ 
                    <a onclick="loginOut()"href="javascript:">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li id="my"><a href="javascript:volid(0);">我的基本信息</a></li>
                        <li id="grade"><a href="javascript:volid(0);">查看学生成绩</a></li>
                        <li id="password"><a href="javascript:volid(0);">修改密码</a></li>
                        <li id="manageexam"><a href="javascript:volid(0);">管理试卷</a></li>
                        <li id="manageitemsearch"><a href="javascript:volid(0);">管理题库</a></li>
                        <li id="searchgrade"><a href="javascript:volid(0);">查看成绩</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
                    <div class="ta1">
                      <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="javascript:volid(0);" onclick="changeSrc(3)">我的基本信息</a></div>
                        <div>
                            <a href="javascript:volid(0);" onclick="changeSrc(5)">修改密码</a></div>
                    </div>
                    <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="javascript:volid(0);" onclick="changeSrc(1)">管理试卷</a></div>
                        <div>
                            <a href="javascript:volid(0);" onclick="changeSrc(2)">管理题库</a></div>
                        <div>
                            <a href="javascript:volid(0);" onclick="changeSrc(4)">查看成绩</a></div>
                    </div>
					<div class="ta1">
                        <div class="leftbgbt2">
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
             <iframe id="changeSrc" src="teacher/teacherinformation.jsp"  width="780px" height="970px" frameborder="0"></iframe> 
       		</div>
      </div>
    </div>
</body>
</html>
