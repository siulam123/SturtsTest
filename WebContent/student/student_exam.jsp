<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生考试页面</title>
<link rel="stylesheet" href="../css/student_exam.css">
</head>
<body>
	<div id="head">
		C++期末 XXX 考试
	</div>
	<div id="main">
		<div id="itemID">
			<fieldset>
				<legend class="time"><font color="red">剩余时间</font></legend>
			    	考试时长为：<br>  1 5 0 分 钟<br>
			    	<font color="red">*</font>必须要在规定时间内完成，否则自动交卷<br><hr>
			   		 离考试结束：<br><span id="clock"> </span>
						<script>
						var endTime = new Date();
						endTime.setMinutes(endTime.getMinutes() + 150);
						function displayTime() {
							var elt = document.getElementById("clock");
							if(leftTime < 0) {
							elt.innerHTML = "Over";
						} else { 
							/* var d= new Date("2017-10-10");//这里日期是传递过来的，可以自己改
							d.setDate(d.getMinutes() + 10);//天数+10
							var endTime=d; */
							//var endTime=new Date();
							//alert(endTime);
							
							var now = new Date();
							var leftTime = endTime.getTime() - now.getTime();
							var ms = parseInt(leftTime % 1000).toString();
							leftTime = parseInt(leftTime / 1000);
							var o = Math.floor(leftTime / 3600);
							var d = Math.floor(o / 24);
							var m = Math.floor(leftTime / 60 % 60);
							var s = leftTime % 60;
							elt.innerHTML = o + "小时:" + m + "分:" + s + "秒";// + ms.charAt(0);
							setTimeout(displayTime, 100);
						}
						}
							displayTime();
						</script>
			 </fieldset>
			 <fieldset >
			    <legend class=""><font color="red">答题信息</font></legend>
			   	 <table border="2" cellpadding="0" cellspacing="0">
			   	 	<tr>
			   	 		<td><a href=" onclick()">01</a></td>
			   	 		<td><a href="">02</a></td>
			   	 		<td><a href="">03</a></td>
			   	 		<td>04</td>
			   	 		<td>05</td>
			   	 		<td>06</td>
			   	 		<td>07</td>
			   	 		<td>08</td>
			   	 		<td>09</td>
			   	 	</tr>
			   	 </table>
			 </fieldset>
		</div>
		<div id="item">
			<fieldset style="width:600px;height:300px;" >
				<legend class=""><font color="red">考试题目</font></legend>
				    <div id="itemShow">
				    	1.C++有哪些性质（面向对象特点）<br>
						你的答案：<input type="text">
					</div>
			 </fieldset> 
			 <div id="itemCtrl">
			 	<input type="button" id="last" value="上一题" style="height:30px;width:70px;">
			 	<input type="button" id="next" value="下一题" style="height:30px;width:70px;">
			 	<input type="submit" id="submit" value="交卷" style="height:30px;width:70px;">
			 </div>
		</div>
	</div>
</body>
</html>