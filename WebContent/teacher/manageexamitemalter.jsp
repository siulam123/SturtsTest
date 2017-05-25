<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改试卷</title>
<link rel="stylesheet" href="../css/demo.css" type="text/css" media="all" />
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/pagescroller.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var json = ${RandomExam};
	
	var blankfiling = eval(json[0].blankfiling);
	var judge = eval(json[0].judge);
	var choice = eval(json[0].choice);
	var examParamters = eval(json[0].examParamters);
	var code = eval(json[0].code);
	
	var blankfilingStr ="";
	var judgeStr ="";
	var choiceStr ="";
	var codeStr="";
	
	$.each(blankfiling, function(index,value){
			blankfilingStr += (index+1) +"."+blankfiling[index].content+"<br>"+
			"答案："+blankfiling[index].answer+"<br>"
		
	});
	$.each(judge, function(index,value){
		judgeStr += (index+1) +"."+judge[index].content+"<br>"+
		"<input name='X' type='radio' value='Y' disabled/>"+
		"<input name='X' type='radio' value='N' disabled/>"+
		"答案："+judge[index].answer+"<br>"
	});
	$.each(choice, function(index,value){
		str=choice[index].content; //这是一字符串 
		var strs= new Array(); 	 //定义一数组 
		strs=str.split("->");    //字符分割 
		choiceStr += (index+1) +"."+strs[0]+"<br>"+
		"<input name='radio' type='radio' value='A' disabled />"+strs[1]+
		"<input name='radio' type='radio' value='B' disabled/>"+strs[2]+"<br>"+
		"<input name='radio' type='radio' value='C' disabled/>"+strs[3]+
		"<input name='radio' type='radio' value='D' disabled/>"+strs[4]+"<br>"+
		"答案："+choice[index].answer+"<br>"
	});
	$.each(code, function(index,value){
		codeStr+= (index+1) +"."+code[index].problem_id+"<br>"+
		"标题："+code[index].title+"<br>"+
		$(code[index].description).html()+"<br>"+
		"输入："+code[index].input+"输出："+code[index].output+"<br>"+
		"</div>"

	});
	
/*	var navLabel = new Array();
	var nav = 0;
	if(choiceStr==""){}
	else{
		navLabel[nav] = "选择题";
		nav++;
		$("#choice").html(choiceStr);
	}
	if(blankfilingStr==""){}
	else{
		navLabel[nav] = "填空题";
		nav++;
		$("#blankfiling").html(blankfilingStr);	
	}
	if(judgeStr==""){}
	else{
		navLabel[nav] = "判断题";
		nav++;
		$("#blankfiling").html(judgeStr);	
	}
*/
	$("#choice").html(choiceStr);
	$("#judge").html(judgeStr);
	$("#blankfiling").html(blankfilingStr);
	$("#code").html(codeStr);
	$("#topic").html(examParamters.topic);
	
	var navLabel = new Array('选择题', '填空题', '判断题', '编程题');
	$('#main').pageScroller({ navigation: navLabel });
	$('.next').click(function(e){
		e.preventDefault();
 		pageScroller.next();
	});
	$('.prev').click(function(e){
		e.preventDefault();
		pageScroller.prev();
	});
});
</script>
</head>
<body>
<div id="div_box" class="light">
	<a href="#" class="prev"><img src="../images/icon_arrow-up_light.png" alt="" width="28" height="31" /></a>
	<a href="#" class="next"><img src="../images/icon_arrow-down_light.png" alt="" width="28" height="31" /></a>
</div>
<div id="wrapper">
	<div id="main">
		<div id="title">
			<h1 id="topic"></h1><br>
			<h3>满分：100分   时间：150分钟  日期:2017.4.10</h3>
		</div>
		<div class="type">
			<h3>一：选择题</h3> <br>
			<div class="choiceCss" id="choice">
				
			</div>	
		</div>
		<div class="type" >
			<h3>二：填空题</h3><br>
			<div class="blankfilingCss" id = "blankfiling">
				
			</div>
		</div>
		<div class="type">
			<h3>三：判断题</h3><br>
				<div class="judgeCss" id="judge">
					
				</div>
		</div>
		<div class="type"><h1>四：编程题</h1><br>
			<div class="codeCss" id="code">
					
				</div>
		</div>
		<form action="addExam">
		<input type="submit" value="完成" class="btn-style">
		<input type="submit" value="取消" class="btn-style">
		</form>
	</div><!-- [END] #main -->
	</div><!-- [END] #wrapper -->
</body>
</html>