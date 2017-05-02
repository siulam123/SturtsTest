<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>题目清单</title>
<link rel="stylesheet" href="../css/exam.css"> 
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script src='../js/jquery.js'></script>
<script src='../js/skrollr.min.js'></script>
<script> 
$(document).ready(function () {		
	<forEach items="${list}" var="obj">
		var obj_arr="${obj.name}";
		$("#content").append("<div class='card'>${676}</div>");
	</forEach>
	skrollr.init({ smoothScrolling: true });  
}); //@ sourceURL=pen.js
</script>
<script type="text/javascript"> 
window.onload=function(){
 var bt=document.getElementById("bt");
 bt.onclick=function(){
  if(confirm("完成一张组卷,是否继续组卷？")){
   self.location='manageexamitemlist.jsp';
  }
  else{
	   self.location='manageexam.jsp';
  }
 }
}
</script> 
<script src="js/jquery.min.js"></script>
<script>
$(function(){
	$("#showdiv").click(function(){
		var box =300;
		var th= $(window).scrollTop()+$(window).height()/1.6-box;
		var h =document.body.clientHeight;
		var rw =$(window).width()/2-box;
		$(".showbox").animate({top:th,opacity:'show',width:600,height:180,right:rw},500);
		$("#zhezhao").css({
			display:"block",height:$(document).height()
		});
		return false;
	});
	$(".showbox .close").click(function(){
		$(this).parents(".showbox").animate({top:0,opacity: 'hide',width:0,height:0,right:0},500);
		$("#zhezhao").css("display","none");
	});
});
</script>
<link href="../css/floatingwindow.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="page" >
	<div id="toolbar" style="background:#BEBEBE;">
		<div id="title" >
			<a ><font>以下是您选好的题目：</font></a>
		</div>
        <div id="title-right">
           	<a href="../indext.jsp" >退出</a>   
        </div>
	</div>
	 <div id="content" ><!-- 框的样式 -->
	 	<div class="contentCss" style="border: 1px solid #ffff00;" ><!-- 题的内容样式 -->
			<div id="choice" ><!-- 选择题样式 -->
				<div class="choiceCss">
					1选择题题目<br>
					<input name="radio" type="radio" value="A" disabled />A:A选项
					<input name="radio" type="radio" value="B" disabled/>B:B选项
					<input name="radio" type="radio" value="C" disabled/>C:C选项
					<input name="radio" type="radio" value="D" disabled/>D:D选项<br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/><br>
					2选择题题目<br>
					<input name="radio" type="radio" value="A" disabled/>A:A选项
					<input name="radio" type="radio" value="B" disabled/>B:B选项
					<input name="radio" type="radio" value="C" disabled/>C:C选项
					<input name="radio" type="radio" value="D" disabled/>D:D选项<br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/><br>
					3选择题题目<br>
					<input name="radio" type="radio" value="A" disabled/>A:A选项
					<input name="radio" type="radio" value="B" disabled/>B:B选项
					<input name="radio" type="radio" value="C" disabled/>C:C选项
					<input name="radio" type="radio" value="D" disabled/>D:D选项<br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/>
				</div>
			</div>
		</div>
		<div class="contentCss" style="border: 1px solid #ffff00;">
			<div id="judge" ><!--判断题的样式  -->			
				<div class="judgeCss">
					1、判断题题目<br>
					<input name="X" type="radio" value="C" disabled/>Y
					<input name="X" type="radio" value="D" disabled/>N<br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/>
				</div>
			</div>
		</div>
		<div class="contentCss" style="border: 1px solid #ffff00;">
			<div id="blankfiling">
				<div class="blankfilingCss">
					填空题题目<br>
					答案：<input type="text" style="border:0;border-bottom:2 solid black;"/><br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/>
				</div>
			</div>
		</div>
	<div>
		<a id="showdiv" href="#" style="background:#BEBEBE;color:#000000">确定组卷</a>
	</div>
</div>
</div>
<!---------- 筛选标签的弹窗 --------------->
<div class="showbox" style="color:#000000">
	<h2>请填写一张试卷的相关信息<a class="close" href="javascript:">关闭</a></h2>
	<div class="mainlist"><!-- 题目标签的样式 -->
		 <table border="2" cellpadding="0" cellspacing="0" style="width:98%; height:80%;" >
		 	<tr>
			 	<td style="background:#BEBEBE;" >试卷题目</td>
			 	<td colspan="2"><input type="text" name="topic" style="width:99.5%;height:100%;"></td>
		 	</tr>
		 	<tr>
		 	<td style="background:#BEBEBE;">选择题</td>
			 	<td>数量：<input type="text" name="number"></td>
			 	<td>总分值：<input type="text" name="score"></td>
		 	</tr>
		 	<tr>
			 	<td style="background:#BEBEBE;">判断题</td>
			 	<td>数量：<input type="text" name="number"></td>
			 	<td>总分值：<input type="text" name="score"></td>
		 	</tr>
		 	<tr>
			 	<td style="background:#BEBEBE;">填空题</td>
			 	<td>数量：<input type="text" name="number"></td>
			 	<td>总分值：<input type="text" name="score"></td>
		 	</tr>
	 </table>		
	</div>
	<div align="center">
	   	<input type="submit" id="bt"value="确定" onClick="javascript:popUp()"style="width:100px;height:30px;background:#3366cc;color:#fff; border-radius:10px;">
	</div>
</div>	
<div id="zhezhao"></div>
</body>
</html>