<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/proposeFeedback.do" method="post" enctype="multipart/form-data">  
   		<input id="user_id" name="userId" value="123"/>
   		<input id="content" name="detail" value="我是蔡康华">     
   		<input id="title" name="title" value="测试">     
        选择文件:<input type="file" name="image" width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  