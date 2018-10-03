<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/order.do" method="post">  
   		<input id="pubHouse" name="userId" value="123">     
   		<input id="bookId" name="bookId" value="90123">
   		<input id="phone" name="phone" value="18129857238">
   		<input id="timeSlot" name="timeSlot" value="12:00-13:00">
   		<input id="reason" name="taken_date" value="2017-08-20">
        <input type="submit" value="check">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  