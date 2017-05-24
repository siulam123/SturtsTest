<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生修改密码</title>
</head>
<link rel="stylesheet" href="../css/studentalterpasswork.css">
<script type="text/javascript">
 $(function Check(){
    var text=document.getElementById("user");
    var resultObj=$("#resultid");
    if(text.value=="")
    {
      resultObj.hide();
      alert("您输入的名字不能为空！");
      return false;
    }
    else{
      return true;
    }
})
</script>
<body>
<form action="">
	<div class="content">
		<div class="locationcss">
			账号：<input type="text" class="input" value="04140707"  readonly>
		</div>
		<div class="locationcss">
			姓名：<input type="text" class="input" value="陈跃" readonly>
		</div>
		<div class="locationcss">
			新密码：<input type="text" class="input" >
		</div>
		<div class="locationcss">
			确认密码：<input type="text" class="input" >
		</div>
		<div class="locationcss">
			<input type="submit" value="确认" style="height:40px;width:90px;">
		</div>
	</div>
</form>	
</body>
</html>