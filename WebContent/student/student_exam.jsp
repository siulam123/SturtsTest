<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生考试页面</title>
<link rel="stylesheet" href="../css/student_exam.css">
</head>

<script type="text/javascript" src="js/exam.js"></script>
<script type="text/javascript">
var stuExamItem = eval(${stuExamItem});
var stuExam = eval(${stuExam});
var mun = 1;	//题号
var mar = 0;	//总题数
var myAnswer = new Array();
var type = "";

$(document).ready(function(){ 
	
	var indexHtml="";
	$.each(stuExamItem, function(index,value){
		indexHtml+= "<a id='"+(index+1)+"' class='exchangedBtn' href='javascript:volid(0)' onclick='(item("+(index+1)+"))'>"+(index+1)+"</a>"
		
		if((index+1)%7 == 0){
			indexHtml+='</br>';
		}
		mar = (index+1);
		myAnswer[index] = "";
	});				
	if(index == ""){
		$("#index").hide();
	}
	else{
		$("#index").html(indexHtml);
	}

	item(mun);
});



function item(itemId){
	var htmlStr = "";

	mun = itemId;

	$.each(stuExamItem, function(index,value){
		if(itemId == (index+1)){
			
			if(value.type=="blankfiling")
			{
				type="blankfiling";
				htmlStr += (index+1)+"."+value.content+"<br>"+
							"你的答案是："+"<input type='text' name='answer'>"
			}
			else if(value.type=="choice")
				{
					type="choice";
					str=value.content; //这是一字符串 
		    		var strs= new Array(); 	 //定义一数组 
		    		strs=str.split("->");    //字符分割 
					htmlStr +=(index+1)+"."+strs[0]+"<br>"+
						"<input name='answer' type='radio' value='A' />"+strs[1]+"<br>"+
						"<input name='answer' type='radio' value='B' />"+strs[2]+"<br>"+
						"<input name='answer' type='radio' value='C' />"+strs[3]+"<br>"+
						"<input name='answer' type='radio' value='D' />"+strs[4]+"<br>"
				}
			else if(value.type=="judge")
				{
					type="judge";
					htmlStr += (index+1)+"."+value.content+"<br>"+
					"<input name='answer' type='radio' value='Y'/>Y"+"<br>"+
					"<input name='answer' type='radio' value='N'/>N"
				}
		}
	});
	$("#itemShow").html(htmlStr);
	if(myAnswer[(itemId-1)]!=""){
		if(type=="blankfiling"){
			$("input[name='answer']")[0].value = myAnswer[(itemId-1)];
		}
		else if(type=="choice"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].value == myAnswer[(itemId-1)]){
					$("input[name='answer']")[i].checked = "true";
				}
			}
		}
		else if(type=="judge"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].value == myAnswer[(itemId-1)]){
					$("input[name='answer']")[i].checked = "true";
				}
			}
		}
	}
}

function nextItem(){

	if($("input[name='answer']")[0].value!=""){
		if(type=="blankfiling"){
			if(myAnswer[(mun-1)] != $("input[name='answer']")[0].value){
				myAnswer[(mun-1)] = $("input[name='answer']")[0].value;
				$("#"+mun)[0].style.background="red	";
				//执行上传
			}
		}
		else if(type=="choice"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].checked == true){
					if(myAnswer[(mun-1)] != $("input[name='answer']")[i].value){
						myAnswer[(mun-1)] = $("input[name='answer']")[i].value;
						$("#"+mun)[0].style.background="red	";
						//执行上传
					}
				}
			}
		}
		else if(type=="judge"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].checked == true){
					if(myAnswer[(mun-1)] != $("input[name='answer']")[i].value){
						myAnswer[(mun-1)] = $("input[name='answer']")[i].value;
						$("#"+mun)[0].style.background="red	";
						//执行上传
					}
				}
			}
		}
	}
	
	if((mun+1)>mar){
		alert("已经是最后一个了");
		return false;
	}
	item((mun+1));
}
function lastItem(){
	if($("input[name='answer']")[0].value!=""){
		if(type=="blankfiling"){
			if(myAnswer[(mun-1)] != $("input[name='answer']")[0].value){
				myAnswer[(mun-1)] = $("input[name='answer']")[0].value;
				$("#"+mun)[0].style.background="red	";
				//执行上传
			}
		}
		else if(type=="choice"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].checked == true){
					if(myAnswer[(mun-1)] != $("input[name='answer']")[i].value){
						myAnswer[(mun-1)] = $("input[name='answer']")[i].value;
						$("#"+mun)[0].style.background="red	";
						//执行上传
					}
				}
			}
		}
		else if(type=="judge"){
			for(var i=0; i<$("input[name='answer']").length; i++){
				if($("input[name='answer']")[i].checked == true){
					if(myAnswer[(mun-1)] != $("input[name='answer']")[i].value){
						myAnswer[(mun-1)] = $("input[name='answer']")[i].value;
						$("#"+mun)[0].style.background="red	";
						//执行上传
					}
				}
			}
		}
	}
	
	if((mun-1)<=0){
		alert("已经是第一个了");
		return false;
	}
	item((mun-1));
}
	
	
</script>
<body>
	<div id="head">
		C++期末 XXX 考试
	</div>
	<div id="main">
		<div id="itemID">
			<fieldset>				<!-- 考试的时间相关事件 -->
				<legend class="time"><font color="red">剩余时间</font></legend>
			    	考试时长为： <br>  1 5 0 分钟<br>
			    	* 必须要在规定时间完成，否则自动交卷<br><hr>
			   		 离考试结束：<br><span id="clock"> </span>
						<script>
						var endTime = new Date();
						var time = 0;
						time = stuExam[0].examTime;
						endTime.setMinutes((endTime.getMinutes() + parseInt(time)));
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
			 <fieldset >			<!-- 试卷题目的题号块 -->
			    <legend class=""><font color="red">答题信息</font></legend>
			   	 	<div id="index">
			   	 		<!-- <td><a href=" onclick()">01</a></td>
			   	 		<td><a href="onclick()">02</a></td>
			   	 		<td><a href="onclick()">03</a></td> -->
			   	 	</div>
			 </fieldset>
		</div>
		<div id="item">				<!--  试卷一题的显示 -->
		<form action=" " name="exam">
			<fieldset style="width:600px;height:300px;" >
				<legend class=""><font color="red">考试题目</font></legend>
				    <div id="itemShow">
				    	
					</div>
			 </fieldset>
			 <div id="itemCtrl">
			 	<input type="button" class="last" name="last" onclick="lastItem()" value="上一题" style="color:blue;height:30px;width:70px;">
			 	<input type="button" class="next" name="next" onclick="nextItem()" value="下一题" style="color:blue;height:30px;width:70px;"> 
			 	<input type="submit" id="submit" value="交卷" style="color:blue;height:30px;width:70px;">
			 </div>
						 
		</form>
		</div>
	</div>
	
</body>
</html>