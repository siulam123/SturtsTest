<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加试卷</title>
   <link rel="stylesheet" href="../css/exam.css"> 
    <script src='../js/jquery.js'></script>
    <script src='../js/skrollr.min.js'></script>
    <script> $(document).ready(function () {		
			<forEach items="${list}" var="obj">
        		var obj_arr="${obj.name}";
				$("#content").append("<div class='card'>${676}</div>");
     		</forEach>
            skrollr.init({ smoothScrolling: true });
        }); //@ sourceURL=pen.js
    </script>
</head>
<body>
 <div id="page">
	<div id="toolbar">
		<div id="title">
			<a href="**"><font color="#000000">标签1</font></a><!-- 动态标签js -->
			<a href="**"><font color="#000000">标签2</font></a>
		</div>
        <div id="title-right">
           	<a href="../indext.jsp" >退出</a>   
        </div>
	</div>
	 <div id="content">
    <div class="contentCss">
	<div id="choice">
		<div id="quanxuan">
       	<input style="align:right" name="select" type="checkbox" value="select "/>全选
       	</div> <br>
		<div class="choiceCss">
		<div class="choiceone">1选择题题目<br>
		<input name="radio" type="radio" value="A" />A:A选项
		<input name="radio" type="radio" value="B" />B:B选项
		<input name="radio" type="radio" value="C" />C:C选项
		<input name="radio" type="radio" value="D" />D:D选项<br>
		答案：答案内容；<br>
		<input name="select" type="checkbox" value="select "/>
		</div><br>
		<div class="choicetwo">2选择题题目<br>
		<input name="radio" type="radio" value="A" />A:A选项
		<input name="radio" type="radio" value="B" />B:B选项
		<input name="radio" type="radio" value="C" />C:C选项
		<input name="radio" type="radio" value="D" />D:D选项<br>
		答案：答案内容；<br>
		<input name="select" type="checkbox" value="select "/>
		</div><br>
		<div class="choicethee">3选择题题目<br>
		<input name="radio" type="radio" value="A" />A:A选项
		<input name="radio" type="radio" value="B" />B:B选项
		<input name="radio" type="radio" value="C" />C:C选项
		<input name="radio" type="radio" value="D" />D:D选项<br>
		答案：答案内容；<br>
		<input name="select" type="checkbox" value="select "/>
		</div>
		</div>
	</div>
	</div>
	
	<div class="contentCss">
	<div id="judge" >
		<div class="quanxuan">
			<input name="select" type="checkbox" value="select "/>
		</div> 
		<div class="judgeCss">
		判断题题目<br>
		<input name="X" type="radio" value="C" />Y
		<input name="X" type="radio" value="D" />N<br>
		答案：答案内容；<br>
		<input name="select" type="checkbox" value="select "/>
		</div>
	</div>
	</div>
	
	<div class="contentCss">
	<div id="blankfiling">
		<div class="quanxuan">
			<input name="select" type="checkbox" value="select "/>
		</div> 
		<div class="blankfilingCss">
		填空题题目<br>
		答案：答案内容；<br>
		<input name="select" type="checkbox" value="select "/>
		</div>
	</div>
	</div>
	<div>
		<input type="submit" value="添加到题目清单"/>
	</div>
	</div>
</div>	
</body>
</html>