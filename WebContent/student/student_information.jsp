<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生的基本信息</title>
<style type="text/css">
.cztable{padding:15px 0;}
.cztable table{border-bottom:#cfe1f9 solid 4px;border-right:#cfe1f9 solid 1px;}
.cztable td, .cztable th{border-top:#cfe1f9 solid 1px; border-left:#cfe1f9 solid 1px; padding:6px 5px; }
.cztable th{background:#eef7fc url(../images/bgtable.jpg) repeat-x; line-height:22px; color:#185697;}
.cztable td a{color:#185697;}
.cztable .xxleft{text-align:left;}
</style>
</head>
<body>
 <div class="cztable">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
            		<tr>
            			<td>姓名:</td>
            			<td>${sessionScope.student.studentName}</td>
            		</tr>
            		<tr>
            			<td>性别：</td>
            			<td>女</td>
            		</tr>
            		<tr>
            			<td>电话号码：</td>
            			<td>135***689</td>            		
            		</tr>
            	</table>
            </div>

</body>
</html>