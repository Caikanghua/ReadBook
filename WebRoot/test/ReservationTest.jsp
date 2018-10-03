<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%> 
<%--  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/check.do" method="post">  
   		<input id="reservationId" name="reservationId" value="13567">     
   		<input id="pubHouse" name="userId" value="123">     
   		<input id="bookId" name="bookId" value="123">
   		<input id="phone" name="phone" value="18129857238">
   		<input id="reason" name="reason" value="看你不爽">
   		<input id="pubHouse" name="result" value="1">
        <input type="submit" value="check">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  