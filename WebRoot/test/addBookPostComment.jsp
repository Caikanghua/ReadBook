<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/comment.do" method="post">  
   		<input id="name" name="userId" value="123">     
   		<input id="author" name="content" value="内容">     
   		<input id="pubHouse" name="commentId" value="commentId">     
   		<input id="pubHouse" name="uCommentId" value="uCommentId">     
   		<input id="isbn" name="type" value="0">     
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  