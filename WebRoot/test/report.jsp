<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>举报测试</title>  
</head>  
<body>  
    <form action="http://localhost:8080/report.do" method="post" >  
   		<input id="userId" name="userId" value="userId">     
   		<input id="type" name="type" value="type">     
   		<input id="title" name="title" value="title">     
   		<input id="commentId" name="commentId" value="commentId">     
   		<input id="uCommentId" name="uCommentId" value="uCommentId">     
   		<input id="content" name="content" value="content">     
   		<input id="detail" name="detail" value="detail">     
        <input type="submit" value="投诉">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  