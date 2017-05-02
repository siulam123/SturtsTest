<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加试卷</title>
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
<script src="js/jquery.min.js"></script>
<script>
$(function(){
	$(".showdiv").click(function(){
		var box =300;
		var th= $(window).scrollTop()+$(window).height()/1.6-box;
		var h =document.body.clientHeight;
		var rw =$(window).width()/2-box;
		$(".showbox").animate({top:th,opacity:'show',width:600,height:340,right:rw},500);
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
<div id="page">
	<div id="toolbar">
		<div id="title">
			<a class="showdiv" href="#">先筛选题库中的题目</a><!-- 动态标签js -->
		</div>
        <div id="title-right">
           	<a href="../indext.jsp" >退出</a>   
        </div>
	</div>
	 <div id="content"><!-- 框的样式 -->
	 	<div class="contentCss"><!-- 题的内容样式 -->
			<div id="choice"><!-- 选择题样式 -->
				<div id="quanxuan"><!-- 全选按钮 -->
    			   	<input style="align:right" name="select" type="checkbox" value="select "/>全选
     		  	</div> <br>
      		 	<div><hr></div>
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
		<div class="contentCss">
			<div id="judge" ><!--判断题的样式  -->
				<div id="quanxuan">
       				<input style="align:right" name="select" type="checkbox" value="select "/>全选
    		  	</div> <br>
       			<div><hr></div>
				<div class="judgeCss">
					1、判断题题目<br>
					<input name="X" type="radio" value="C" disabled/>Y
					<input name="X" type="radio" value="D" disabled/>N<br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/>
				</div>
			</div>
		</div>
		<div class="contentCss">
			<div id="blankfiling">
				<div id="quanxuan">
       				<input style="align:right" name="select" type="checkbox" value="select "/>全选
    		  	</div> <br>
       			<div><hr></div>
				<div class="blankfilingCss">
					填空题题目<br>
					答案：<input type="text" style="border:0;border-bottom:2 solid black;"/><br>
					答案：答案内容；<br>
					<input name="select" type="checkbox" value="select "/>
				</div>
			</div>
		</div>
	<div>
		<a href="manageexamitemlist.jsp">
		<input type="submit" value="添加到题目清单" style="width:100px;height:30px;background:#1BBBFB;color:#fff; border-radius:10px;"/>
		</a>
	</div>
	</div>
	</div>
<!---------- 筛选标签的弹窗 --------------->
<div class="showbox">
   <h2>请选择你要组卷的题目的标签<a class="close" href="javascript:">关闭</a></h2>
   <div class="mainlist"><!-- 题目标签的样式 -->
   <p>标签1<input type="checkbox" name="tag1" value="tag1" ></p>
   <p>标签2<input type="checkbox" name="tag1" value="tag1" ></p>
   <p>标签3<input type="checkbox" name="tag1" value="tag1" ></p>
   <p>标签4<input type="checkbox" name="tag1" value="tag1" ></p>
   <p>标签5<input type="checkbox" name="tag1" value="tag1" ></p>
   </div>
   <div align="center">
   	<a href="manageexamadd.jsp">
   	<input type="submit" value="确定" style="width:100px;height:30px;background:#3366cc;color:#fff; border-radius:10px;">
   	</a>
   </div>
</div>	
<div id="zhezhao"></div>
</body>
</html>