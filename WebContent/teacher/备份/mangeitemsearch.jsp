<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>管理题库查找</title>

<script src="../../js/jquery.js" type="text/javascript" language="javascript"></script>

<script src="../../js/advancedtable.js" type="text/javascript" language="javascript"></script>

<script language="javascript" type="text/javascript">

//	$().ready(function() {
//
//		$("#searchtable").show();
//
//		$("#table1").advancedtable({searchField: "#search", loadElement: "#loader", searchCaseSensitive: false, ascImage: "../images/up.png", descImage: "../images/down.png"});

//	});

$(document).ready(function(){
//	$("#searchtable").show();
//	$("#search").show();
//	$("#loader").show();
	$.ajax({  ///JZExamSystem/getAllItems.action
        url: 'getAllItems',
        type: 'POST',  	//请求类型
		//data: {},//上传数据
        dataType: 'json',//返回类型  
        //timeout: 1000,  //设定超时  
        //cache: false,   //禁用缓存  
        error: function(xml) {  
            alert("加载XML文档出错!");  
        },
        success: function(data){   //设置成功后回调函数
			var json = eval(data.result);
			var i=1;
			var htmlstr = "";
			var choicehtml = "";
			var judgehtml = "";
			$.each(json, function(index,value){
				if(json[index].type == "blankfiling"){
					htmlstr +=  "<tr><td>"+(index+1)+"</td>"+
									"<td><div class='blankfiling'><div class='blankfilingCss'>"+
									json[index].content+"<br>答案："+json[index].answer+"<br></div></div></td>"+
	            					"<td>"+json[index].time+"</td>"+
	            					"<td><a href='**'>删除</a></td></tr>"
				}
				else if(json[index].type == "choice"){
					str=json[index].content; //这是一字符串 
            		var strs= new Array(); 	 //定义一数组 
            		strs=str.split("->");    //字符分割 
            		
            		htmlstr += "<tr><td>"+(index+1)+"</td>"+
					"<td>"+
						"<div class='choice'>"+
						"<div class='choiceCss'>"+
						strs[0]+"<br>"+
						"<input name='radio' type='radio' value='A' />"+strs[1]+
						"<input name='radio' type='radio' value='B' />"+strs[2]+
						"<input name='radio' type='radio' value='C' />"+strs[3]+
						"<input name='radio' type='radio' value='D' />"+strs[4]+
						"<br>答案："+json[index].answer+"<br></div></div>"+
					"</td>"+
					"<td>"+json[index].time+"</td>"+
					"<td><a href='**'>删除</a></td></tr>"
				}else if(json[index].type == "judge"){//判断题
                   	htmlstr += "<tr>"+
                    "<td>"+(index+1)+"</td>"+
                    "<td>"+
                    	"<div id='judge'>"+
        					"<div class='judgeCss'>"+
        						json[index].content+"<br>"+
        						"<input name='X' type='radio' value='Y' />Y"+
        						"<input name='X' type='radio' value='N' />N<br>"+
        						"答案："+json[index].answer+"<br>"+
        					"</div>"+
        				"</div>"+
        			"</td>"+
        			"<td>"+json[index].time+"</td>"+	
                    "<td><a href='*'>删除</a></td>"+
                  "</tr>"
                }
				$("#tbcontent").html(htmlstr);
			});//遍历结束
		}//成功回调函数结束
	
    }); //ajax结束


	$("#searchtable").show();
	$("#table1").advancedtable({searchField: "#search", loadElement: "#loader", searchCaseSensitive: false, ascImage: "../images/up.png", descImage: "../images/down.png"});

});

</script>

<link href="../../css/lanrenzhijia.css" rel="stylesheet" type="text/css" />

<link href="../../css/advancedtable.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div id="topbanner">

  <div class="content">管理题库</div>

</div>

<div id="wrapper">

  <div id="maincontent">

      <table width="100%" class="normal" id="searchtable" border="0" cellspacing="4" cellpadding="0" style="display:none;">

        <tr>

        	输入题号或相关题目关键字：

          <td width="27%">

         	 <input name="search" type="text" id="search" style="display:none;" />

          </td>

          <td width="48%">

       		<div id="loader" style="display:none;">

         		<img src="../images/loader.gif" alt="Laoder" />

        	</div>

          </td>

          <td width="25%">

          <a href="manageitemadd.jsp" style="text-decoration:none;" >增加题目</a></td>

        </tr>

      </table>

      <table width="100%" id="table1" class="advancedtable" border="0" cellspacing="0" cellpadding="0">

        <thead>

          <tr>

            <th>题号</th>

            <th>试卷内容</th>

            <th>时间</th>

            <th>管理</th>            

          </tr>

        </thead>

        <tbody id="tbcontent">

          <tr>

            <td>1</td>

            <td>		

            <div id="choice">

			<div class="choiceCss">

				选择题题目<br>

				<input name="radio" type="radio" value="A" />A:A选项

				<input name="radio" type="radio" value="B" />B:B选项

				<input name="radio" type="radio" value="C" />C:C选项

				<input name="radio" type="radio" value="D" />D:D选项<br>

				答案：答案内容；<br>

			</div>

			</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>2</td>

            <td>

            	<div id="judge">

					<div class="judgeCss">

						判断题题目<br>

						<input name="X" type="radio" value="C" />Y

						<input name="X" type="radio" value="D" />N<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>	

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>3</td>

            <td>

				<div id="blankfiling">

				<div id="blankfilingCss">		

					填空题题目<br>

					答案：答案内容；<br>

				</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>4</td>

            <td>		

				<div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>			

          </tr>

          <tr>

            <td>5</td>

            <td>		

            <div id="choice">

			<div class="choiceCss">

				选择题题目<br>

				<input name="radio" type="radio" value="A" />A:A选项

				<input name="radio" type="radio" value="B" />B:B选项

				<input name="radio" type="radio" value="C" />C:C选项

				<input name="radio" type="radio" value="D" />D:D选项<br>

				答案：答案内容；<br>

			</div>

			</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>6</td>

            <td>		

        	    <div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>7</td>

            <td>		

          	  <div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>8</td>

            <td>		

				<div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>9</td>

            <td>		

				<div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>10</td>

            <td>		

				<div id="choice">

					<div class="choiceCss">

						选择题题目<br>

						<input name="radio" type="radio" value="A" />A:A选项

						<input name="radio" type="radio" value="B" />B:B选项

						<input name="radio" type="radio" value="C" />C:C选项

						<input name="radio" type="radio" value="D" />D:D选项<br>

						答案：答案内容；<br>

					</div>

				</div>

			</td>

			<td>2017/4/10/17:32</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>11</td>

            <td>		

            <div id="choice">

			<div class="choiceCss">

				选择题题目<br>

				<input name="radio" type="radio" value="A" />A:A选项

				<input name="radio" type="radio" value="B" />B:B选项

				<input name="radio" type="radio" value="C" />C:C选项

				<input name="radio" type="radio" value="D" />D:D选项<br>

				答案：答案内容；<br>

			</div>

			</div>

			</td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>12</td>

            <td><a href="**"> get试卷的标题4</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>13</td>

            <td><a href="**"> get试卷的标题</a></td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>14</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>15</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>16</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>17</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>18</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>19</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>20</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>21</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>22</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>23</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

            <td>24</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

          <tr>

            <td>25</td>

            <td><a href="**"> get试卷的标题</a> </td>

            <td><a href="**">删除</a></td>

          </tr>

        </tbody>

      </table>

    </div>

  </div>

</body>

</html>