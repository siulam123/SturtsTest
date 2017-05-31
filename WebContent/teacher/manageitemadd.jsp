<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理题库</title>
<script src="../js/jquery-3.2.0.min.js"></script>
<script>
$(document).ready(function(){
  $("#select").change(function(){
	  var id=document.getElementById("select").value;
	  /* alert(id); */
	  $("#choice").hide();
	  $("#judge").hide();
	  $("#blankfiling").hide();
	   $("#program").hide();
	  $("#"+id).show();	  
	  });	
});

function sub(){
	var type =""; type = document.getElementById("select").value;
	var answer = "";
	var content = "";
	
	if(type=="choice"){//选择题
		answer = $("input[class='choice']:checked").val();
		var A = "";var B = "";
		var C = "";var D = "";
		var con = "";
		A = document.getElementById("choanswerA").value;
		B = document.getElementById("choanswerB").value;
		C = document.getElementById("choanswerC").value;
		D = document.getElementById("choanswerD").value;
		con = document.getElementById("chocontent").value;
		
		content = con + "->" + A + "->" + B + "->" + C + "->" + D;
	}
	else if(type=="judge"){//判断题
		answer = $("input[class='judge']:checked").val();
		content = document.getElementById("jdcontent").value;
	}
	else if(type=="blankfiling"){//填空题
		content = document.getElementById("bfcontent").value;
		answer = document.getElementById("bfanswer").value;
	}
	else{
		
	}
	
	$.ajax({  
	        url: 'ItemAdd',
	        type: 'POST',  	//请求类型
			data: {"content":content,"answer":answer,"type":type},//上传数据
	        //timeout: 1000,  //设定超时  
	        //cache: false,   //禁用缓存  
	        error: function(xml) {  
	            alert("加载XML文档出错!");  
	        },
	        success: function(data){   //设置成功后回调函数
			}
	});
	

}
function addAnswer(){
	$("#blankfiling").prepend("<textarea id='bfanswer' rows='6' cols='70' style='max-width: 500px;'></textarea>");
}
</script>
<style type="text/css">
.ItemCss{
padding:9px 9px 9px 9px;
background:rgba(0,0,0,0.05);
boder-radious:10px;
color:#185697;
}
</style>
</head>
<body>
<div id="main">
	<form action="">
	<div id="title">
		<font size="2" color="#185697">管理题库 &gt; 老师增加题目</font>
	</div><br>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td class="ItemCss" align="center" >
				选择要增加题目的题型：
				<select id="select" name="select" >
					<option value="choice">选择题</option>
					<option value="judge">判断题</option>
					<option value="blankfiling">填空题</option>
					<option value="program">编程题</option>
				</select>
			</td>
			<td></td>
		</tr>
		<!-- 选择题的块 -->
		<tr>
			<td align="center" class="ItemCss" >
				<div id="choice">
					选择题题目:<br>
					<textarea id="chocontent" rows="9" cols="70" style="max-width: 500px;"></textarea><br>&nbsp;<br>
					
					A:<input id="choanswerA" type="text" style="overflow-x:visible;width:500px;height:25px;" value="A:" /><br>&nbsp;<br>
					B:<input id="choanswerB" type="text" style="overflow-x:visible;width:500px;height:25px;" value="B:" /><br>&nbsp;<br>
					C:<input id="choanswerC" type="text" style="overflow-x:visible;width:500px;height:25px;" value="C:" /><br>&nbsp;<br>
					D:<input id="choanswerD" type="text" style="overflow-x:visible;width:500px;height:25px;" value="D:" /><br>&nbsp;<br>
					答案：
					&nbsp;<input class="choice" type="radio" value="A" />A
					&nbsp;<input class="choice" type="radio" value="B" />B
					&nbsp;<input class="choice" type="radio" value="C" />C
					&nbsp;<input class="choice" type="radio" value="D" />D
				</div>
			</td>
		</tr>
		<!-- 判断题的块 -->
		<tr>
			<td align="center" class="ItemCss" >
				<div id="judge" style="display:none;">
					判断题题目:<br>
					<textarea id="jdcontent" rows="9" cols="70" style="max-width: 500px;"></textarea><br>
					答案：
					<input class="judge" type="radio" value="Y" />Y
					<input class="judge" type="radio" value="N" />N
				</div>
			</td>
		</tr>
		<!-- 填空题的块 -->
		<tr>
			<td align="center" class="ItemCss" >
				<div id="blankfiling" style="display:none;">
					填空题目内容：<br>
					<textarea id="bfcontent" rows="9" cols="70" style="max-width: 500px;"></textarea><br>
					答案：<br>
					<textarea id="bfanswer" rows="6" cols="70" style="max-width: 500px;"></textarea>		
					
					<div>
						<button onclick="addAnswer()">增加一个标准答案</button>
					</div>
				</div>
			</td>
		</tr>
		<!-- 编程题的块 -->
		<tr>
			<td align="center" class="ItemCss" >
				<div id="program" style="display:none;">
					编程题目内容：<br>
					<textarea id="pgcontent" rows="9" cols="70" style="max-width: 500px;"></textarea><br>
					答案：<br>
					<textarea id="pganswer" rows="6" cols="70" style="max-width: 500px;"></textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" class="ItemCss" >
				<div id="submit">
					<input type="submit" onclick="sub()" class="btn-style" value="提交" width="3px">&nbsp;&nbsp;
					<input type="reset" class="btn-style" value="重置">	
				</div>
			</td>
		</tr>
		</table>
	</div>
	</form>
</body>
</html>