<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加试卷</title>
<link rel="stylesheet" href="../css/exam.css">
<style type="text/css"> 
.code_pages .pages{display:inline-block;top:20px;padding:4px 0;height:38px;overflow: hidden;position: relative;}  
.code_pages .inner_pages{display:inline-block;position: absolute;top:12px;left:0;height: 38px;}  
</style>
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script src='../js/jquery.js'></script>
<script src='../js/skrollr.min.js'></script>
<script> 
	$(document).ready(function () {	
		$.ajax({  ///JZExamSystem/getAllItems.action
			        url: 'getAllItems',
	                type: 'POST',  	//请求类型
	            	//data: {},//上传数据
	                dataType: 'json',//返回类型  
	                //timeout: 1000,  //设定超时  
	                //cache: false,   //禁用缓存  
	                error: function(xml) {  
	                    alert("请求数据出错!");  
	                },
	                success: function(data){   //设置成功后回调函数
		            	var json = eval(data.result);
		            	var blankfiling = 1;
		            	var choice = 1;
		            	var judge = 1;
		            	var chooseAll = "<div class='quanxuan'>"+
											 "<input name='select' type='checkbox' value='select '/>"+
	    									 "</div>";
	    				var blankfilingstr = "" + "<div class='quanxuan'>"+
						 "<input name='all' id='blankfilingall' type='checkbox' value='blankfiling'/>"+"全选"+
						 "</div>"+ "<div class='blankfilingCss'>";
		            	var choicestr = "" + "<div class='quanxuan'>"+
						 "<input name='all' id='choiceall' type='checkbox' value='choice'/>"+"全选"+
						 "</div>" + "<div class='choiceCss'>";
		            	var judgestr = "" + "<div class='quanxuan'>"+
						 "<input name='all' id='judgeall' type='checkbox' value='judge'/>"+"全选"+
						 "</div>" + "<div class='judgeCss'>";
						 
		            	$.each(json, function(index,value){
		            		
		            		if(json[index].type == "blankfiling")//填空题
		            		{
		            			blankfilingstr +="<br>"+ blankfiling+"."+json[index].content+"<br>"+
		            						"答案："+json[index].answer+"<br>"+
				            				"<input name='select' type='checkbox' value='"+json[index].itemId+"'/>"
				            	blankfiling++;
				            				
		            		}
		            		else if(json[index].type == "choice"){//选择题
		                		str=json[index].content; //这是一字符串 
		                		var strs= new Array(); 	 //定义一数组 
		                		strs=str.split("->");    //字符分割 
		                		choicestr += "<br>"+"<div class='choiceone'>"+choice+"."+strs[0]+"<br>"+
		                					 "<input name='radio' type='radio' value='A' />"+strs[1]+
		                					 "<input name='radio' type='radio' value='B' />"+strs[2]+
		                					 "<input name='radio' type='radio' value='C' />"+strs[3]+
		                					 "<input name='radio' type='radio' value='D' />"+strs[4]+"<br>"+
		                					 "答案："+json[index].answer+"<br>"+
				                			 "<input name='select' type='checkbox' value='"+json[index].itemId+"'/>"+
				                			 "</div><br>"
				                choice++;
		            		}
		                    else if(json[index].type == "judge"){//判断题
		                    	judgestr += "<br>"+judge +"."+ json[index].content + "<br>"+
		                		"<input name='X' type='radio' value='Y' />Y"+
		                		"<input name='X' type='radio' value='N' />N<br>"+
		                		"答案："+json[index].answer+"<br>"+
		                		"<input name='select' type='checkbox' value='"+json[index].itemId+"'/>"+"<br>"
		                		judge++;
		                    }
		            		
		
		    			});//list遍历完结

		    			choicestr += "</div>"//<div class='choiceCss'>标签补全
		    			blankfilingstr += "</div>"
		    			judgestr += "</div>"
		            	$("#blankfiling").html(blankfilingstr);
		            	$("#choice").html(choicestr);
		            	$("#judge").html(judgestr);
	        			
		            	//调用编程题
		            	$.ajax({  
				        url: 'GetProblem',
		                type: 'POST',  	//请求类型
		            	data: {page:"#page"},//上传数据
		                dataType: 'json',//返回类型  
		                //timeout: 1000,  //设定超时  
		                //cache: false,   //禁用缓存  
		                error: function(xml) {  
		                    alert("请求数据出错!");  
		                },
		                success: function(data){   //设置成功后回调函数
		            	var jsArray = eval(data.result);
		            
		            	var codestr = "" + "<div class='quanxuan'>"+
						 "<input name='all' id='codeall' type='checkbox' value='code'/>"+"全选"+
						 "</div>" + "<div class='codeCss'>";
					 

						$.each(jsArray, function(index,value){
							
							codestr += "<input name='select' type='checkbox' value='"+jsArray[index].problem_id+"'/>"
							 + jsArray[index].problem_id
							 +"&nbsp&nbsp"
							 + jsArray[index].title
							 +"<br>";
						});
						
						codestr += "</div>"
			            	$("#code").html(codestr);
							 
						 
		            	
		            	
		            	 }//成功回调函数完结
		            	});

	            	}//成功回调函数完结
	           }); //ajax函数完结
	        }); //@ sourceURL=pen.js
	       
	function sumbit(){
		var obj = $(":input[name='select']");
	    var index="";//结果存放处，类型为itemId1->itemId2->itemId3
	    for(var i=0; i<obj.length; i++){
		    if(obj[i].checked){
		    	index += obj[i].value + "->";
		    	
		    }
	    }
	    
	    $.ajax({  
		    url: 'itemlist',
		    type: 'POST',  	//请求类型
		    data: {"items":index},//上传数据
		    error: function(xml) {  
		    	alert("请求数据出错!");  
		    },
		    success: function(){
		    	window.location.href=("manageexamitemlist.jsp");
		    }
	    });
	}	        
</script>

<script src="../js/jquery.min.js"></script>
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
				<button id="left" type="button">筛选</button>
				<!-- 动态标签js -->
			</div>
			<div id="title-right">
				<a href="../indext.jsp">退出</a>
			</div>
		</div>
		<div id="content">
			<div class="contentCss">
				<div id="choice">
					<div id="quanxuan"></div>
					<br>
					<div>
						<hr>
					</div>
				</div>
			</div>
			<div class="contentCss">
				<div id="judge">
					<div id="quanxuan"></div>
					<br>
					<div>
						<hr>
					</div>
				</div>
			</div>
			
			<div class="contentCss">
				<div id="blankfiling">
					<div id="quanxuan"></div>
					<br>
					<div>
						<hr>
					</div>
				</div>
			</div>
			<div class="contentCss">
				<div id="code">
					<div id="quanxuan"></div>
					<br>
					<div>
						<hr>
					</div>
				</div>
				 <div class="code_pages" id="codes_box">  
		            <div class="code_pages">  
		                <span></span>  
		                <span></span>  
		                <span><a href="javascript:void(0);" class="prev">上一页</a></span>  
		                <div class="pages">  
		                    <div class="inner_pages J_pages"></div>  
		                </div>  
		                <span><a href="javascript:void(0);" class="next">下一页</a></span>  
		                <div>  
		                    <select id="select_pages"></select>  
		                </div>  
		            </div>  
		       	 </div>  
			</div>
			
			
			<div>
				<input type="submit" onclick="sumbit()" value="添加到题目清单" />
			</div>
		</div>
		<div id="left" style="display: none;">.</div>
	</div>
</body>
</html>