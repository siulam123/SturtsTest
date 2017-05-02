<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>老师</title>
<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" href="../css/teacherstyle.css"/>
<script src="../jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../hoverSlippery.js"></script>
<script>
  $(document).ready(function(){
	//- Default 
	$('.default').hoverSlippery();
	//- Twice border
	$('.twiceBorder').hoverSlippery({
		border: true,
		twiceBorder : true
	})
	//- Underline
	$('.underline').hoverSlippery({
		border: true,
		underline: true
	})
	//- Overline
	$('.overline').hoverSlippery({
		border: true,
		overline: true
	})
  })
</script>
</head>
<body>
<form action="">
<div class="zzsc-container">
	<div class="c">
		  <h3 class="space">姓名：....</h3>
		  <nav class="nav default">
			<ul>
			  <li class="nav__item active"><a href="manageexam.jsp">管理试卷</a></li>
			  <li class="nav__item"><a href="manageitemsearch.jsp">管理题库</a></li>
			  <li class="nav__item"><a href="searchgrade.jsp">查看成绩</a></li>
			</ul>
		  </nav>
	</div>
</div>

</body>
</html>