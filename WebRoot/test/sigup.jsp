<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/signup.do" method="post" >  
   		<input id="stuNum" name="stuNum" value="2013">     
   		<input id="stuName" name="name" value="小菜">     
   		<input id="password" name="password" value="a5822738">     
   		<input id="phone" name="phone" value="18129857238">     
   		<input id="sex" name="sex" value="1">     
   		<input id="nickname" name="nickname" value="caikanhua">     
   		<input id="nickname" name="isValid" value="633261">     
   		<input id="nickname" name="verifycode" value="321602">
   		 <input type="submit" value="上传">      
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  