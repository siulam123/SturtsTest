<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>老师成绩查询</title>
<link href="../css/reachergrade.css" rel="stylesheet" type="text/css" />
<link href="../css/ks.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
</head>
<body>
  <div class="right" style="float:left;">            
      <h2 class="mbx">
				        查询成绩 &gt; <a href="#">资料中心</a></h2>
  		   <div class="feilei">
 		       <strong>查询方式</strong>&nbsp;&nbsp;&nbsp;&nbsp;
   			       按学生学号查询：
   		      <input type="text" align="middle" />&nbsp;&nbsp;
        		  按试卷名字查询：
	         <input type="text"  align="middle"/>
  	      </div>     
       	 <div class="cztable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
                <tr>
                <th width="10%">学年</th>
                <th width="6%">学期</th>
                    <th style="padding-left: 5px;">试卷的名称</th>
                    <th style="width: 15%; text-align: center;">考试的时间</th>
                    <th style="width: 15%; -align: center;"> 成绩</th>
                </tr>
                <tr>
                <td>2015-2016</td>
                    <td class="xxleft"> 1</td>
                    <td>2016年C++期末考试</td>
                    <td>2016-12-01</td>
                    <td>98</td>
                </tr>
                <tr>
	                <td>2016-2017</td>
	                <td class="xxleft"> 2</td>
	                <td>2017年java期中考试</td>
	                <td>2017-02-01</td>
	                <td>99</td>
                </tr>
            </table>
           </div>
       </div>
</body>
</html>
