<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>老师修改密码</title>
<script type="text/javascript" language="javascript">
    function changePassword() {
        var oldPwd = $("#txtOldPwd").val();
        var newPwd = $("#txtNewPwd").val();
        var confirmNewPwd = $("#txtConfirmNewPwd").val();

        if (oldPwd == "" || newPwd == "" || confirmNewPwd=="") {
            $.jBox.tip("旧密码或新密码或确认新密码不能为空！", 'error');
            return false;
        }
        if (oldPwd.length < 6 || oldPwd.length > 16) {
            $.jBox.tip("旧密码为6~16个字符，区分大小写！", 'error');
            return false;
        }
        if (newPwd.length < 6 || newPwd.length > 16) {
            $.jBox.tip("新密码为6~16个字符，区分大小写！", 'error');
            return false;
        }
        if (newPwd != confirmNewPwd) {
            $.jBox.tip("新密码两次输入不一致！", 'error');
            return false;
        }

        studentAccount.changePassword(oldPwd, newPwd, function (data) {
            var obj = $.parseJSON(data);
            if (obj.ok) {
                jBox.alert(obj.message, "提示");
                setTimeout(function () {
                    window.location.reload();
                }, 1500);
            }
            else {
                jBox.tip(obj.message, 'error');
            }
        });
    }
</script>
<style type="text/css">
    .txtinput1{width:180px;}
</style>
<link href="../css/reachergrade.css" rel="stylesheet" type="text/css" />
<link href="../css/ks.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
</head>
<body>
<div class="right">
	<h2 class="mbx">我的信息 &gt; 密码修改</h2>
	<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="500px">
	    <tr align="center">
	        <th style="width:20%; text-align:left;">旧密码：</th>
	        <td style="width:70%; text-align:left;"><input id="txtOldPwd" value="" type="password" class="input_2 txtinput1" /></td>
	    </tr>
	    <tr align="center">
	        <th style="width:20%; text-align:left;">新密码：</th>
	        <td style="width:70%; text-align:left;"><input id="txtNewPwd" value="" type="password" class="input_2 txtinput1" />&nbsp;&nbsp;6~16个字符，区分大小写</td>
	    </tr>
	    <tr align="center">
	        <th style="width:20%; text-align:left;">确认新密码：</th>
	        <td style="width:70%; text-align:left;"><input id="txtConfirmNewPwd" value="" type="password" class="input_2 txtinput1" /></td>
	    </tr>
	    <tr>
	    <td colspan="2" style="text-align:center;"><input type="submit" id="btnSubmit" value="确认修改" onclick="changePassword()" class="input2" /></td>
	    </tr>
	</table>
	</div>
</div>

</body>
</html>