<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/addMyShares.do" method="post">  
   		<input id="name" name="bookName" value="毛泽东思想">     
   		<input id="author" name="author" value="列宁">     
   		<input id="pubHouse" name="pubHouse" value="共产党出版社">     
   		<input id="pubHouse" name="delieverWay" value="0">     
   		<input id="send_time" name="send_time" value="2018-05-12">     
   		<input id="slotTime" name="slotTime" value="5:00-7:00">     
   		<input id="phone" name="phone" value="18129857238">     
   		<input id="userId" name="userId" value="123">     
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  